package org.springframework.social.trello.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;

import com.julienvey.trello.Trello;

/**
 * Dropbox Connection Factory
 * 
 * @author Bryce Fischer
 * @author Robert Drysdale
 */
public class TrelloConnectionFactory extends OAuth1ConnectionFactory<Trello> {
	
	/**
	 * Dropbox Connection Factory
	 * 
	 * appFolder must align with how app is registered in Dropbox.
	 * App can be allowed access to only an app folder (default)
	 * or the whole of Dropbox
	 * 
	 * @param appKey Registered key
	 * @param appSecret Registered
	 * @param appFolder Whether to use sandboxed app folder or access whole of Dropbox
	 */
    public TrelloConnectionFactory(String appKey, String appSecret) {
        super("trello", new TrelloServiceProvider(appKey, appSecret), new TrelloAdapter());
    }
}
