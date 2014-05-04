package com.example.newparsetest;
import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class ChildApplication extends Application {
	 @Override
	  public void onCreate() {
	    super.onCreate();
	 
	    ParseObject.registerSubclass(Child.class);
	    Parse.initialize(this, KEYS HERE);
	    	  }
}
