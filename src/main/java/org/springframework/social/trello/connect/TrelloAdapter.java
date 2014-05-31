package org.springframework.social.trello.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.web.client.HttpClientErrorException;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Member;


public class TrelloAdapter implements ApiAdapter<Trello> {
    @Override
    public boolean test(Trello trello) {
        try {
            trello.getMemberInformation("me");
            return true;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Trello trello, ConnectionValues values) {
        Member profile = trello.getMemberInformation("me");
        values.setProviderUserId(profile.getId());
        values.setDisplayName(profile.getEmail());
        values.setProfileUrl(profile.getUrl());
    }

    @Override
    public UserProfile fetchUserProfile(Trello trello) {
    	Member profile = trello.getMemberInformation("me");
        return new UserProfileBuilder().setName(profile.getUsername()).setUsername(profile.getEmail()).setEmail(profile.getEmail()).build();
    }

    @Override
    public void updateStatus(Trello trello, String s) {
        // Not Supported
    }

}
