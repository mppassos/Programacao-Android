package br.ba.senai.atividades;

import java.util.List;




import br.ba.senai.dao.ClienteDAO;
import br.ba.senai.mapeamento.Cliente;
import br.ba.senai.mapeamento.ClienteAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListaClientes extends ActionBarActivity {

	ClienteAdapter adapterCliente;
	List<Cliente> clientes;
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.layout_lista_clientes);
		listView = new ListView(this);
		ClienteDAO dao = new ClienteDAO(this);
	    clientes = dao.listaTodos(null);
		adapterCliente = new ClienteAdapter(this, clientes);
		listView.setAdapter(adapterCliente);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Cliente cli = (Cliente) adapterView.getItemAtPosition(position);
				Toast.makeText(ListaClientes.this, "ID:"+cli.getId(), Toast.LENGTH_SHORT).show();
				
			}
	});

	
		setContentView(listView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_clientes, menu);
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
