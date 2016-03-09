package br.com.wgbn.pm_20160222_exercicio_001_componentes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhoneInfoHelper phoneInfo = new PhoneInfoHelper(this);
        String codigoDeArea = phoneInfo.getCodigoArea(true);
    }
}
