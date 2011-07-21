package com.centralmarket.hatch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MoreViewActivity extends Activity {
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_view);
        
        TextView tv = (TextView)findViewById(R.id.MoreViewHdrText);
        Typeface font = Typeface.createFromAsset(getAssets(), "texgyreherosbold.otf");
        tv.setTypeface(font);
        
        ImageButton roasting = (ImageButton)findViewById(R.id.roasting);
        roasting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), MoreSubViewActivity.class);
				intent.putExtra("ViewName", "WebView");
				startActivity(intent);	
			}
		});
        
        ImageButton findcm = (ImageButton)findViewById(R.id.cmstores);
        findcm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), MoreSubViewActivity.class);
				intent.putExtra("ViewName", "Store");
				startActivity(intent);
				
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	Intent intent = new Intent();
    	switch (item.getItemId()) {
        case R.id.recipes:
        	intent.putExtra("ViewName", "Recipes");
            intent.setClass(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
            return true;
        case R.id.favorites:
        	intent.putExtra("ViewName", "Favorites");
        	intent.setClass(getApplicationContext(), SecondActivity.class);
        	startActivity(intent);
            return true;
        case R.id.more:
        	intent.setClass(getApplicationContext(), MoreViewActivity.class);
        	startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}