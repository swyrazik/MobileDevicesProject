package com.example.tweetbookplus.social;

import android.content.pm.PackageManager;


public class TumblrHelper implements SocialNetworkHelper{
	
	protected TumblrHelper(){
		
	}
	
	@Override
	public boolean isAppInstalled(PackageManager packageManager) {
		try{
	        packageManager.getApplicationInfo("com.tumblr", 0);
	        return true;
	    } catch (PackageManager.NameNotFoundException e){
	        return false;
	    }
	}
	
}
