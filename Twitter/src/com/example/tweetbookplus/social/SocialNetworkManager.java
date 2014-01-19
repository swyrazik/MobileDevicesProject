package com.example.tweetbookplus.social;

//This is a Singleton class, i.e. only one instance of this class may exist.
//This is a Facade class, meaning that you communicate with its related classes through this one.
public class SocialNetworkManager {
	
	private static SocialNetworkManager instance = null;
	
	public final FacebookHelper facebook;
    public final TwitterHelper twitter;
    public final TumblrHelper tumblr;

    private SocialNetworkManager(){
        facebook = new FacebookHelper();
        twitter = new TwitterHelper();
        tumblr = new TumblrHelper();
    }
    
    public static SocialNetworkManager Instance(){
    	if (instance == null){
    		instance = new SocialNetworkManager();
    	}
    	return instance;
    }

}
