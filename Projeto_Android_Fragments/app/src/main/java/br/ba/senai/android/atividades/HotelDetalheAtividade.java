package br.ba.senai.android.atividades;

import br.ba.senai.android.mapeamento.Hotel;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 
 * @author Andre Portugal
 * sera usada em smartphones
 * no layout desta atividade so temos um frame e o fragment
 * sera adicionado em tempo de execucao
 */
public class HotelDetalheAtividade extends ActionBarActivity {

	public static final String EXTRA_HOTEL = "hotel";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_detalhe_hotel_atividade);
		Intent intent = getIntent(); 
		Hotel hotel = (Hotel) intent.getSerializableExtra(EXTRA_HOTEL);
		HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.detalhe, fragment, HotelDetalheFragment.TAG_DETALHE);
		ft.commit();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hotel_detalhe_atividade, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
