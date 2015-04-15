package com.example.testdemo.Utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class HTML5WebView{
	private WebView webView;
	private Context mContext;
	private String murl="http://mobile.wxb.com.cn";
	public HTML5WebView(Context context){
		mContext=context;
	}
	
	public View initView(){
		webView=new WebView(mContext);
		LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		webView.setLayoutParams(params);
		
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setBuiltInZoomControls(true);	
		webView.setWebViewClient(new MyViewClient());
		webView.loadUrl(murl);
		Activity a =(Activity) mContext;
		a.setContentView(webView);
		return webView;
	}
	class MyViewClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			if(url.contains("tel")){
					Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + url.substring(3)));
					mContext.startActivity(intent);				
					return true;
			}else{
				webView.loadUrl(url);
			}
			return false;
		}
	}
}