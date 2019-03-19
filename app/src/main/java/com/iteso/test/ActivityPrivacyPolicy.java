package com.iteso.test;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.iteso.test.tools.WebAppInterface;

public class ActivityPrivacyPolicy extends AppCompatActivity implements DialogInterface.OnKeyListener{

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        mWebView = null;
        mWebView = (WebView) findViewById(R.id.activity_privacy_policy_webView);
        mWebView.loadUrl("file:///android_asset/ItesoPrivacyPolicy.html");

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
// Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
// If it wasn't the Back key or there's no web page history,
// bubble up to the default
// system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}
