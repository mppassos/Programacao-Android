package br.com.wgbn.pw_20160222_001_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private PhoneInfoHelper infoHelper = null;
    private TextView txtCodigoArea, txtDeviceId, txtOperadora, txtNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodigoArea   = (TextView) findViewById(R.id.txtCodigoArea);
        txtDeviceId     = (TextView) findViewById(R.id.txtDeviceId);
        txtOperadora    = (TextView) findViewById(R.id.txtOperadora);
        txtNetwork      = (TextView) findViewById(R.id.txtNetwork);
    }

    public void getPhoneInfoClick(View v){
        if (infoHelper == null)
            infoHelper = new PhoneInfoHelper(this);

        txtCodigoArea.setText("Código Operadora:\t" + infoHelper.getCodigoArea(true));
        txtDeviceId.setText("Device Id:\t" + infoHelper.gerDeviceId(true));
        txtOperadora.setText("Operadora:\t" + infoHelper.getOperadora(true));
        txtNetwork.setText("Network:\t" + infoHelper.getNomeNetwork(true));
    }
}
