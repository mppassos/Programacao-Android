package br.com.wgbn.pm_20160523_verify_connection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnConnClick(View v){
        if (this.isOnline()) {
            TextView txt = (TextView)findViewById(R.id.txtConn);
            txt.setText(this.getTipoConexao());
            Toast.makeText(MainActivity.this, this.isOnline() ? "Você está conectado no " + this.getTipoConexao() : "Você não está conectado", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public String getTipoConexao(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobi = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return wifi.isConnected() ? "WiFi" : mobi.isConnected() ? "3G/4G" : "Nenhuma";
    }
}
