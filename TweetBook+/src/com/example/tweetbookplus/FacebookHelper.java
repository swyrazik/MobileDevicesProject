package com.example.tweetbookplus;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FacebookHelper extends Fragment implements SocialNetworkHelper{

	public FacebookHelper(){
		
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_facebook, container, false);
         
        return rootView;
    }
	
	@Override
	public boolean isAppInstalled(PackageManager packageManager) {
		try{
	        packageManager.getApplicationInfo("com.facebook.katana", 0);
	        return true;
	    } catch (PackageManager.NameNotFoundException e){
	        return false;
	    }
	}

}
