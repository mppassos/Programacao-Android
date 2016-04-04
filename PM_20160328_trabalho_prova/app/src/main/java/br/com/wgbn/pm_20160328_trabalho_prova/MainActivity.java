package br.com.wgbn.pm_20160328_trabalho_prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
    }

    public void cadastrarClick(View v) {
        Intent cadastro = new Intent(this, CadastroActivity.class);
        startActivityForResult(cadastro, 1);
    }

    public void buscarClick(View v){
        Intent buscar = new Intent(this, BuscarActivity.class);
        startActivityForResult(buscar, 2);
    }

    public void listarClick(View v){
        Intent listar = new Intent(this, ListarActivity.class);
        startActivityForResult(listar, 3);
    }

    public void sairClick(View v){
        finish();
    }
}