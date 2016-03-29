package br.com.wgbn.pm_20160328_trabalho_prova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import br.com.wgbn.pm_20160328_trabalho_prova.componentes.WgbnMaskEditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText txtNome;
    private WgbnMaskEditText txtCpf;
    private WgbnMaskEditText txtTelefone;
    private EditText txtEndereco;
    private RadioGroup rdSexo;
    private Switch onoffAtivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_cadastro);

        txtNome = (EditText)findViewById(R.id.txtNome);
        txtCpf = (WgbnMaskEditText)findViewById(R.id.txtCpf);
        txtTelefone = (WgbnMaskEditText)findViewById(R.id.txtTelefone);
        txtEndereco = (EditText)findViewById(R.id.txtEndereco);
        rdSexo = (RadioGroup)findViewById(R.id.rdSexo);
        onoffAtivo = (Switch)findViewById(R.id.onoffAtivo);
    }

    private boolean validarCampos(){

        return false;
    }

    private void salvarCliente(){
        if (validarCampos()){

        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cadastro_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.btnSalvar) {
            salvarCliente();
            return true;
        } else if (id == R.id.btnCancelar){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
