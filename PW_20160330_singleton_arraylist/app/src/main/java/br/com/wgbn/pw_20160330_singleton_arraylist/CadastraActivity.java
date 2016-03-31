package br.com.wgbn.pw_20160330_singleton_arraylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_cadastra);
    }

    public void cadClick(View v){
        ArraySingleton.getInstance().addItem(((EditText)findViewById(R.id.editText)).getText().toString());
        Intent volta = new Intent(this, MainActivity.class);
        setResult(1, volta);
        finish();
    }
}
