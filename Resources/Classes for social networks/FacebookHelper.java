import android.content.pm.PackageManager;


public class FacebookHelper implements SocialNetworkHelper{
	
	protected FacebookHelper(){
		
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
