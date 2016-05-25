package br.ba.senai.atividades;

import java.util.LinkedHashMap;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.content.res.Configuration;
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
	Fragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_principal);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name){
			public void onDrawerClosed(View view){
				super.onDrawerClosed(view);
				supportInvalidateOptionsMenu();
			}
            public void onDrawerOpened(View drawerView){
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
		//if (savedInstanceState == null){
			exibirItem(0);
		//}
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
		exibirItem(0);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	
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
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
            exibirItem(position);
    		
	}
	
	private void exibirItem(int position){
		String selecionado = mDrawerList.getItemAtPosition(position).toString();
		fragment = PrimeiroNivelFragment.novaInstancia(selecionado);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);
		
		switch(position) {
	    case 1:
	            Intent a = new Intent(AtividadePrincipal.this, Cadastro.class);
	            startActivity(a);
	    break;
	    case 2:
	           Intent b = new Intent(AtividadePrincipal.this, ListaClientes.class);
	           startActivity(b);
	           break;
	    default:
	    }
		
		
	}
	
	private void atualizarTitulo(boolean drawerIsOpen){
		if (drawerIsOpen){
			mToolbar.setTitle(R.string.app_name);
		}
		else {
			int posicaoAtual = mDrawerList.getCheckedItemPosition();
			String opcaoAtual = mDrawerList.getItemAtPosition(posicaoAtual).toString();
			mToolbar.setTitle(opcaoAtual);
			exibirItem(0);
		}
	}
}

