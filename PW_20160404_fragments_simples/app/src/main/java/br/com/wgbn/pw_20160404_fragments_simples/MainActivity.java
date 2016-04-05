package br.com.wgbn.pw_20160404_fragments_simples;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.wgbn.pw_20160404_fragments_simples.mapeamento.Hotel;
import br.com.wgbn.pw_20160404_fragments_simples.utils.HotelListFragment;

public class MainActivity extends AppCompatActivity implements HotelListFragment.AoClicarNoHotel {

    private FragmentManager fragmentManager;
    private HotelListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        mListFragment = (HotelListFragment)fragmentManager.findFragmentById(R.id.fragList);
    }

    @Override
    public void clicouNoHotel(Hotel hotel) {
        Intent it = new Intent(this, HotelDetalheActivity.class);
        it.putExtra(HotelDetalheActivity.EXTRA_HOTEL, hotel);
        startActivity(it);
    }
}
