package br.com.wgbn.provaav2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.wgbn.provaav2.Adapters.EdicaoAdapter;
import br.com.wgbn.provaav2.Pojo.EdicaoPojo;
import br.com.wgbn.provaav2.R;
import br.com.wgbn.provaav2.Services.EdicaoService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarFragment extends Fragment {

    private EdicaoAdapter adapter;
    private RecyclerView lista;
    private RecyclerView.LayoutManager layoutManager;

    public ListarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_listar, container, false);
        lista = (RecyclerView)v.findViewById(R.id.listaEdicoes);
        lista.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        lista.setLayoutManager(layoutManager);

        EdicaoService.getInstance().mock();
        List<EdicaoPojo> edicoes = EdicaoService.getInstance().getEdicoes();
        adapter = new EdicaoAdapter(getContext(), edicoes);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }

}
