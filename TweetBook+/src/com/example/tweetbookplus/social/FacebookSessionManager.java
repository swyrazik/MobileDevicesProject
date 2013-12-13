package com.example.tweetbookplus.social;

import android.app.Activity;
import android.app.Fragment;

import com.facebook.Session;
import com.facebook.SessionState;

public class FacebookSessionManager {
	
	private Session session;
	private Session.StatusCallback callback;
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
		//use any method to open a (new) session: e.g. Session.openActiveSession(...), Session.Builder()...build(), new Session.OpenRequest()..., ...
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
			// TODO implement the default session behaviour for logging in
			
//			//example from getting started guide on facebook
//			if (session.isOpened()) {
//
//				// make request to the /me API
//				Request.newMeRequest(session, new Request.GraphUserCallback() {
//					
//					// callback after Graph API response with user object
//					@Override
//		            public void onCompleted(GraphUser user, Response response) {
//						if (user != null) {
//							TextView welcome = (TextView) findViewById(R.id.welcome);
//							welcome.setText("Hello " + user.getName() + "!");
//						}
//					}
//				}).executeAsync();
//			}
			
		}
		
	}
	
}
