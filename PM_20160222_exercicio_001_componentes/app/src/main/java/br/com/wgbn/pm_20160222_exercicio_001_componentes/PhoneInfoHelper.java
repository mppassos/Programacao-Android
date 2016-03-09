package br.com.wgbn.pm_20160222_exercicio_001_componentes;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Walter on 28/02/2016.
 */
public class PhoneInfoHelper {

    private Activity activity;

    public PhoneInfoHelper((Activity activity){
        this.activity = activity;
    }

    public String getCodigoArea(Boolean logCat){
        TelephonyManager telephonyManager = (TelephonyManager) this.activity.getSystemService(Context.TELEPHONY_SERVICE);
        String codigoDeArea = telephonyManager.getSimOperator();

        if (logCat)
            Log.d("Código de área: ", codigoDeArea);

        return codigoDeArea;
    }

}
