package br.com.wgbn.pm_20160309_obtendo_dados;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by walter on 09/03/16.
 */
public class TelaSelecaoActivity extends ListActivity {

    public static final String EXTRA_ESTADO = "estado";
    public static final String EXTRA_RESULTADO = "result";

    private ArrayList<String> estados = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        estados.add(new String("BA"));
        estados.add(new String("SP"));
        estados.add(new String("RJ"));

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, estados));

        String estado = getIntent().getStringExtra(EXTRA_ESTADO);

        if (estado != null){
            int position = Arrays.asList(estados).indexOf(estado);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(position,true);
        }

    }

    @Override
    protected  void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String result = l.getItemAtPosition(position).toString();
        Intent it = new Intent();

        it.putExtra(EXTRA_RESULTADO, result);
        setResult(RESULT_OK,it);
        finish();
    }
