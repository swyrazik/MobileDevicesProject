package com.example.tumblr_test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.signature.HmacSha1MessageSigner;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.User;

public class MainActivity extends Activity {
	private static final String TAG = "TumblrDemo";
	private static String myData;
	private static List<String> list = new ArrayList<String>();
	private static final String oauthKey = "QNmFJZ0W6mhKXvtC3p9ISHwHEugDe3Zb1rQAEC2iFfS8KOA7hN";
	private static final String oauthSecret = "qx5L1dCdhT0paKlUi0hCp7E9paIoapsgVE594kzND2h3BvWhsk";
	private static List<Post> p = new ArrayList<Post>();
	private static ListView lv;
    private OAuthConsumer consumer;
    HttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		lv = (ListView) findViewById(R.id.l1);
		consumer = new CommonsHttpOAuthConsumer(oauthKey, oauthSecret);
        consumer.setMessageSigner(new HmacSha1MessageSigner());
        client = new DefaultHttpClient();
		myAsyncTask myWebFetch = new myAsyncTask();//stk
		myWebFetch.execute();
	}

	class myAsyncTask extends AsyncTask<Void, Void, Void> {

		TextView tv;

		myAsyncTask() {
			tv = (TextView) findViewById(R.id.t1);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			tv.setText("User: " + myData);
			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					MainActivity.this, android.R.layout.simple_list_item_1,
					list);
			lv.setAdapter(arrayAdapter);
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			tv.setText("Started Running....");
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			JumblrClient client = new JumblrClient(
					  "QNmFJZ0W6mhKXvtC3p9ISHwHEugDe3Zb1rQAEC2iFfS8KOA7hN",
					  "qx5L1dCdhT0paKlUi0hCp7E9paIoapsgVE594kzND2h3BvWhsk"
					);
					client.setToken(
					  "ggUwz5GovHYU39vw7qj3YJOWHvMRbgJxOtRB2LA3Kx6iOTBs1G",
					  "dklw21NGL3s15P5VKDNbqvewxov7IUnevUrQGbCXp1iJf1sJps"
					);
					
			User user = client.user();
			myData = user.getName();// anything else?//nu cred//merci//sure

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("limit", 60);
			List<Post> posts = client.userDashboard(params);
			myData = posts.get(0).getBlogName();
//			myData+="\n"+posts.get(0).getDateGMT();
//			myData+="\n"+posts.get(0).getSourceTitle();
//			myData+="\n"+posts.get(0).getPostUrl();
//			myData+="\n"+posts.get(0).getState();
//			myData+="\n"+posts.get(0).getType();
//			myData+="\n"+posts.get(0).getNoteCount();
			
			Log.v("VLAD", posts.get(0).getPostUrl());
			
			//posts.get(0).get
			PhotoPost p = (PhotoPost) posts.get(0);
			myData = p.getCaption();
			List<Photo> photos = p.getPhotos();
			Photo ph = photos.get(0);
			Map<String, Object> map = p.detail();
			Set<String> key = map.keySet();
			Collection<Object> val = map.values();
			int i = 0;
			Object[] type = new Object[val.size()];
			String[] s = new String[key.size()];
			for (Iterator iterator = val.iterator(); iterator.hasNext();) {
				type[i] =  iterator.next();
				i++;
		    }
			i = 0;
			for (String x : key){
				s[i] = x;
				i++;
			}
			for (int j = 0; j < i; j++){
				Log.d("entry " + j, s[j]);
			}
			
			return null;
		}


	}
	
    private static String convertToString(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
