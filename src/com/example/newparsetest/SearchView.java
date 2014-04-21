package com.example.newparsetest;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.parse.*;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchView extends ListActivity{
//	private ParseQueryAdapter<Child> Adapter;
	
	
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// initialize ParseQueryAdapater]

	ListView listView;	
		//Adapter=new ParseQueryAdapter<Child>(this, Child.class);
		ParseQueryAdapter<Child> adapter =
				  new ParseQueryAdapter<Child>(this, new ParseQueryAdapter.QueryFactory<Child>() {
				   
		public ParseQuery<Child> create() {
		      // Here we can configure a ParseQuery to our heart's desire.
		      ParseQuery query = new ParseQuery("Child");
		      query.whereEqualTo("firstName", SearchClass.getFirst());
		 
		      return query;
		    }
				  });
	//what to say
		adapter.setTextKey("TextKey");
		adapter.setImageKey("photo");
		
	setListAdapter(adapter);
	//=mainAdapter.setBackgroundDrawable(R.drawable.bg_card);
		
	
	
	}
		
}
