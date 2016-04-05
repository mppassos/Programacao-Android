package br.com.wgbn.pw_20160404_fragments_simples;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.wgbn.pw_20160404_fragments_simples.mapeamento.Hotel;

public class HotelDetalheActivity extends AppCompatActivity {

    public static final String EXTRA_HOTEL = "hotel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detalhe);

        Intent intent = getIntent();
        Hotel hotel = (Hotel)intent.getParcelableExtra(EXTRA_HOTEL);

        HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.detalhe, fragment, HotelDetalheFragment.EXTRA_HOTEL);
        ft.commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
