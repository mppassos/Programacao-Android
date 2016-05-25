package br.ba.senai.atividades;

import java.util.LinkedHashMap;
import java.util.List;

import br.ba.senai.dao.ClienteDAO;
import br.ba.senai.mapeamento.Cliente;
import br.ba.senai.mapeamento.ClienteAdapter;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PrimeiroNivelFragment extends Fragment implements View.OnClickListener{

	private static final String EXTRA_TIPO = "mTipo";
	private String mTipo;
	private LinkedHashMap<String, Class> mAcoes;
	
	
	public static PrimeiroNivelFragment novaInstancia(String tipo){
		Bundle params = new Bundle();
		params.putString(EXTRA_TIPO, tipo);
		PrimeiroNivelFragment f = new PrimeiroNivelFragment();
		f.setArguments(params);
		return f;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mAcoes = new LinkedHashMap<String, Class>();
		String[] opcoes = getResources().getStringArray(R.array.opcoes);
		mAcoes.put(opcoes[0], Cadastro.class);
		//mAcoes.put(opcoes[1], TelaAtividadeConsulta.class);
		//mAcoes.put(opcoes[2], TelaAtividadeOutros.class);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		mTipo = getArguments().getString(EXTRA_TIPO);
	    //View layout = inflater.inflate(R.layout.layout_primeiro_nivel_fragment, container, false);
		ListView layout = new ListView(getActivity());
		ClienteDAO dao = new ClienteDAO(getActivity());
	    List<Cliente> clientes = dao.listaTodos(null);
		ClienteAdapter adapterCliente = new ClienteAdapter(getActivity(), clientes);
		layout.setAdapter(adapterCliente);
		
		return layout;
	}
	
	@Override
	public void onClick(View v) {
		Class classe = mAcoes.get(mTipo);
		startActivity(new Intent(getActivity(), classe));
		
	}



}
