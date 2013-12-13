package com.example.tweetbookplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class WelcomeView extends Activity implements OnClickListener {
	 
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide(); //hide the action bar
		setContentView(R.layout.welcome_view); 
		ImageButton button1 = (ImageButton)findViewById(R.id.facebook_but); //button for facebook
		ImageButton button2 = (ImageButton)findViewById(R.id.twitter_button); //button for twitter
		ImageButton button3 = (ImageButton)findViewById(R.id.tumblr_button); //button for tumbl
		 button1.setOnClickListener(this);
		 button2.setOnClickListener(this);
		 button3.setOnClickListener(this);
	}
	
	
	
	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent(this, LogIn.class); // intent to the login activity
		int button=0;
		switch(v.getId())
		{
		case R.id.facebook_but: button=0;
		break;
		case R.id.twitter_button:button=1;
		break;
		case R.id.tumblr_button:button=2;
		break;
		
		}
		String b=String.valueOf(button); //send also which type of login we selected
		intent.putExtra("Login",b );
	    startActivity(intent);
		
	}



	


 
	
 
	}
 
 

