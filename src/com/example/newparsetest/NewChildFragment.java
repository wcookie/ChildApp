package com.example.newparsetest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseUser;
import com.parse.SaveCallback;



public class NewChildFragment extends Fragment {

	private ImageButton photoButton;
	private Button saveButton;
	
	private TextView childName;
	String editFirstName;
	String editLastName;
	String editHometown;
	String editAge;

	EditText firstName;
	EditText lastName;
	EditText hometown;
	EditText age;
	int convert=9000;
	String TextKey;

	private ParseImageView childPreview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle SavedInstanceState) {
		View v = inflater.inflate(R.layout.newchildfragment, parent, false);

		
		   firstName =(EditText)v.findViewById(R.id.nFirstName);
	    	age=(EditText) v.findViewById(R.id.nAge);
	    	lastName =(EditText)v.findViewById(R.id.nLastName);
	    	hometown =(EditText)v.findViewById(R.id.nHometown);
	    	
	
		photoButton = ((ImageButton) v.findViewById(R.id.photo_button));
		photoButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(firstName.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(lastName.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(hometown.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(age.getWindowToken(), 0);
				startCamera();
			}
		});

		saveButton = ((Button) v.findViewById(R.id.nAdd));
		saveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Child child = ((NewChildActivity) getActivity()).getCurrentChild();

				int length=age.getText().length();
				editFirstName=firstName.getText().toString();
				editAge=age.getText().toString();
				editLastName=lastName.getText().toString();
				editHometown=hometown.getText().toString();
				if(length!=0){
					convert=Integer.parseInt(editAge);
						
				}
				
				TextKey=editFirstName+" "+editLastName;
			child.setFirstName(editFirstName);
			child.setLastName (editLastName);
			child.setHometown (editHometown);
			child.setAge(convert);
			child.setTextKey(TextKey);
			child.setSecondAge(editAge);
				child.saveInBackground(new SaveCallback() {

					@Override
					public void done(ParseException e) {
						if (e == null) {
							getActivity().setResult(Activity.RESULT_OK);
							getActivity().finish();
						} else {
							Toast.makeText(
									getActivity().getApplicationContext(),
									"Error saving: " + e.getMessage(),
									Toast.LENGTH_SHORT).show();
						}
					}

				});

			}
		});

		

		childPreview = (ParseImageView) v.findViewById(R.id.child_preview_image);
		childPreview.setVisibility(View.INVISIBLE);

		return v;
	}

	
	public void startCamera() {
		Fragment cameraFragment = new CameraFragment();
		FragmentTransaction transaction = getActivity().getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragmentContainer, cameraFragment);
		transaction.addToBackStack("NewChildFragment");
		transaction.commit();
	}

	
	@Override
	public void onResume() {
		super.onResume();
		ParseFile photoFile = ((NewChildActivity) getActivity())
				.getCurrentChild().getPhotoFile();
		if (photoFile != null) {
			childPreview.setParseFile(photoFile);
			childPreview.loadInBackground(new GetDataCallback() {
				@Override
				public void done(byte[] data, ParseException e) {
					childPreview.setVisibility(View.VISIBLE);
				}
			});
		}
	}

}