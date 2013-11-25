
public class SocialNetworkManager {
	public final FacebookHelper facebook;
    public final TwitterHelper twitter;
    public final GooglePlusHelper googlePlus;

    public SocialNetworkManager(){
        facebook = new FacebookHelper();
        twitter = new TwitterHelper();
        googlePlus = new GooglePlusHelper();
    }

}
