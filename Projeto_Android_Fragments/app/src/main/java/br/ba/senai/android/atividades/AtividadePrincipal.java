package br.ba.senai.android.atividades;

import br.ba.senai.android.mapeamento.Hotel;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;


public class AtividadePrincipal extends ActionBarActivity implements HotelListFragment.AoClicarNoHotel,
		SearchView.OnQueryTextListener,
		MenuItemCompat.OnActionExpandListener,
		GenericDialogFragment.AoClicarNoDialog,
		HotelDialogFragment.AoSalvarHotel{


	private FragmentManager mFragmentManager;
	private HotelListFragment mListFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_ap);

		mFragmentManager = getSupportFragmentManager();
		mListFragment = (HotelListFragment) mFragmentManager.findFragmentById(R.id.fragmentLista);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atividade_principal, menu);

		MenuItem searchItem = menu.findItem(R.id.action_search);
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		searchView.setOnQueryTextListener(this);
		searchView.setQueryHint(getString(R.string.hint_busca));
		MenuItemCompat.setOnActionExpandListener(searchItem, this);
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
		if (id == R.id.action_info){
			GenericDialogFragment dialog = GenericDialogFragment.novoDialog(
					// Id do dialog
					0,
					// título
					R.string.sobre_titulo,
					// mensagem
					R.string.sobre_mensagem,
					// texto dos botões
					new int[]{
							android.R.string.ok, // String do Android
							R.string.sobre_botao_site
					});
			dialog.abrir(mFragmentManager);
		}
		if (id == R.id.action_new){
			HotelDialogFragment hotelDialogFragment = HotelDialogFragment.novaInstancia(null);
			hotelDialogFragment.abrir(getSupportFragmentManager());
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void aoClicar(int id, int botao) {
		if (botao == DialogInterface.BUTTON_NEGATIVE) {
			Intent it = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.fieb.org.br/senai"));
			startActivity(it);
		}
	}

	// verificar o local de execucao celular ou tablet
	public void clicouNoHotel(Hotel hotel){
		if (isTablet()){
			HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);
			//FragmentManager fm = getSupportFragmentManager();
			//FragmentTransaction ft = fm.beginTransaction();
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			ft.replace(R.id.detalhe, fragment, HotelDetalheFragment.TAG_DETALHE);
			ft.commit();
		}else{
		 Intent it = new Intent(this,HotelDetalheAtividade.class);
		 it.putExtra(HotelDetalheAtividade.EXTRA_HOTEL, hotel);
		 startActivity(it);
		}
	}
	// verificar a existencia da pasta layout-large 
	// tela de pelo menos 640 dp x 480 dp
	private boolean isTablet()
	{
		return findViewById(R.id.detalhe) != null;
	}

	@Override
	public boolean onMenuItemActionExpand(MenuItem item) {
		return true;
	}

	@Override
	public boolean onMenuItemActionCollapse(MenuItem item) {
		mListFragment.limparBusca();
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		return true;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		mListFragment.buscar(newText);
		return false;
	}


	@Override
	public void salvouHotel(Hotel hotel) {
		mListFragment.adicionar(hotel);
	}
}
