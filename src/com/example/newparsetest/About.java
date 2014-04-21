package com.example.newparsetest;



	import android.os.Bundle;
	import android.app.Activity;
	import android.view.Menu;
	import com.parse.Parse;
	import com.parse.ParseAnalytics;
	import com.parse.ParseObject;



	public class About extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			 ParseObject aboutApp = new ParseObject("AboutApp");
			 aboutApp.put("about","so interesting");
			 aboutApp.put("wow", "such doge");
			 aboutApp.saveInBackground();
		
		
		
		
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

	}
