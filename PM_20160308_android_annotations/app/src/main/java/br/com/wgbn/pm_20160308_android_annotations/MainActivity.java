package br.com.wgbn.pm_20160308_android_annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.myInput)
    EditText myInput;

    @ViewById(R.id.myTextView)
    TextView textView;

    @Click
    public void myButton(){
        String name = myInput.getText().toString();
        textView.setText("Hello "+name);
    }

}
