package br.com.wgbn.pm_20160418_navigation_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroNivelFragment extends Fragment {

    private String mTipo;
    public static final String EXTRA_TIPO = "mTipo";

    public static PrimeiroNivelFragment novaInstancia(String tipo){
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        PrimeiroNivelFragment f = new PrimeiroNivelFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTipo = getArguments().getString(EXTRA_TIPO);
        View layout = inflater.inflate(R.layout.fragment_primeiro_nivel, container, false);
        TextView txtView = (TextView)layout.findViewById(R.id.txtView);
        txtView.setText(mTipo);
        return layout;
    }
}