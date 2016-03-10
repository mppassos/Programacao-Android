package br.com.wgbn.pm_20160310_mapas_layout;

import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import br.com.wgbn.pm_20160310_mapas_layout.pojo.DonoPojo;
import br.com.wgbn.pm_20160310_mapas_layout.pojo.LocalPojo;
import br.com.wgbn.pm_20160310_mapas_layout.pojo.VagaPojo;

/**
 * Created by vivasalute on 10/03/16.
 */
public class MapaFragment extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private int resultCode;
    private RecyclerView mRecyclerView;
    private GoogleApiClient mGoogleApiClient;
    private VagasAdapter myAdapter;
    private Spinner spinner;
    private View myView;


    ArrayList<VagaPojo> list = new ArrayList<VagaPojo>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.layout_mapa_fragment, container, false);

        spinner = (Spinner)getActivity().findViewById(R.id.spinner_nav);
        spinner.setVisibility(View.GONE);

        mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                        @Override
                        public void onConnected(Bundle bundle) {
                            Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                            if (mLastLocation != null) {
                                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 12);
                                mMap.animateCamera(cameraUpdate);
                                Log.v("wgbn", String.valueOf(mLastLocation.getLatitude()));
                                Log.v("wgbn", String.valueOf(mLastLocation.getLongitude()));
                            }
                        }

                        @Override
                        public void onConnectionSuspended(int i) {

                        }
                    })
                    .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                        @Override
                        public void onConnectionFailed(ConnectionResult connectionResult) {

                        }
                    })
                    .addApi(LocationServices.API)
                    .build();
        }
        mGoogleApiClient.connect();

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView.setHasFixedSize(true);
        fetchData();

        resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (resultCode != ConnectionResult.SUCCESS){
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), 69);
            dialog.setCancelable(true);

            dialog.show();
        }

        return v;
    }

    public void fetchData() {
        VagaPojo vaga;
        DonoPojo dono;
        LocalPojo local;

        for (int i = 1; i < 7; i++){
            vaga = new VagaPojo();
            dono = new DonoPojo();
            local= new LocalPojo();

            dono.setNome("Fulano "+String.valueOf(i));
            dono.setCelular("71 99205-359"+String.valueOf(i));
            dono.setWhatsapp(i % 2 == 0 ? true : false);
            dono.setTelefone(i % 2 != 0 ? true : false);
            vaga.setDono(dono);

            local.setBairro("Centro");
            local.setCidade("Salvador");
            local.setEndereco("Rua dos Abatores, "+String.valueOf(i));
            local.setEstado("BA");
            local.setLatitude(-12.8624807+i);
            local.setLongitude(-38.295494+i);
            vaga.setLocal(local);

            vaga.setTempo(1);
            vaga.setFoto("https://i.ytimg.com/vi/j4swQ3wBFRI/hqdefault.jpg");
            vaga.setValor(new Float(0.74*i).floatValue());
            vaga.setLivre(i % 2 == 0 ? true : false);
            vaga.setTipoPagamento(VagaPojo.CARTAO);

            try {
                addToMap(vaga.getLocal().getLatLon(), vaga.getDono().getNome());
            }
            catch (NullPointerException e){

            }

            list.add(vaga);
        }

        myAdapter = new VagasAdapter(getActivity(), list);

        mRecyclerView.setAdapter(myAdapter);
    }

    private void addToMap(String latlong, String title){
        MarkerOptions markerOptions;
        LatLng position;
        String lati = latlong.substring(0, latlong.indexOf(",")),
                longi = latlong.substring(latlong.indexOf(",")+1, latlong.length());

        markerOptions = new MarkerOptions();

        position = new LatLng(Double.parseDouble(lati), Double.parseDouble(longi));
        markerOptions.position(position);
        markerOptions.title(title);
        mMap.addMarker(markerOptions);

        //CameraUpdate cameraPosition = CameraUpdateFactory.newLatLngZoom(position, 12);

        //mMap.animateCamera(cameraPosition);

    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onLocationChanged(Location location) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 12);
        mMap.animateCamera(cameraUpdate);
        Log.v("wgbn", String.valueOf(location.getLatitude()));
        Log.v("wgbn", String.valueOf(location.getLongitude()));
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public class VagasAdapter extends RecyclerView.Adapter<VagasAdapter.ViewHolder> {
        ArrayList<VagaPojo> itemsData;
        private Context context;

        private int lastPosition = -1;

        public VagasAdapter(Context context ,  ArrayList<VagaPojo> itemsData) {
            this.itemsData = itemsData;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, null);
            // create ViewHolder
            ViewHolder viewHolder = new ViewHolder(itemLayoutView);
            return viewHolder;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // - get data from your itemsData at this position
            // - replace the contents of the view with that itemsData
            setAnimation(viewHolder.itemView, position);

            viewHolder.txtViewTitle.setText(itemsData.get(position).getDono().getNome());
            viewHolder.valor.setText("R$ "+String.valueOf(itemsData.get(position).getValor()));
            viewHolder.tempo.setText(String.valueOf(itemsData.get(position).getTempo())+"h tempo mínimo");

            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }

        // inner class to hold a reference to each item of RecyclerView
        public  class ViewHolder extends RecyclerView.ViewHolder {

            public TextView txtViewTitle,
                    valor,
                    tempo;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);
                myView = itemLayoutView;
                txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
                valor = (TextView) itemLayoutView.findViewById(R.id.item_valor);
                tempo = (TextView) itemLayoutView.findViewById(R.id.item_tempo);

            }
        }


        // Return the size of your itemsData (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return itemsData.size();
        }

        private void setAnimation(View viewToAnimate, int position){
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition){
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }

}
