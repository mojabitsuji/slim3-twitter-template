package jp.coxs.twitter.favrt.service;

import java.util.Date;
import java.util.HashSet;

import jp.coxs.twitter.favrt.model.TwitterUser;
import jp.coxs.twitter.favrt.util.ModelKeyGenerator;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import com.google.appengine.api.datastore.Transaction;

/**
 * ���[�U���̑�����s���T�[�r�X�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class UserService {
    protected static final Integer ZERO = Integer.valueOf(0);
    protected static final Integer ONE = Integer.valueOf(1);

    /**
     * ���[�U���ɗL���ȃt�H���[ID�̃Z�b�g�����݂���΂����Ԃ��܂��B
     * �G���e�B�e�B�����݂��Ȃ��ꍇ�́Anull��Ԃ��܂�
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
     * Twitter�ł̔F�؂��I�������A�F�؏��̊i�[���ꂽ���[�U����o�^���܂��B
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
