package com.example.projeto_android_navegacao;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.content.res.Configuration;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AtividadePrincipal extends ActionBarActivity implements AdapterView.OnItemClickListener{

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private Toolbar mToolbar;
	private ActionBarDrawerToggle mDrawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_principal);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name){
			public void onDrawerClosed(View view){
				// chamado quando o menu lateral é fechado
				super.onDrawerClosed(view);
				supportInvalidateOptionsMenu(); // faz com que as ações da action bar sejam reconstruidas
			}
            public void onDrawerOpened(View drawerView){
				// chamado quando o menu lateral é aberto
				super.onDrawerOpened(drawerView);
				supportInvalidateOptionsMenu();
			}
			
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.opcoes));
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(this);
		if (savedInstanceState == null){
			exibirItem(0); // mostrar a primeira opção do menu na primeira execução
		}
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		atualizarTitulo(drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	/*@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atividade_principal, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
       if (mDrawerToggle.onOptionsItemSelected(item)){
    	   return true;
       }
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //exibirItem(position);
		switch(position){
			case 0 :{
				Intent i = new Intent(AtividadePrincipal.this, TelaAtividadeAgendamento.class);
				startActivity(i);
				break;
			}
			case 1 :{
				Intent i = new Intent(AtividadePrincipal.this, TelaAtividadeConsulta.class);
				startActivity(i);
				break;
			}
			case 2 :{
				Intent i = new Intent(AtividadePrincipal.this, TelaAtividadeOutros.class);
				startActivity(i);
				break;
			}

		}
		mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	private void exibirItem(int position){
		String selecionado = mDrawerList.getItemAtPosition(position).toString();
		Fragment fragment = PrimeiroNivelFragment.novaInstancia(selecionado);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);
		
	}
	
	private void atualizarTitulo(boolean drawerIsOpen){
		if (drawerIsOpen){
			mToolbar.setTitle(R.string.app_name);
		}
		else {
			int posicaoAtual = mDrawerList.getCheckedItemPosition();
			String opcaoAtual = mDrawerList.getItemAtPosition(posicaoAtual).toString();
			mToolbar.setTitle(opcaoAtual);
		}
	}
}
