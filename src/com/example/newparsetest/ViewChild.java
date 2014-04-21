package com.example.newparsetest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.parse.ParseObject;

import com.parse.ParseQueryAdapter;
import android.widget.TextView;
public class ViewChild extends Activity{
	
	//private ParseQueryAdapter<Child> mainAdapter;

	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// initialize ParseQueryAdapater]
		  setContentView(R.layout.viewview);
		 ListView listView = (ListView) findViewById(R.id.lisp);	
		  ParseQueryAdapter<Child> mainAdapter=new ParseQueryAdapter<Child>(this, "Child");
		
	//what to say
		mainAdapter.setTextKey("TextKey");
		mainAdapter.setImageKey("photo");
		
	listView.setAdapter(mainAdapter);
	//=mainAdapter.setBackgroundDrawable(R.drawable.bg_card);
		

	
	}
	
	/*@Override
	public View getItemView(ParseObject Child, View v, ViewGroup parent) {
		  super.getItemView(Child, v, parent);
		if (v == null) {
	    v = View.inflate(getContext(), R.layout.viewview, null);
	  }
	 
	  // Take advantage of ParseQueryAdapter's getItemView logic for
	  // populating the main TextView/ImageView.
	  // The IDs in your custom layout must match what ParseQueryAdapter expects
	  // if it will be populating a TextView or ImageView for you.
	
	 
	  // Do additional configuration before returning the View.
	  TextView descriptionView = (TextView) v.findViewById(R.id.label);
	  descriptionView.setText(Child.getString("description"));
	  return v;
	}
	*/
	
	
	
	

}
