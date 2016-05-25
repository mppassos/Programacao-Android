package br.ba.senai.android.atividades;

import br.ba.senai.android.mapeamento.Hotel;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
/*
 * 
 */
public class HotelDetalheFragment extends Fragment {

	public static final String TAG_DETALHE = "tagDetalhe";
	public static final String EXTRA_HOTEL = "hotel";
	
	TextView mTextNome;
	TextView mTextEndereco;
	RatingBar mRatingEstrelas;
	Hotel mHotel;
	
	/**
	 * 
	 * Criar nova instancia recebendo como parametro um hotel
	 * Todo fragment deve ter por regra um construtor sem parametro
	 * conhecido como factory method
	 * usamos um objeto bundle para guardar o obj. hotel 
	 */
    public static HotelDetalheFragment novaInstancia(Hotel hotel){
    	Bundle parametros = new Bundle();
    	parametros.putSerializable(EXTRA_HOTEL,hotel);
    	HotelDetalheFragment fragment = new HotelDetalheFragment();
    	fragment.setArguments(parametros);
    	return fragment;
    }
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
		setHasOptionsMenu(true);
	}
	
	/**
	 * obrigado a sua implementacao quando herdamos de fragment
	 * inflater serve para capturar o layout
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	    View layout = inflater.inflate(R.layout.layout_detalhe_hotel, container, false);
	    mTextNome = (TextView) layout.findViewById(R.id.txtNome);
	    mTextEndereco = (TextView) layout.findViewById(R.id.txtEndereco);
	    mRatingEstrelas = (RatingBar) layout.findViewById(R.id.rtbestrelas);
	    if (mHotel != null){
	    	mTextNome.setText(mHotel.nome);
	    	mTextEndereco.setText(mHotel.endereco);
	    	mRatingEstrelas.setRating(mHotel.estrelas);
	    }
	    
	    return layout;
	}
	
	}
