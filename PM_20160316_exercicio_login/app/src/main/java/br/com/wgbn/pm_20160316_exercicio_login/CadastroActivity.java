package br.com.wgbn.pm_20160316_exercicio_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.wgbn.pm_20160316_exercicio_login.components.MaskedEditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_cadastro);

        /*EditText cpf = getCpf();
        cpf.addTextChangedListener(new TextWatcher() {
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

                if (count > before){
                    if (texto.length() > 9){
                        texto = texto.substring(0, 3)+"."+
                                texto.substring(3, 6)+"."+
                                texto.substring(6, 9)+"-"+
                                texto.substring(9);
                    } else if (texto.length() > 6){
                        texto = texto.substring(0, 3)+"."+
                                texto.substring(3, 6)+"."+
                                texto.substring(6);
                    } else if (texto.length() > 3){
                        texto = texto.substring(0, 3)+"."+
                                texto.substring(3);
                    }
                    isUpdating = true;
                    getCpf().setText(texto);
                    getCpf().setSelection(getCpf().getText().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }

    private EditText getNome(){
        return (EditText) findViewById(R.id.nome);
    }

    private EditText getEmail(){
        return (EditText) findViewById(R.id.email);
    }

    private MaskedEditText getCpf(){
        return (MaskedEditText) findViewById(R.id.cpf);
    }

    public void btnCadastrarClick(View v){
        if (getNome().getText().length() > 0 && getEmail().getText().length() > 0 && getCpf().getText().length() > 0){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
            setResult(1);
            finish();
        } else {
            Toast.makeText(this, "Preencha todos os dados.", Toast.LENGTH_LONG).show();
        }
    }
}
