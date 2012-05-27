package jp.coxs.twitter.favrt.service;

import java.util.Date;
import java.util.HashSet;

import jp.coxs.twitter.favrt.model.TwitterUser;
import jp.coxs.twitter.favrt.util.ModelKeyGenerator;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import com.google.appengine.api.datastore.Transaction;

/**
 * ユーザ情報の操作を行うサービスクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class UserService {
    protected static final Integer ZERO = Integer.valueOf(0);
    protected static final Integer ONE = Integer.valueOf(1);

    /**
     * ユーザ情報に有効なフォローIDのセットが存在すればそれを返します。
     * エンティティが存在しない場合は、nullを返します
     * 
     * @param id TwitterID
     */
    public TwitterUser searchUser(String id) {
        TwitterUser user = new TwitterUser();
        user.setId(id);
        ModelKeyGenerator.generateKey(user);
        try {
            user = Datastore.get(TwitterUser.class, user.getKey());
        } catch (EntityNotFoundRuntimeException e) {
            return null;
        }
        return user;
    }

    /**
     * Twitterでの認証が終了した、認証情報の格納されたユーザ情報を登録します。
     * 
     * @param user
     */
    public void storeVerifiedCredentials(TwitterUser user) {
        ModelKeyGenerator.generateKey(user);
        Transaction tx = Datastore.beginTransaction();
        TwitterUser temp;
        try {
            temp = Datastore.get(tx, TwitterUser.class, user.getKey());
            temp.setRequestToken(user.getRequestToken());
            temp.setAccessToken(user.getAccessToken());
            temp.setTokenSecret(user.getTokenSecret());
        } catch (EntityNotFoundRuntimeException e) {
            temp = user;
        }
        temp.setUpdateDate(new Date());
        temp.setFollowIds(new HashSet<String>());
        temp.setApiLimit(false);
        Datastore.put(tx, temp);
        tx.commit();
    }
}
