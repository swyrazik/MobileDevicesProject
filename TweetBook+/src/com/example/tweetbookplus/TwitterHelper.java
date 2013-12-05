package com.example.tweetbookplus;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TwitterHelper extends Fragment implements SocialNetworkHelper{

	public TwitterHelper() {
		// TODO Auto-generated constructor stub
	}	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_twitter, container, false);
         
        return rootView;
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
