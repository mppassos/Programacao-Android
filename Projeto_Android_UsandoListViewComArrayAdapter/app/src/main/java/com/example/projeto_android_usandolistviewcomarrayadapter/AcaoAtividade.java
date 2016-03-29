package com.example.projeto_android_usandolistviewcomarrayadapter;



import java.net.URI;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AcaoAtividade extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acao_atividade);
		TextView txt = (TextView) findViewById(R.id.txtAcao); 
		Intent it = getIntent();
		if (it.getAction().equals(Intent.ACTION_VIEW)){
			Uri uri = it.getData();
			txt.setText("Ação Customizada 2"+"URI:"+uri.toString()+"Host:"
			+uri.getHost()+"Path:"+uri.getPath());
		}
		else if(it.getAction().equals("senai.ACAO_CUSTOMIZADA")) {
			txt.setText("Ação Customizada 1");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acao_atividade, menu);
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
