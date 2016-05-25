package br.ba.senai.android.atividades;

import java.util.ArrayList;
import java.util.List;

import br.ba.senai.android.mapeamento.Hotel;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


// Similar a classe ListActivity
/**
 * 
 * @author Andre Portugal
 * Nao �eobrigado implementar onCreateView a classe ja cria um listView
 */
public class HotelListFragment extends ListFragment{
   List<Hotel> mHoteis;
   ArrayAdapter<Hotel> madapter;

   @Override
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   setRetainInstance(true);
	   mHoteis = carregarHoteis();
   }
   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);

	madapter = new ArrayAdapter<Hotel>(getActivity(), android.R.layout.simple_list_item_1,mHoteis);
    setListAdapter(madapter);
	   //limparBusca();
   }

   private List<Hotel> carregarHoteis(){
	List<Hotel> hotels = new ArrayList<Hotel>();
	hotels.add(new Hotel("Hotel do Portuga", "Lauro de Freitas", 4.5f));
	hotels.add(new Hotel("Hotel brezzes", "Costa do Sauipe", 3.5f));
	hotels.add(new Hotel("IberoStar", "Praia do Forte", 4.0f));
	hotels.add(new Hotel("GrandPalladium", "Imbassai", 2.5f));
	return hotels;
   }
 // No segundo momento implementar este codigo
   public void onListItemClick(ListView l, View v, int position, long id){
	   super.onListItemClick(l, v, position, id);
	   Activity activity = getActivity();
	   if (activity instanceof AoClicarNoHotel){
		   Hotel hotel = (Hotel)l.getItemAtPosition(position);
		   AoClicarNoHotel listener = (AoClicarNoHotel)activity;
		   listener.clicouNoHotel(hotel);
	   }
   }

	public void buscar(String s) {
		if (s == null || s.trim().equals("")) {
			limparBusca();
			return;
		}

		List<Hotel> hoteisEncontrados = new ArrayList<Hotel>(mHoteis);

		for (int i = hoteisEncontrados.size()-1; i >= 0; i--) {
			Hotel hotel = hoteisEncontrados.get(i);
			if (! hotel.nome.toUpperCase().contains(s.toUpperCase())) {
				hoteisEncontrados.remove(hotel);
			}
		}


		madapter = new ArrayAdapter<Hotel>(
				getActivity(),
				android.R.layout.simple_list_item_1,
				hoteisEncontrados);
		setListAdapter(madapter);
	}

	public void limparBusca() {


		madapter = new ArrayAdapter<Hotel>(getActivity(),
				android.R.layout.simple_list_item_1,
				mHoteis);

		setListAdapter(madapter);
	}

   public interface AoClicarNoHotel{
	   void clicouNoHotel(Hotel hotel);
   }

   public void adicionar(Hotel hotel){
	   mHoteis.add(hotel);
	   madapter.notifyDataSetChanged();
   }

}
