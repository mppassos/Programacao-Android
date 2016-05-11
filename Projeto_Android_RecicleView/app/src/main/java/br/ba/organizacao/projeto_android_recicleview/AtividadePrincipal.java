package br.ba.organizacao.projeto_android_recicleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtividadePrincipal extends AppCompatActivity implements BebidaListAdapter.OnDataSelected {

    private List<Bebida> bebidas = new ArrayList<Bebida>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_atividade_principal);

        obterListaBebidas();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true); // setHasFixed  que ajuda o nosso componente a ganhar desempenho. Uma vez que estamos dizendo que os elementos da lista terão tamanho fixo.

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // estamos assegurando que a RecyclerView vai se comportar como uma ListView (caso a orientação seja vertical) ou como um Gallery (caso a orientação seja horizontal).

        gridLayoutManager = new GridLayoutManager(this,2); // vamos definir que o RecyclerView apresente os itens tal como um GridView.

        recyclerView.setLayoutManager(linearLayoutManager); // Responsável por definir o jeito que os dados vão ser apresentados no RecyclerView.O padrão é o linear

        adapter = new BebidaListAdapter(this,this,bebidas);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.nova_bebida).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(0); //mover o foco da tela para o topo da lista,
                Bebida nova = new Bebida("Bebida " + bebidas.size(), "Ambev");
                bebidas.add(0, nova);
                adapter.notifyItemInserted(0);
            }

        });

        findViewById(R.id.button_change_layout).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(recyclerView.getLayoutManager() instanceof  GridLayoutManager) {
                    recyclerView.setLayoutManager(linearLayoutManager);
                } else {
                    recyclerView.setLayoutManager(gridLayoutManager);
                }
            }
        });

    }

    @Override
    public void onDataSelected(View view, int position) {
        Bebida selectedItem  = bebidas.get(position);
        Toast.makeText(this, "Item selecionado: " + selectedItem.getMarca(), Toast.LENGTH_SHORT).show();
        bebidas.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void obterListaBebidas() {
        for(int i = 0; i < 10; i ++) {
            Bebida novaB = new Bebida();
            novaB.setMarca("Bebida " + i);
            novaB.setModelo("Ambev");
            bebidas.add(novaB);
        }
    }
}
