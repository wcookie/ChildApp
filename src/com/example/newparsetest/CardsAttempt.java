package com.example.newparsetest;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.parse.ParseQueryAdapter;
public class CardsAttempt extends ListActivity {

	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		
		setListAdapter (new ParseQueryAdapter<Child>(this, Child.class));
	ListView listView=getListView();
	listView.setTextFilterEnabled(true);
	
	listView.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
		    // When clicked, show a toast with the TextView text
		    Toast.makeText(getApplicationContext(),
			((TextView) view).getText(), Toast.LENGTH_SHORT).show();
		}
	});
	
	
	}
	
	
	
}
