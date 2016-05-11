package br.com.wgbn.provaav2.Fragments;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import br.com.wgbn.provaav2.R;

public class LoginDialogFragment extends DialogFragment {

    private SharedPreferences shared;
    private EditText usuario;
    private EditText senha;
    private CheckBox chk;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_login, null);

        usuario = (EditText)view.findViewById(R.id.txtUsuario);
        senha = (EditText)view.findViewById(R.id.txtSenha);
        Button btnEntrar = (Button)view.findViewById(R.id.btnLoginEntrar);
        chk = (CheckBox)view.findViewById(R.id.chkLembrar);

        if (verificaSalvo()){
            usuario.setText(shared.getString("usuario", ""));
            senha.setText(shared.getString("senha", ""));
            chk.setChecked(true);
        }

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usuario.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()){
                    if (chk.isChecked()){
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putString("usuario", usuario.getText().toString());
                        editor.putString("senha", senha.getText().toString());
                        editor.commit();
                    }

                    if (usuario.getText().toString().equals("senai") && senha.getText().toString().equals("senai")){
                        fechar();
                    } else {
                        Toast.makeText(getContext(), "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chk.isChecked() && verificaSalvo()){
                    SharedPreferences.Editor editor = shared.edit();
                    editor.remove("usuario");
                    editor.remove("senha");
                    editor.commit();
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);

        return builder.create();
    }

    private boolean verificaSalvo(){
        shared = getContext().getSharedPreferences("av2", 0);
        return shared.getString("usuario", null) != null;
    }

    private void fechar(){
        this.dismiss();
    }
}
