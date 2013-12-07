These classes are the base structure we will follow for organizing our code that is related to the social networks.

Interfaces:
- SocialNetworkHelper: The interface that all helper classes for social networks implement. If there is any method that all helper classes must have, it should be declared here.

Classes:
- FacebookHelper: Class for data and methods related to Facebook.
- TwitterHelper: Class for data and methods related to Twitter.
- GooglePlusHelper: Class for data and methods related to GooglePlus.
- SocialNetworkManager: Class for managing the above helper classes.

The above classes follow the design patterns of Singleton and Facade. The SocialNetworkManager class is a Signleton, meaning that there can only exist one instance of itself and every other class can access it, and a Facade, having the role of a central point of access to the helper classes. This design allows us to organize our classes and code better, but also to ensure that we will be working with only one instance of each Social Network class, avoiding duplicated data. Notice how the helper classes have their constructors declared as protected, in order to prevent someone from instantiating them without the use of SocialNetworkManager.

Usage example in Activity/Fragment:
SocialNetworkManager social;
social = SocialNetworkManager.Instance();
//check if the corresponding apps are installed on the phone
boolean isFacebookInstalled = social.facebook.isAppInstalled(getPackageManager());
boolean isTwitterInstalled = social.twitter.isAppInstalled(getPackageManager());
boolean isGooglePlusInstalled = social.googlePlus.isAppInstalled(getPackageManager());
Log.d("example", "Facebook is installed: " + isFacebookInstalled + "\nTwitter is installed: " + isTwitterInstalled + "\nGoogle+ is installed: " + isGooglePlusInstalled);