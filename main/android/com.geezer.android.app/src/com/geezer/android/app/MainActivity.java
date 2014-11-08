package com.geezer.android.app;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView.setWebContentsDebuggingEnabled(true);
		WebView webView = (WebView)findViewById(R.id.webView);
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setAllowFileAccessFromFileURLs(true);
		webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
		webView.getSettings().setDatabaseEnabled(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebChromeClient(new WebChromeClient() {
		  public boolean onConsoleMessage(ConsoleMessage cm) {
		    Log.d("MyApplication", cm.message() + " -- From line "
		                         + cm.lineNumber() + " of "
		                         + cm.sourceId() );
		    return true;
		  }
		});
		webView.setWebViewClient(new MyWebViewClient()); 
//		webView.setWebChromeClient(new WebChromeClient());
		webView.loadUrl("file:///android_asset/web/index.html");
//		webView.loadUrl("http://www.google.com");
	}
	
	private static class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return false;
		}
	}
}
