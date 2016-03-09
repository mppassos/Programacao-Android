package br.com.wgbn.pw_20160219_criando_atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TerceiraAtividade extends AppCompatActivity {

    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_terceira_atividade);

        this.txtNome    = (TextView) findViewById(R.id.txtNome3);
        this.txtIdade   = (TextView) findViewById(R.id.txtIdade3);

        Intent intent = getIntent();

        this.txtNome.setText(intent.getExtras().getString("nome"));
        this.txtIdade.setText(intent.getExtras().getString("idade"));
    }
}
