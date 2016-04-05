package br.com.wgbn.pw_20160404_fragments_simples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.wgbn.pw_20160404_fragments_simples.mapeamento.Hotel;

public class HotelDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String EXTRA_HOTEL = "hotel";

    private TextView txtNome;
    private TextView txtEndereco;
    private RatingBar mRating;
    private Hotel mHotel;

    public static HotelDetalheFragment novaInstancia(Hotel hotel){
        Bundle parametros = new Bundle();
        parametros.putParcelable(EXTRA_HOTEL, hotel);
        HotelDetalheFragment hotelDetalheFragment = new HotelDetalheFragment();
        hotelDetalheFragment.setArguments(parametros);
        return hotelDetalheFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.layout_detalhe_hotel, container, false);
        txtNome = (TextView)layout.findViewById(R.id.txtNome);
        txtEndereco = (TextView)layout.findViewById(R.id.txtEndereco);
        mRating = (RatingBar)layout.findViewById(R.id.rtEstrelas);

        if (mHotel != null){
            txtNome.setText(mHotel.getNome());
            txtEndereco.setText(mHotel.getEndereco());
            mRating.setRating(mHotel.getEstrelas());
        }

        return  layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotel = (Hotel)getArguments().getParcelable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }
}
