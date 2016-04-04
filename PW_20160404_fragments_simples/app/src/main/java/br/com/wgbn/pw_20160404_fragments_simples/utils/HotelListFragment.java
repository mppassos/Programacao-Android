package br.com.wgbn.pw_20160404_fragments_simples.utils;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.wgbn.pw_20160404_fragments_simples.mapeamento.Hotel;

public class HotelListFragment extends ListFragment {
    private List<Hotel> mHotels;
    private ArrayAdapter<Hotel> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        carregarHoteis();
    }

    private void carregarHoteis(){
        mHotels = new ArrayList<Hotel>();
        mHotels.add(new Hotel("Hotel do Portuga", "Lauro de Freitas", 4.5f));
        mHotels.add(new Hotel("Hotel do Walter", "Abrantes", 5.0f));
        mHotels.add(new Hotel("Hotel do Theo", "Vilas do Atlêntico", 4.0f));
        mHotels.add(new Hotel("Hotel do Foguinho", "Pé Sujo", 1.0f));
    }
}
