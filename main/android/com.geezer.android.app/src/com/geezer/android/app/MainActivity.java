package com.geezer.android.app;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
//import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView webView = (WebView)findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient()); 
//		webView.setWebChromeClient(new WebChromeClient());
		webView.loadUrl("file:///android_asset/web/index.html");
	}
}
