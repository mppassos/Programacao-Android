package br.com.wgbn.pw_20160404_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "senai");
        webView.loadUrl("file:///android_asset/pagina.html");
        webView.setWebViewClient(new MyWebViewCliente());
    }

    @JavascriptInterface
    public void showToast(String s, String t){
        Toast.makeText(this, "Nome: "+s+" Idade: "+t, Toast.LENGTH_LONG).show();
    }
}
