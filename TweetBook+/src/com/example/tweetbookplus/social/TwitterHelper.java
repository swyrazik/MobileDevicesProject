package com.example.tweetbookplus.social;

import android.content.pm.PackageManager;


public class TwitterHelper implements SocialNetworkHelper{
	
	protected TwitterHelper(){
		
	}
	
	@Override
	public boolean isAppInstalled(PackageManager packageManager) {
		try{
	        packageManager.getApplicationInfo("com.twitter.android", 0);
	        return true;
	    } catch (PackageManager.NameNotFoundException e){
	        return false;
	    }
	}
	
}
