package com.example.projeto_android_navegacao;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class TelaAtividadeAgendamento extends ActionBarActivity {

	ViewPager mViewPager;
	SlidingTabLayout mSlidingTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tela_atividade_agendamento);

		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

		AbasPagerAdapter pagerAdapter = new AbasPagerAdapter(this, getSupportFragmentManager());
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(pagerAdapter);

		mSlidingTabLayout = (SlidingTabLayout)findViewById(R.id.tabs);
		mSlidingTabLayout.setDistributeEvenly(true);// abas de mesmo tamanho
		mSlidingTabLayout.setViewPager(mViewPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_atividade_agendamento, menu);
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
