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
    private String mascara;
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

    public void setMascara(String mascara){
        this.mascara = mascara;
    }

    private void init(){

        mascara = carregaMascara();

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
                    /*if (texto.length() > 9) {
                        texto = texto.substring(0, 3) + "." +
                                texto.substring(3, 6) + "." +
                                texto.substring(6, 9) + "-" +
                                texto.substring(9);
                    } else if (texto.length() > 6) {
                        texto = texto.substring(0, 3) + "." +
                                texto.substring(3, 6) + "." +
                                texto.substring(6);
                    } else if (texto.length() > 3) {
                        texto = texto.substring(0, 3) + "." +
                                texto.substring(3);
                    }*/
                    if (texto.length() == 11){
                        texto = texto.replaceFirst("(.{3})(.{3})(.{3})(.{2})", "$1.$2.$3-$4");
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

    private String aplicaMascara(String texto){
        for (int i = this.posicoes.size(); i > 0; i--){
            if (texto.length() > this.posicoes.get(i).getPosicao()){
                for (int j = 0; j < texto.length(); j++){

                }
            }
        }
    }

    private String carregaMascara(){
        int qtde = 0;
        String retorno = "000.000.000-00";
        ArrayList<Posicao> posicoes = new ArrayList<Posicao>();

        if (atributos.getAttributeCount() > 0){
            for (int i = 0; i < atributos.getAttributeCount(); i++){
                if (atributos.getAttributeName(i) == "mask")
                    retorno = atributos.getAttributeValue(i);
            }
        }

        for (int i = 0; i < retorno.length(); i++){
            if ((retorno.charAt(i) >= '0' && retorno.charAt(i) <= '9'))
                qtde++;
            else
                posicoes.add(new Posicao(retorno.charAt(i), i));
        }

        this.posicoes = posicoes;
        this.qtdeChars = qtde;
        return retorno;
    }

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
