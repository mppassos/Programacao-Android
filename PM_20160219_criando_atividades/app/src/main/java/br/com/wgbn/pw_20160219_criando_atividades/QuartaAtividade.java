package br.com.wgbn.pw_20160219_criando_atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuartaAtividade extends AppCompatActivity {

    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quarta_atividade);

        this.txtNome = (TextView) findViewById(R.id.txtNome4);
        this.txtIdade= (TextView) findViewById(R.id.txtIdade4);

        Intent intent = getIntent();

        Cliente cliente = intent.getParcelableExtra("cliente");

        if (cliente != null){
            this.txtNome.setText(cliente.getNome());
            this.txtIdade.setText(cliente.getIdade());
        }
    }
}
