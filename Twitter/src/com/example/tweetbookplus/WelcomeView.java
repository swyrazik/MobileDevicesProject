package com.example.tweetbookplus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class WelcomeView extends Activity implements OnClickListener {
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	  // getActionBar().hide(); //hide the action bar
		
		setContentView(R.layout.welcome_view);      

		ImageButton facebookb = (ImageButton)findViewById(R.id.facebook_but); //button for facebook
		ImageButton twitterb = (ImageButton)findViewById(R.id.twitter_button); //button for twitter
		ImageButton tumblrb = (ImageButton)findViewById(R.id.tumblr_button); //button for tumblr
		ImageButton gotofeed = (ImageButton)findViewById(R.id.news); //button for facebook
		 facebookb.setOnClickListener(this);
		 twitterb.setOnClickListener(this);
		 tumblrb.setOnClickListener(this);
		 gotofeed.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, LogIn.class); // intent to the login activity
		int button=0;
		switch(v.getId())
		{
		case R.id.facebook_but: 
			button=0;
		    intent.putExtra("Login",String.valueOf(button) ); //send also which type of login we selected
	        startActivity(intent);
		break;
		case R.id.twitter_button:
			button=1;
			intent.putExtra("Login",String.valueOf(button) ); //send also which type of login we selected
		    startActivity(intent);
		break;
		case R.id.tumblr_button:
			button=2;
			intent.putExtra("Login",String.valueOf(button) ); //send also which type of login we selected
		    startActivity(intent);
		break;
		case R.id.news:
			Intent gototweet = new Intent(this, MainActivity.class);
			 startActivity(gototweet);		
		break;
		
		}
				
		
	}



	


 
	
 
	}
 
 

