package br.com.wgbn.pm_20160316_exercicio_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.wgbn.pm_20160316_exercicio_login.components.MaskedEditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_cadastro);
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
