package com.example.tweetbookplus.social;

import org.json.JSONArray;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;

import com.facebook.Session;

public class FacebookHelper implements SocialNetworkHelper{
	
	private FacebookSessionManager sessionManager;
	private FacebookUser currentUser;
	private FacebookNewsfeed newsfeed;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookHelper(){
		sessionManager = new FacebookSessionManager();
		currentUser = null;
		newsfeed = new FacebookNewsfeed();
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public FacebookPost[] getNewsfeed(){
		return newsfeed.getPosts();
	}
	
	public FacebookPost[] getUpdatedNewsfeed(){
		JSONArray data = null;
		// TODO: get data from sessionManager
		newsfeed.update(data);
		return newsfeed.getPosts();
	}
	
	public FacebookUser getCurrentUser(){
		return currentUser;
	}
	
	////////////////////////////////////////////
	//             Other Methods              //
	////////////////////////////////////////////
	
	public boolean login(Activity activity){
		sessionManager.openSession(activity);
		//return whether login was successful
		return false;
	}
	
	public boolean login(Fragment fragment){
		sessionManager.openSession(fragment);
		//return whether login was successful
		return false;
	}
	
	public boolean login(Activity activity, Session.StatusCallback customCallback){
		sessionManager.openSession(activity, customCallback);
		//return whether login was successful
		return false;
	}
	
	public boolean login(Fragment fragment, Session.StatusCallback customCallback){
		sessionManager.openSession(fragment, customCallback);
		//return whether login was successful
		return false;
	}
	
	public boolean logout(boolean clearTokenInformation){
		return sessionManager.closeSession(clearTokenInformation);
	}
	
	////////////////////////////////////////////
	//           Interface Methods            //
	////////////////////////////////////////////
	
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
