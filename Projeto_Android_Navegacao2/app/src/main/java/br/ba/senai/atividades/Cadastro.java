package br.ba.senai.atividades;

import br.ba.senai.dao.ClienteDAO;
import br.ba.senai.mapeamento.Categoria;
import br.ba.senai.mapeamento.Cliente;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends ActionBarActivity implements OnClickListener{

	Cliente cliente;
	EditText nome;
	EditText endereco;
	EditText categoria;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atendimento);
		nome = (EditText) findViewById(R.id.editText1);
		endereco = (EditText) findViewById(R.id.editText2);
		categoria = (EditText) findViewById(R.id.editText3);
		Button botGravar = (Button) findViewById(R.id.button1);
		
		botGravar.setOnClickListener(this);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atendimento, menu);
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



	@Override
	public void onClick(View v) {
		try {
			cliente = new Cliente();
			cliente.setNome(nome.getText().toString());
			cliente.setEndereco(endereco.getText().toString());
			Categoria cat = new Categoria();
			cat.setNomecategoria(categoria.getText().toString());
			cliente.setCategoria(cat);
			ClienteDAO dao = new ClienteDAO(this);
			dao.salvar(cliente);

			Toast.makeText(this, "Operação Concluida com sucesso!", Toast.LENGTH_LONG).show();
			finish();

		}
		catch(Exception e){
			Toast.makeText(this, "Não foi Possível incluir cliente!", Toast.LENGTH_LONG).show();
		}
	}
}
