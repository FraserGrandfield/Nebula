package com.Nebula.NebulaBot;

import java.util.List;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class BackgroundTwitter {

	public static void TweetMethord(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        	.setOAuthConsumerKey("xuyQzxZi4U2Fl6sW7SpJSVfJn")
        	.setOAuthConsumerSecret("f3vpnklqj5L6TQguVl6UIbnFs3RAFzQtrnEYKQP56gu9IIl4Uv")
			.setOAuthAccessToken("1012398195035590656-sXpck5NkPcjXGI94bMwrpaCmL40llH")
			.setOAuthAccessTokenSecret("AR0EDUuQpwmxALGrBebrkJzgJybGHDvJo4xvAOfRTguse");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        
        List<twitter4j.Status> status;
		try {
			status = twitter.getHomeTimeline();
	        for(twitter4j.Status st: status) {
	        	System.out.println(st.getUser().getName() + " " + st.getText());
	        }
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
