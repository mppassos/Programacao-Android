package com.example.projeto_android_usandolistviewcomarrayadapter;

import android.support.v7.app.ActionBarActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewComArrayAdapter extends ListActivity {
    private static final String[] LISTA = {
    	"Browser","Discando Numeros", "Realizando Discagem", "Mapa",
    	"Tocar Musica", "SMS","Compartilhar","Minha Ação 1", "Minha Ação 2",
    	"Sair"
    };
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.layout_list_view_com_adapter);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LISTA);
		setListAdapter(adapter);
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_com_array_adapter, menu);
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
	*/
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
	     super.onListItemClick(l, v, position, id);
	     Uri uri = null;
	     Intent intent = null;
	     switch(position){
	     case 0:{
	    	      uri = Uri.parse("http://www.fieb.org.br/senai/");
	    	      intent = new Intent(Intent.ACTION_VIEW, uri);
	    	      startActivity(intent);
	    	      break;
	            }
	     case 1:{
   	              uri = Uri.parse("tel:99999999");
   	              intent = new Intent(Intent.ACTION_DIAL, uri);
   	              startActivity(intent);
   	              break;
                }
	     case 2:{
	              uri = Uri.parse("tel:99999999");
	              intent = new Intent(Intent.ACTION_CALL, uri);
	              startActivity(intent);
	              break;
                }
	     case 3:{
                  uri = Uri.parse("geo:0,0?q=Rua+Orlando Gomes,Salvador");
                  intent = new Intent(Intent.ACTION_VIEW, uri);
                  startActivity(intent);
                  break;
                }
	     case 4:{
                  uri = Uri.parse("file:///mnt/sdcard/musica.mp3");
                  intent = new Intent();
                  intent.setAction(Intent.ACTION_VIEW);
                  intent.setDataAndType(uri, "audio/mp3");
                  startActivity(intent);
                  break;
                 }
	     case 5:{
                  uri = Uri.parse("sms:12345");
                  intent = new Intent(Intent.ACTION_VIEW, uri);
                  intent.putExtra("sms_body", "Corpo do sms");
                  startActivity(intent);
                  break;
                }
	     case 6:{
                  Intent  sendIntent = new Intent();
                  sendIntent.setAction(Intent.ACTION_SEND);
                  sendIntent.putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent");
                  sendIntent.setType("text/plain");
                  startActivity(sendIntent);
                  break;
                }
	     case 7:{
                  intent = new Intent("senai.ACAO_CUSTOMIZADA");
                  
                  startActivity(intent);
                  break;
                }
	     case 8:{
                  uri = Uri.parse("produto://Notebook/Slim");
                  intent = new Intent(Intent.ACTION_VIEW, uri);
                  startActivity(intent);
                  break;
                }
	     default:finish();
	    	      
	     }
	}
	
}
