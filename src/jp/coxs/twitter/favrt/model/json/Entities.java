package jp.coxs.twitter.favrt.model.json;

import java.util.Arrays;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class Entities {
    private Url[] urls;
    private Hashtag[] hashtags;
    private UserMention[] userMentions;

    public Url[] getUrls() {
        return urls;
    }

    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    public Hashtag[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(Hashtag[] hashtags) {
        this.hashtags = hashtags;
    }

    public UserMention[] getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(UserMention[] userMentions) {
        this.userMentions = userMentions;
    }

    @Override
    public String toString() {
        return "Entities [urls="
            + Arrays.toString(urls)
            + ", hashtags="
            + Arrays.toString(hashtags)
            + ", userMentions="
            + Arrays.toString(userMentions)
            + "]";
    }
}
