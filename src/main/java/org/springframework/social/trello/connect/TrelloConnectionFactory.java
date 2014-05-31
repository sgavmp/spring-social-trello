package org.springframework.social.trello.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;

import com.julienvey.trello.Trello;


public class TrelloConnectionFactory extends OAuth1ConnectionFactory<Trello> {
	
    public TrelloConnectionFactory(String appKey, String appSecret) {
        super("trello", new TrelloServiceProvider(appKey, appSecret), new TrelloAdapter());
    }
}
