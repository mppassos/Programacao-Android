package br.com.wgbn.pm_20160316_exercicio_login.components;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Walter Gandarella on 16/03/2016.
 */
public class MaskedEditText extends EditText {

    private AttributeSet atributos;
    private int qtdeChars;
    private ArrayList<Posicao> posicoes;

    public MaskedEditText(Context context) {
        super(context);
        init();
    }

    public MaskedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.atributos = attrs;
        init();
    }

    public MaskedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.atributos = attrs;
        init();
    }

    public MaskedEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.atributos = attrs;
        init();
    }

    private void init(){

        carregaMascara();

        this.addTextChangedListener(new TextWatcher() {
            boolean isUpdating;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isUpdating) {
                    isUpdating = false;
                    return;
                }

                String texto = s.toString()
                        .replaceAll("[.]", "")
                        .replaceAll("[-]", "");

                if (count > before) {
                    if (texto.length() == qtdeChars){
                        //texto = texto.replaceFirst("(.{3})(.{3})(.{3})(.{2})", "$1.$2.$3-$4");
                        texto = texto.replaceFirst(criaRegEx(), criaReplace());
                    }

                    isUpdating = true;
                    setText(texto);
                    setSelection(getText().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * Cria uma string com a expressão regular passada como atributo no xml
     * @return String com a RegExp
     */
    private String criaRegEx(){
        String regEx = "";
        for (int i = 0; i < this.posicoes.size(); i++)
            if (i == 0)
                regEx += "(.{"+String.valueOf(this.posicoes.get(i).getPosicao())+"})";
            else
                regEx += "(.{"+String.valueOf(this.posicoes.get(i).getPosicao() - this.posicoes.get(i-1).getPosicao() - 1)+"})";

        if (this.posicoes.get(this.posicoes.size()-1).getPosicao() < qtdeChars)
            regEx += "(.{"+(qtdeChars - this.posicoes.get(this.posicoes.size()-1).getPosicao())+"})";

        Log.v("wgbn", "RegExp: "+regEx);
        return regEx;
    }

    /**
     * Cria a string com as posições do replacement da expressão regular
     * @return String replacement
     */
    private String criaReplace(){
        String replace = "";
        for (int i = 0; i < this.posicoes.size(); i++)
            replace += "$"+(i+1)+this.posicoes.get(i).getCaracter();

        if (this.posicoes.get(this.posicoes.size()-1).getPosicao() < qtdeChars)
            replace += "$"+(this.posicoes.size() + 1);

        Log.v("wgbn", "replaces: "+replace);
        return replace;
    }

    /**
     * Carrega a máscara vinda do xml
     * Se não for definida uma máscara via xml, assume-se o padrão de CPF
     * @return String máscara
     */
    private void carregaMascara(){
        int qtde = 0;
        String retorno = "000.000.000-00";
        ArrayList<Posicao> posicoes = new ArrayList<Posicao>();

            if (atributos.getAttributeCount() > 0)
                for (int i = 0; i < atributos.getAttributeCount(); i++)
                    if (atributos.getAttributeName(i).equals("mask"))
                        retorno = atributos.getAttributeValue(i);

        for (int i = 0; i < retorno.length(); i++)
            if ((retorno.charAt(i) >= '0' && retorno.charAt(i) <= '9'))
                qtde++;
            else
                posicoes.add(new Posicao(retorno.charAt(i), i));

        this.posicoes = posicoes;
        this.qtdeChars = qtde;
    }

    /**
     * POJO das posições da máscara
     */
    private class Posicao {
        private int posicao;
        private char caracter;
        public char getCaracter() {
            return caracter;
        }
        public int getPosicao() {
            return posicao;
        }
        public Posicao(char caracter, int posicao) {
            this.caracter = caracter;
            this.posicao = posicao;
        }
    }
}
