package com.example.newparsetest;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.parse.*;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchView extends Activity{
	private ParseQueryAdapter<Child> children;
	
	
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchlist);
		// initialize ParseQueryAdapater]
		ParseQueryAdapter.QueryFactory<Child> adapter =
				  new ParseQueryAdapter.QueryFactory<Child>() {
				   
		public ParseQuery<Child> create() {
		      // Here we can configure a ParseQuery to our heart's desire.
		      ParseQuery<Child> query = Child.getQuery();
		      query.whereStartsWith("firstName", SearchClass.getFirst());
		      query.setCachePolicy(ParseQuery.CachePolicy.NETWORK_ELSE_CACHE);
		      query.whereStartsWith("lastName", SearchClass.getLast());
		     query.whereEqualTo("age", SearchClass.getAge());
		     query.whereStartsWith("hometown", SearchClass.getHometown());
		      return query;
		    }
		
				  };
		children= new ParseQueryAdapter<Child> (this, adapter){
			@Override
			public View getItemView(Child list, View view, ViewGroup parent){
				if (view == null) {
			          view = View.inflate(getContext(), R.layout.listerboy, null);
			        }
			       // ParseImageView image = (ParseImageView) view.findViewById(R.id.icon);
			        TextView name = (TextView) view.findViewById(R.id.danames);
			        name.setText(list.getTextKey());
			        TextView home=(TextView) view.findViewById(R.id.dahometowns);
			        home.setText(list.getHometown());
			        TextView age=(TextView) view.findViewById(R.id.daages);
			        age.setText(list.getAge());
			        ParseObject photo = list.getParseObject("photo");
			          ParseImageView imageView  = (ParseImageView) view.findViewById(R.id.imageView);
			          imageView.setParseFile((ParseFile) list.getPhotoFile());
			          imageView.loadInBackground();
			   	   view.setBackgroundResource(R.drawable.list_decider);
			          return view;
			      }
			    };
			   children.setPaginationEnabled(false);
			   ListView listView=(ListView)this.findViewById(R.id.listView);
			   listView.setAdapter(children);
		
			   
		
	
	
	}
		
}


/*
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
		      query.whereStartsWith("firstName", SearchClass.getFirst());
		      query.setCachePolicy(ParseQuery.CachePolicy.NETWORK_ELSE_CACHE);
		      query.whereStartsWith("lastName", SearchClass.getLast());
		     query.whereEqualTo("age", SearchClass.getAge());
		     query.whereStartsWith("hometown", SearchClass.getHometown());
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
*/