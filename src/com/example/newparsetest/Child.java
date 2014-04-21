package com.example.newparsetest;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseClassName;
import com.parse.ParseQuery;
@ParseClassName ("Child")
public class Child extends ParseObject {
	public Child () {
		//default constructor
	}
	public String getFirstName() {
		return getString ("firstName");
			
	}
	
	public void setFirstName (String firstName) {
		put("firstName", firstName);
	}
	
	public String getLastName () {
		return getString ("lastName");
	}
	
	public void setLastName (String lastName) {
		put ("lastName", lastName);
	}
	
	public String getHometown () {
		return getString ("hometown");
	}

	public void setHometown (String hometown) {
		put ("hometown", hometown);
	}
	
	public String getAge(){
		return getString ("age");
	}
	
	public void setAge(int age) {
		put ("age", age);		
	}
	public String getTextKey(){
		return getString("TextKey");
	}
	public void setTextKey(String TextKey) {
		put ("TextKey",TextKey);
	}
	public ParseFile getPhotoFile() {
		return getParseFile("photo");
	}

	public void setPhotoFile(ParseFile file) {
		put("photo", file);
	}
	public static ParseQuery<Child> getQuery(){
		return ParseQuery.getQuery(Child.class);
	}
}
