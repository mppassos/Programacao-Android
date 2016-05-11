package br.com.wgbn.provaav2.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import br.com.wgbn.provaav2.Models.EdicaoModel;
import br.com.wgbn.provaav2.Pojo.EdicaoPojo;
import br.com.wgbn.provaav2.R;
import br.com.wgbn.provaav2.Services.EdicaoService;

public class CadastrarFragment extends Fragment {

    private Button btnCadSalvar;
    private Button btnCadCancelar;
    private Button btnCadBuscar;
    private EditText txtTitulo;
    private EditText txtSubTitulo;
    private EditText txtEditora;
    private EditText txtCapa;
    private EditText txtAno;
    private EditText txtNumero;

    public CadastrarFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true); //Will ignore onDestroy Method (Nested Fragments no need this if parent have it)
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        onViewStateRestored(savedInstanceState);
        View vi = inflater.inflate(R.layout.layout_fragment_cadastrar, container, false);

        btnCadSalvar = (Button)vi.findViewById(R.id.btnCadSalvar);
        btnCadCancelar = (Button)vi.findViewById(R.id.btnCadCancelar);
        btnCadBuscar = (Button)vi.findViewById(R.id.btnCadBuscar);

        txtTitulo = (EditText)vi.findViewById(R.id.txtTitulo);
        txtSubTitulo = (EditText)vi.findViewById(R.id.txtSubTitulo);
        txtEditora = (EditText)vi.findViewById(R.id.txtEditora);
        txtCapa = (EditText)vi.findViewById(R.id.txtCapa);
        txtAno = (EditText)vi.findViewById(R.id.txtAno);
        txtNumero = (EditText)vi.findViewById(R.id.txtNumero);

        btnCadSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos()){
                    EdicaoModel e = new EdicaoModel();
                    e.setTitulo(txtTitulo.getText().toString());
                    e.setSubtitulo(txtSubTitulo.getText().toString());
                    e.setEditora(txtEditora.getText().toString());
                    e.setCapa(txtCapa.getText().toString());
                    e.setAno(new Integer(txtAno.getText().toString()).intValue());
                    e.setNumero(new Integer(txtNumero.getText().toString()).intValue());
                    EdicaoService.getInstance().add(e);
                    voltarListagem(v);
                } else {
                    Toast.makeText(getContext(), "Você deve preencher todos os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCadCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarListagem(v);
            }
        });

        btnCadBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtTitulo.getText().toString().isEmpty() && !txtSubTitulo.getText().toString().isEmpty()){
                    String url = "https://www.google.com.br/search?q="+txtTitulo.getText().toString()+" "+txtSubTitulo.getText().toString()+" cover capa&biw=300&bih=785&source=lnms&tbm=isch&sa=X";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });

        return vi;
    }

    private void voltarListagem(View v){
        FragmentManager fragmentManager = getFragmentManager();

        Fragment listar = ListarFragment.getInstance();
        fragmentManager.beginTransaction().replace(R.id.contents, listar).commit();
    }

    private boolean validaCampos(){
        return !(
            txtTitulo.getText().toString().isEmpty() ||
            txtAno.getText().toString().isEmpty() ||
            txtNumero.getText().toString().isEmpty() ||
            txtCapa.getText().toString().isEmpty() ||
            txtEditora.getText().toString().isEmpty() ||
            txtSubTitulo.getText().toString().isEmpty()
        );
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
