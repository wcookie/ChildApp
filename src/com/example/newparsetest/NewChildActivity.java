package com.example.newparsetest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;


import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.EditText;

public class NewChildActivity extends Activity{
	
	    private Child child;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        child = new Child();
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        super.onCreate(savedInstanceState);
	 
	        // Begin with main data entry view,
	        // NewMealFragment
	        setContentView(R.layout.framenewchild);
	        FragmentManager manager = getFragmentManager();
	        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
	 
	        if (fragment == null) {
	            fragment = new NewChildFragment();
	            manager.beginTransaction().add(R.id.fragmentContainer, fragment)
	                    .commit();
	        }
	    }
	 
	    public Child getCurrentChild() {
	        return child;
	    }
	 
	}