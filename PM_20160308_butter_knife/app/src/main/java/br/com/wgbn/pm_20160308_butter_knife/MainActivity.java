package br.com.wgbn.pm_20160308_butter_knife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.com.crosp.solutions.library.prettytoast.PrettyToast;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.txtUm) EditText txtUm;
    @Bind(R.id.txtDois) EditText txtDois;
    @Bind(R.id.txtTres) EditText txtTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnUm)
    public void BtnUmClick(){
        PrettyToast.showWarning(getApplicationContext(), "Botão Um: "+txtUm.getText().toString());
    }

    @OnClick(R.id.btnDois)
    public void BtnDoisClick(){
        PrettyToast.showSuccess(getApplicationContext(), "Botão Dois: "+txtDois.getText().toString());
    }

    @OnClick(R.id.btnTres)
    public void BtnTresClick(){
        PrettyToast.showDim(getApplicationContext(), "Botão Três: "+txtTres.getText().toString());
    }
}
