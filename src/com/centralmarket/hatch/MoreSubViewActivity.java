package com.centralmarket.hatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MoreSubViewActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle extras = getIntent().getExtras();
        WebView wv = new WebView(this);
		if(extras.getString("ViewName").equalsIgnoreCase("WebView")){
			wv.loadUrl("http://www.centralmarket.com/m/hatch.aspx");
			wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
			setContentView(wv);
			
		}else if(extras.getString("ViewName").equalsIgnoreCase("Store")){
			wv.loadUrl("http://www.centralmarket.com/");
			wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
			setContentView(wv);
		}
    }

}
