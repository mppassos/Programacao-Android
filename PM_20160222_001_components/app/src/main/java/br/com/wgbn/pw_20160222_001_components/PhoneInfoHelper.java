package br.com.wgbn.pw_20160222_001_components;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Walter on 28/02/2016.
 */
public class PhoneInfoHelper {

    private Context contexto;
    private TelephonyManager telephonyManager;

    public PhoneInfoHelper(Context ctx){
        this.contexto = ctx;
        this.telephonyManager = (TelephonyManager) this.contexto.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public String getCodigoArea(Boolean logCat){
        String codigoDeArea = this.telephonyManager.getSimOperator();
        if (logCat)
            Log.d("Código de operadora: ", codigoDeArea);
        return codigoDeArea;
    }

    public String gerDeviceId(Boolean logCat){
        String deviceId = telephonyManager.getDeviceId();
        if (logCat)
            Log.d("Device Id: ", deviceId);
        return deviceId;
    }

    public String getOperadora(Boolean logCat){
        String operadora = telephonyManager.getSimOperatorName();
        if (logCat)
            Log.d("Operadora: ", operadora);
        return operadora;
    }

    public String getNumeroTelefone(Boolean logCat){
        String numero = telephonyManager.getLine1Number();
        if (logCat)
            Log.d("Número do telefone: ", numero);
        return numero;
    }

    public String getNomeNetwork(Boolean logCat){
        String nomeNet = telephonyManager.getNetworkOperatorName();
        if (logCat)
            Log.d("Nome da Rede: ", nomeNet);
        return nomeNet;
    }

}
