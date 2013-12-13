package com.example.tweetbookplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class LogIn extends Activity implements OnClickListener {
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide(); //hide the action bar
		
		final Intent sender = getIntent();
		final int loginto = Integer.parseInt(sender.getExtras().getString("Login"));
		switch(loginto)//find which button we pressed in the welcome view and set the acording xml
		{
		case 0: setContentView(R.layout.facebook_login);
		break;
		case 1: setContentView(R.layout.twitter_login);
		break;
		case 2: setContentView(R.layout.tumblr_login);
		break;
		
		}
				
		ImageButton signin = (ImageButton)findViewById(R.id.signin);
		signin.setOnClickListener(this);
		 
	}

	@Override
	public void onClick(View arg0) {
		EditText textuser = (EditText)findViewById(R.id.username); //username
		String  username = textuser.getText().toString().trim();   //password
		
		EditText textpass = (EditText)findViewById(R.id.password);
		String  password= textpass.getText().toString().trim();
		Log.d("lala", username);
		Log.d("lalal", password);
		
		
		///verify the user and password then go to the mainactivity
		
		Intent intent = new Intent(this, MainActivity.class); // intent to the login activity
	    startActivity(intent);
			
		
	}
 
	
 
 
}
