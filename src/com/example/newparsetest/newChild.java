package com.example.newparsetest;



import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;


import android.view.View;

import android.widget.EditText;



public class newChild extends Activity{
String editFirstName;
String editLastName;
String editHometown;
String editAge;
private Child sub;
Button added;
EditText firstName;
EditText lastName;
EditText hometown;
EditText age;
int convert=9000;
String TextKey;


	@Override
    public void onCreate(Bundle savedInstanceState) {
      sub= new Child();
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.addingsomeonepage);
	

        firstName =(EditText)findViewById(R.id.nFirstName);
    	age=(EditText) findViewById(R.id.nAge);
    	lastName =(EditText)findViewById(R.id.nLastName);
    	hometown =(EditText)findViewById(R.id.nHometown);
    	
    	
    	added= (Button)findViewById(R.id.nAdd);

		added.setOnClickListener(new View.OnClickListener() {
	@Override
			public void onClick(View view){
		int length=age.getText().length();
		editFirstName=firstName.getText().toString();
		editAge=age.getText().toString();
		editLastName=lastName.getText().toString();
		editHometown=hometown.getText().toString();
		if(length!=0){
			convert=Integer.parseInt(editAge);
				
		}
		
		TextKey=editFirstName+" "+editLastName;
	sub.setFirstName(editFirstName);
	sub.setLastName (editLastName);
	sub.setHometown (editHometown);
	sub.setAge(convert);
	sub.setSecondAge(editAge);
	sub.setTextKey(TextKey);
	sub.saveInBackground ();
	Intent openHub= new Intent(newChild.this, hub.class);
	startActivity(openHub);
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
