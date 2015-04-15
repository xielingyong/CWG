package com.example.testdemo;

import com.example.testdemo.Utils.HTML5WebView;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


@TargetApi(Build.VERSION_CODES.KITKAT)
public class MainActivity extends Activity {

	private String url="http://mobile.wxb.com.cn";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		HTML5WebView h=new HTML5WebView(MainActivity.this);
		h.initView();
	}

	

}
