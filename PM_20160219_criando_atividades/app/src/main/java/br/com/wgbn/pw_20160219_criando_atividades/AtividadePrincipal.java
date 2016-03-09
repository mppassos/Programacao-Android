package br.com.wgbn.pw_20160219_criando_atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AtividadePrincipal extends AppCompatActivity {

    private EditText edtNome, edtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_atividade_principal);

        this.edtNome    = (EditText) findViewById(R.id.edtNome);
        this.edtIdade   = (EditText) findViewById(R.id.edtIdade);
    }

    public void BtnCarregarClick(View v){
        Intent intent = new Intent(this, SegundaAtividade.class);
        intent.putExtra("nome", this.edtNome.getText().toString());
        intent.putExtra("idade", this.edtIdade.getText().toString());
        startActivity(intent);
    }

    public void BtnCarregar2Click(View v){
        Bundle bundle = new Bundle();
        bundle.putString("nome", this.edtNome.getText().toString());
        bundle.putString("idade", this.edtIdade.getText().toString());

        Intent intent = new Intent(this, TerceiraAtividade.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void BtnCarregar3Click(View v){
        Cliente cliente = new Cliente(this.edtNome.getText().toString(), this.edtIdade.getText().toString());

        Intent intent = new Intent(this, QuartaAtividade.class);
        intent.putExtra("cliente", cliente);
        startActivity(intent);
    }
}
