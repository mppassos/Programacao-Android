package com.example.projeto_android_chamandoatividadecomlink;

import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.text.util.Linkify;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ChamandoActivitie extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_chamando_activitie);
		TextView txt1 = (TextView) findViewById(R.id.txtview);
		txt1.setText("Testando esse cep 55555-4444");
		Pattern pattern = Pattern.compile("\\d{5}([\\-]\\d{4})?");
		String scheme ="senai://";
		Linkify.addLinks(txt1, pattern, scheme);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chamando_activitie, menu);
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
