These classes are the base structure we will follow for organizing our code that is related to the social networks.

Interfaces:
- SocialNetworkHelper: The interface that all helper classes for social networks implement. If there is any method that all helper classes must have, it should be declared here.

Classes:
- FacebookHelper: Class for data and methods related to Facebook.
- TwitterHelper: Class for data and methods related to Twitter.
- GooglePlusHelper: Class for data and methods related to GooglePlus.
- SocialNetworkManager: Class for managing the above helper classes.

Usage example in Activity:
SocialNetworkManager social;
social = new SocialNetworkManager();
//check if the corresponding apps are installed on the phone
boolean isFacebookInstalled = social.facebook.isAppInstalled(getPackageManager());
boolean isTwitterInstalled = social.twitter.isAppInstalled(getPackageManager());
boolean isGooglePlusInstalled = social.googlePlus.isAppInstalled(getPackageManager());
Log.d("example", "Facebook is installed: " + isFacebookInstalled + "\nTwitter is installed: " + isTwitterInstalled + "\nGoogle+ is installed: " + isGooglePlusInstalled);