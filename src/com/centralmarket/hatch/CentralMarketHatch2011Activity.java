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

public class CentralMarketHatch2011Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tv = (TextView)findViewById(R.id.titletext);
        Typeface font = Typeface.createFromAsset(getAssets(), "texgyreherosbold.otf");
        tv.setTypeface(font);
        
        
        ImageButton starters = (ImageButton)findViewById(R.id.Starters);
        starters.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SecondActivity.class);
				intent.putExtra("ViewName","Starters");
				startActivity(intent);	
			}
		});
        
        ImageButton mains = (ImageButton)findViewById(R.id.Mains);
        mains.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SecondActivity.class);
				intent.putExtra("ViewName","Mains");
				startActivity(intent);	
			}
		});
        
        ImageButton sides = (ImageButton)findViewById(R.id.Sides);
        sides.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SecondActivity.class);
				intent.putExtra("ViewName","Sides");
				startActivity(intent);	
			}
		});
        
        ImageButton desserts = (ImageButton)findViewById(R.id.Desserts);
        desserts.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SecondActivity.class);
				intent.putExtra("ViewName","Desserts");
				startActivity(intent);	
			}
		});
        
        ImageButton drinks = (ImageButton)findViewById(R.id.Drinks);
        drinks.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SecondActivity.class);
				intent.putExtra("ViewName","Drinks");
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
            intent.setClass(getApplicationContext(), SecondActivity.class);
            intent.putExtra("ViewName", "Recipes");
            startActivity(intent);
            return true;
        case R.id.favorites:
        	intent.setClass(getApplicationContext(), SecondActivity.class);
        	intent.putExtra("ViewName", "Favorites");
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