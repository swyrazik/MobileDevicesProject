package com.example.tweetbookplus;
import android.content.pm.PackageManager;


public class GooglePlusHelper implements SocialNetworkHelper {

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
