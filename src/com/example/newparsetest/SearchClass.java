package com.example.newparsetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class SearchClass extends Activity {
	public static String searchFirstName;
	public static String searchLastName;
	public static String searchHometown;
	String searchAge;
	Button bSearch;
	EditText sfirstName;
	EditText slastName;
	EditText shometown;
	EditText sage;
	public static int convert=9000;
	public static String getFirst()
	{return searchFirstName;}
	public static String getLast()
	{return searchLastName;}
	public static String getHometown()
	{return searchHometown;}
	public static int getAge()
	{
		if (convert!=9000){
		return convert;
		}
		else{
			return 0;
		}
		}
		@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.searchview);

		   sfirstName =(EditText)findViewById(R.id.sFirstName);
	    	sage=(EditText) findViewById(R.id.sAge);
	    	slastName =(EditText)findViewById(R.id.sLastName);
	    	shometown =(EditText)findViewById(R.id.sHometown);
	    	
	    	
	    	bSearch= (Button)findViewById(R.id.nNewSearch);

			bSearch.setOnClickListener(new View.OnClickListener() {
		@Override
				public void onClick(View view){
			int length=sage.getText().length();
			searchFirstName=sfirstName.getText().toString();
			searchAge=sage.getText().toString();
			searchLastName=slastName.getText().toString();
			searchHometown=shometown.getText().toString();
			if(length!=0){
				convert=Integer.parseInt(searchAge);
					
			}
		
			Intent openHubFromSearch= new Intent(SearchClass.this, SearchView.class);
			startActivity(openHubFromSearch);	
		}
		   
	});
	    	
}
		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
		
			finish();
		}
}
