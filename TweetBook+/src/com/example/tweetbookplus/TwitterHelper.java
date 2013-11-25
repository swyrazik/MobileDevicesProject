package com.example.tweetbookplus;
import android.content.pm.PackageManager;


public class TwitterHelper implements SocialNetworkHelper{

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
