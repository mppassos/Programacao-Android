package br.com.wgbn.pm_20160328_trabalho_prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.wgbn.pm_20160328_trabalho_prova.componentes.DividerItemDecoration;
import br.com.wgbn.pm_20160328_trabalho_prova.pojo.ClientePojo;
import br.com.wgbn.pm_20160328_trabalho_prova.utils.ClientesAdapter;

public class ListarActivity extends AppCompatActivity {

    private RecyclerView lista;
    private ArrayList<ClientePojo> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_listar);

        getSupportActionBar().setTitle(R.string.tituloListar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = (RecyclerView)findViewById(R.id.lstClientes);
        lista.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.abc_list_divider_mtrl_alpha)));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setLayoutManager(new LinearLayoutManager(this));

        carregaClientes();
    }

    private void voltaMain(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        setResult(3, intent);
        finish();
    }

    private void carregaClientes(){
        clientes = (ArrayList<ClientePojo>) ClientePojo.getAll();
        lista.setAdapter(new ClientesAdapter(this, clientes));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            voltaMain();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        voltaMain();
    }
}
