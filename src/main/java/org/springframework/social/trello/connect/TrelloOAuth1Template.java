package org.springframework.social.trello.connect;

import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;

public class TrelloOAuth1Template extends OAuth1Template {

	private String param;
	
	public TrelloOAuth1Template(String consumerKey, String consumerSecret,
			String requestTokenUrl, String authorizeUrl, String accessTokenUrl,
			String param, OAuth1Version version) {
		super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl,
				accessTokenUrl, version);
		this.param=param;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	public String buildAuthorizeUrl(String requestToken, OAuth1Parameters parameters) {
		String url = super.buildAuthorizeUrl(requestToken, parameters);
		url = url + "&" + param;
		return url;
	}

}
