package com.example.newparsetest;
import java.util.HashMap;

import com.parse.ParseCloud;
import com.parse.Parse;
import com.parse.*;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;

public class hub extends Activity{
Button ViewChild;
Button AddChild;
Button About;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
	/*
		ParseCloud.callFunctionInBackground("hello", new HashMap<String, Object>(), new FunctionCallback<String>() {
			  public void done(String result, ParseException e) {
			    if (e == null) {
			      // result is "Hello world!"
			    }
			  }
			});
			*/
	setContentView(R.layout.hub);
	
	//View Child Button
	ViewChild= (Button) findViewById (R.id.nView);
	ViewChild.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent openViewChild= new Intent(hub.this, ViewChild.class);
			startActivity (openViewChild);
		}
	});
	
	//Add Child Button
	AddChild= (Button) findViewById (R.id.nNew);
	AddChild.setOnClickListener(new View.OnClickListener() {
		
	public void onClick (View view) {
		Intent openNewChild= new Intent(hub.this, NewChildActivity.class);
		startActivity(openNewChild);
	}
	
	});
	//About App Button
	About= (Button) findViewById (R.id.nAbout);
	About.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent openAbout= new Intent (hub.this,About.class);
		startActivity(openAbout);
		}
	});
	
	//Search App Button
		About= (Button) findViewById (R.id.nSearch);
		About.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent openSearch= new Intent (hub.this,SearchClass.class);
			startActivity(openSearch);
			}
		});
	
	}
}
