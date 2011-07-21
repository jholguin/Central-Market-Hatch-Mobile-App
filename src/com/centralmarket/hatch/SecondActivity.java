package com.centralmarket.hatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
  
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		Bundle extras = getIntent().getExtras();
		setView(extras);
		
	}
	
	public void setView(Bundle extras){
		TextView tv = (TextView)findViewById(R.id.SecondViewHdrText);
		tv.setText(extras.getString("ViewName"));
		Typeface font = Typeface.createFromAsset(getAssets(), "texgyreherosbold.otf");
        tv.setTypeface(font);		
        
        String[] from = {"Name"};
        int[] to = {R.id.list_item};
        
        List<Map<String,Object>> info = getPlaces();
       
        SimpleAdapter sa = new SimpleAdapter(this, info, R.layout.list_view_items, from, to);
        ListView lv = (ListView)findViewById(R.id.ListItems);
        lv.setAdapter(sa);
        
		
	}
	
	private List<Map<String, Object>> getPlaces() {
		final List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		BufferedReader in = null;
		
        try{
        	HttpClient client = new DefaultHttpClient();
        	HttpGet request = new HttpGet();
        	request.setURI(new URI("http://centralmarketreview.springbox.com/hatchreceipes.aspx"));
        	
        	HttpResponse response = client.execute(request);
        	in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        	StringBuilder sb = new StringBuilder();
        	String line = null;
        	
        	while((line = in.readLine()) != null){
        		sb.append(line);
        	}
        	in.close();
        	String result = sb.toString();
        	JSONObject json = new JSONObject(result);
        	JSONObject jobj = json.getJSONObject("CMReceipes");
        	JSONArray receipeArray = jobj.getJSONArray("CMReceipe");
        	
        	for(int i=0; i < receipeArray.length();i++){
        		Map<String, Object> map = new HashMap<String, Object>();
        		JSONObject object = receipeArray.getJSONObject(i);
        		map.put("_id", object.getString("id"));
        		map.put("Name",object.getString("Name"));
        		data.add(map);
        	}	
        	
        }catch(Exception e){
        	Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }	
        
        return data;
	}
}
