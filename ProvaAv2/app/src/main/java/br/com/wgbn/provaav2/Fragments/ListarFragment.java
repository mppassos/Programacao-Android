package br.com.wgbn.provaav2.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.wgbn.provaav2.Adapters.EdicaoAdapter;
import br.com.wgbn.provaav2.Models.EdicaoModel;
import br.com.wgbn.provaav2.Pojo.EdicaoPojo;
import br.com.wgbn.provaav2.R;
import br.com.wgbn.provaav2.Services.EdicaoService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarFragment extends Fragment {

    public static ListarFragment ourInstance;
    private EdicaoAdapter adapter;
    private RecyclerView lista;
    private RecyclerView.LayoutManager layoutManager;

    public ListarFragment() {
        //EdicaoService.getInstance().mock();
    }

    public static ListarFragment getInstance(){
        if (ourInstance == null)
            ourInstance = new ListarFragment();
        return ourInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("wgbn", "onCreateView");
        View v = inflater.inflate(R.layout.layout_fragment_listar, container, false);
        lista = (RecyclerView)v.findViewById(R.id.listaEdicoes);
        lista.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); //new LinearLayoutManager(getContext());
        lista.setLayoutManager(layoutManager);

        List<EdicaoModel> edicoes = EdicaoService.getInstance().getEdicoes();
        adapter = new EdicaoAdapter(getContext(), edicoes);
        lista.setAdapter(adapter);
        lista.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

}
