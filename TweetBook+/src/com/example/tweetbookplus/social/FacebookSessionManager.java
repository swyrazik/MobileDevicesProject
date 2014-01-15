package com.example.tweetbookplus.social;

import org.json.JSONObject;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.NewPermissionsRequest;
import com.facebook.SessionState;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;

public class FacebookSessionManager {
	
	private Session session;
	private Session.StatusCallback callback;
	private Activity activity;
	//TODO maybe a list to store the requests executed on a session callback, so: private final ArrayList<Request> requests;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookSessionManager(){
		
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public Session getSession(){
		return session;
	}
	
	////////////////////////////////////////////
	//             Other Methods              //
	////////////////////////////////////////////
	
	//open session with the default callback
	public boolean openSession(Activity activity){
		return openSession(activity, new DefaultLoginCallback());
	}
	
	//open session with the default callback
	public boolean openSession(Fragment fragment){
		return openSession(fragment, new DefaultLoginCallback());
	}
	
	//open session with a custom callback
	public boolean openSession(Activity activity, Session.StatusCallback callback){
		this.callback = callback;
		this.activity = activity;
		//use any method to open a (new) session: e.g. Session.openActiveSession(...), Session.Builder()...build(), new Session.OpenRequest()..., ...
		
		session = Session.openActiveSession(activity, true, this.callback);
		
		//return whether the session was successfully opened
		return false;
	}
	
	//open session with a custom callback
	public boolean openSession(Fragment fragment, Session.StatusCallback callback){
		this.callback = callback;
		//use any method to open a (new) session: e.g. Session.openActiveSession(...), Session.Builder()...build(), new Session.OpenRequest()..., ...
		//return whether the session was successfully opened
		return false;
	}
	
	public boolean closeSession(boolean clearTokenInformation){
		//maybe create also a DefaultLogoutCallback class, so: this.callback = new DefaultLogoutCallback();
		if (clearTokenInformation)
			session.closeAndClearTokenInformation();
		else
			session.close();
		return false;
	}
	
	////////////////////////////////////////////
	//             Inner Classes              //
	////////////////////////////////////////////
	
	//the default callback to use when opening a session
	private class DefaultLoginCallback implements Session.StatusCallback{

		@Override
		public void call(Session session, SessionState state, Exception exception) {
			
			if (exception != null){
				Log.d("Login", "Exception is " + exception.getMessage());
			}
			
			if (session.isOpened()){
				
				//get current user data
				Request.newMeRequest(session, new Request.GraphUserCallback() {
					
					@Override
					public void onCompleted(GraphUser user, Response response) {
						if (user != null){
							JSONObject json = user.getInnerJSONObject();
							if (json != null)
								SocialNetworkManager.Instance().facebook.setCurrentUser(new FacebookUser(json));
						}
						
					}
				}).executeAsync();
				
				//check if user has granted permission to the application for reading its news feed
				if (!session.getPermissions().contains("read_stream"))
					session.requestNewReadPermissions(new NewPermissionsRequest(activity, "read_stream"));
				else{
					//get news feed data
					Request.newGraphPathRequest(session, "me/home", new Request.Callback() {
						
						@Override
						public void onCompleted(Response response) {
							GraphObject object = response.getGraphObject();
							if (object != null){
								JSONObject json = object.getInnerJSONObject();
								if (json != null){
									Log.d("Session","json"+json.toString());
									SocialNetworkManager.Instance().facebook.updateNewsfeed(json);
								}
							}
							
						}
					}).executeAsync();
				}
			}
			
		}
		
	}
	
}
