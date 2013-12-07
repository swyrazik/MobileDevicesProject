package com.example.tweetbookplus.social;

import android.content.pm.PackageManager;


public class GooglePlusHelper implements SocialNetworkHelper{
	
	protected GooglePlusHelper(){
		
	}
	
	@Override
	public boolean isAppInstalled(PackageManager packageManager) {
		try{
	        packageManager.getApplicationInfo("com.google.android.apps.plus", 0);
	        return true;
	    } catch (PackageManager.NameNotFoundException e){
	        return false;
	    }
	}
	
}
