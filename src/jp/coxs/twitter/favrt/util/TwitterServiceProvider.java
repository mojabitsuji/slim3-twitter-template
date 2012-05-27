package jp.coxs.twitter.favrt.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.model.TwitterUser;
import jp.coxs.twitter.favrt.model.json.ApiLimitHeader;
import jp.coxs.twitter.favrt.model.json.User;
import jp.coxs.twitter.favrt.model.json.Users;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;

/**
 * Twitter�̃T�[�r�X�v���o�C�_����ێ�����N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class TwitterServiceProvider extends ServiceProvider {
    public String getConsumerKey() {
        return "xxxxxxxxxxxxxxxxxxxxxx";
    }

    public String getConsumerSecret() {
        return "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    }

    public String getRequestTokenUrl() {
        return "http://twitter.com/oauth/request_token";
    }

    public String getAccessTokenUrl() {
        return "http://twitter.com/oauth/access_token";
    }

    public String getAuthorizeUrl() {
        return "http://twitter.com/oauth/authorize";
    }

    public String getVerfyCredentialsUrl() {
        return "http://api.twitter.com/1/account/verify_credentials.json";
    }

    public String getCallBackUrl() {
        return "http://test-twiho.appspot.com/auth";
    }

    @Override
    BaseUser createNewUserInstance() {
        return new TwitterUser();
    }

    @Override
    <T extends BaseUser> void parseVerifyCredentialsResponse(T user, String jsonString) {
        Gson g = new GsonBuilder().registerTypeAdapter(User.class, new InstanceCreator<User>() {
            public User createInstance(Type type) {
                return new User();
            }
        }).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type singleType = new TypeToken<User>() {
        }.getType();
        User jsonUser = g.fromJson(jsonString, singleType);
        user.setId(jsonUser.getIdStr());
    }

    /*
     * json�`���̕��������͂��āAUser�̃��X�g��Ԃ����\�b�h���������v���Z�b�T�ł��B
     */
    private static abstract class TwihoProcessor<T extends ApiLimitHeader> extends Processor<T> {
        TwihoProcessor() {
            initialize();
        }

        protected void initialize() {
        }

        protected Users<List<User>> parseListUserType(String jsonString) {
            Gson g =
                new GsonBuilder().registerTypeAdapter(Users.class,
                    new InstanceCreator<Users<List<User>>>() {
                        public Users<List<User>> createInstance(Type type) {
                            return new Users<List<User>>();
                        }
                    }).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            Type listType = new TypeToken<Users<List<User>>>() {
            }.getType();
            return g.fromJson(jsonString, listType);
        }

        protected DebugProcessor<Users<List<User>>> debugProcessor(
                TwihoProcessor<Users<List<User>>> t) {
            DebugProcessor<Users<List<User>>> dp = new DebugProcessor<Users<List<User>>>() {
                @Override
                public Users<List<User>> returnEmptyResponse() {
                    Users<List<User>> users = new Users<List<User>>();
                    users.setUsers(new ArrayList<User>());
                    return users;
                }
            };
            dp.setProcessor(t);
            return dp;
        }
    }

    /**
     * �w��̃��[�U���t�H���[���Ă���ꗗ�����A�ŐV�X�e�[�^�X�t�Ŏ擾���ĕԂ��܂��B<br />
     * �ŐV�X�e�[�^�X���K�v�Ȃ��ꍇ�ɂ́A�I�v�V������"lite"��true�ɂ��Ă��������B
     * 
     * @return ���[�U���̃��X�g
     */
    public static Processor<Users<List<User>>> instanceOfStatusesFriends() {
        return new TwihoProcessor<Users<List<User>>>() {
            /*
             * ���X�g�Ŏ擾������͕̂K������J�[�\�����擾�ł���悤�Ƀp�����[�^�w�������
             */
            @Override
            protected final void initialize() {
                setCursor("-1");
            }

            @Override
            public String getRequestName() {
                return "StatusesFriends";
            }

            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/statuses/friends.json";
            }

            @Override
            public Users<List<User>> parseResponse(String jsonString) {
                return parseListUserType(jsonString);
            }

            @Override
            public void addUserId(String userId) {
                throw new UnsupportedOperationException(getRequestName()
                    + " request is not support this method.");
            }

            public DebugProcessor<Users<List<User>>> toDebugProcessor() {
                return debugProcessor(this);
            }
        };
    }

    public static Processor<TwitterVoid> instanceOfFriendshipsCreate() {
        return new Processor<TwitterVoid>() {
            @Override
            public String getMethod() {
                return "POST";
            }

            @Override
            public String getRequestName() {
                return "FriendshipsCreate";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/friendships/destroy.json";
            }

            @Override
            public TwitterVoid parseResponse(String jsonString) {
                return null;
            }

            @Override
            public DebugProcessor<TwitterVoid> toDebugProcessor() {
                return null;
            }
        };
    }

    public static Processor<TwitterVoid> instanceOfStatusesFriendsTimeline() {
        return new Processor<TwitterVoid>() {
            @Override
            public String getRequestName() {
                return "StatusesFriendsTimeline";
            }

            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/statuses/friends_timeline.json";
            }

            @Override
            public TwitterVoid parseResponse(String jsonString) {
                return null;
            }

            @Override
            public void addUserId(String userId) {
                throw new UnsupportedOperationException(getRequestName()
                    + " request is not support this method.");
            }

            public DebugProcessor<TwitterVoid> toDebugProcessor() {
                //TODO
                return null;
            }
        };
    }

    /**
     * �w��̃��[�U�̃t�H�����[�̈ꗗ�����A�ŐV�X�e�[�^�X�t�Ŏ擾���ĕԂ��܂��B<br />
     * �ŐV�X�e�[�^�X���K�v�Ȃ��ꍇ�ɂ́A�I�v�V������"lite"��true�ɂ��Ă��������B
     * 
     * @return ���[�U���̃��X�g
     */
    public static Processor<Users<List<User>>> instanceOfStatusesFollowers() {
        return new TwihoProcessor<Users<List<User>>>() {
            @Override
            protected void initialize() {
                setCursor("-1");
            }

            @Override
            public String getRequestName() {
                return "StatusesFollowers";
            }

            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/statuses/followers.json";
            }

            @Override
            public Users<List<User>> parseResponse(String jsonString) {
                return parseListUserType(jsonString);
            }

            @Override
            public void addUserId(String userId) {
                throw new UnsupportedOperationException(getRequestName()
                    + " request is not support this method.");
            }

            public DebugProcessor<Users<List<User>>> toDebugProcessor() {
                return debugProcessor(this);
            }
        };
    }

    /**
     * ������ID���w�肵�ă��[�U�̏����擾���܂��B
     * 
     * @return ���[�U���̃��X�g
     */
    public static Processor<Users<List<User>>> instanceOfUsersLookup() {
        return new TwihoProcessor<Users<List<User>>>() {
            @Override
            public String getRequestName() {
                return "UsersLookup";
            }

            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/users/lookup.json";
            }

            @Override
            public Users<List<User>> parseResponse(String jsonString) {
                return parseListUserType(jsonString);
            }

            @Override
            public void setUserId(String userId) {
                throw new UnsupportedOperationException(getRequestName()
                    + " request is not support this method.");
            }

            public DebugProcessor<Users<List<User>>> toDebugProcessor() {
                return debugProcessor(this);
            }
        };
    }

    /**
     * �t�����h�폜���s���v���Z�b�T�ł��B
     * 
     * @return �Ȃ�
     */
    public static Processor<TwitterVoid> instanceOfFriendshipsDestroyProcessor() {
        return new Processor<TwitterVoid>() {
            @Override
            public String getRequestName() {
                return "FriendshipsDestroy";
            }

            @Override
            public String getMethod() {
                return "DELETE";
            }

            @Override
            public String getRequestUrl() {
                return "http://api.twitter.com/1/friendships/destroy.json";
            }

            @Override
            public TwitterVoid parseResponse(String jsonString) {
                return null;
            }

            @Override
            public void addUserId(String userId) {
                throw new UnsupportedOperationException(getRequestName()
                    + " request is not support this method.");
            }

            public DebugProcessor<TwitterVoid> toDebugProcessor() {
                //TODO
                return null;
            }
        };
    }

    public static class TwitterVoid extends ApiLimitHeader {
        /*
         * The Void class cannot be instantiated.
         */
        private TwitterVoid() {
        }
    }

    /**
     * �f�o�b�O�p�v���Z�b�T�B
     * 
     * @author Shunichi Todoroki
     * @param <T>
     */
    public abstract static class DebugProcessor<T extends ApiLimitHeader> extends Processor<T> {
        private String jsonString;
        private TwihoProcessor<T> processor;

        public String getJsonString() {
            return jsonString;
        }

        public void setProcessor(TwihoProcessor<T> twihoProcessor) {
            this.processor = twihoProcessor;
        }

        @Override
        public String getRequestName() {
            return processor.getRequestName();
        }

        @Override
        public String getMethod() {
            return processor.getMethod();
        }

        @Override
        public String getRequestUrl() {
            return processor.getRequestUrl();
        }

        @Override
        public T parseResponse(String jsonString) {
            this.jsonString = jsonString;
            return returnEmptyResponse();
        }

        public void addUserId(String userId) {
            processor.addUserId(userId);
        }

        public void setUserId(String userId) {
            processor.setUserId(userId);
        }

        public void setScreenName(String screenName) {
            processor.setScreenName(screenName);
        }

        public void setPage(String page) {
            processor.setPage(page);
        }

        public void setCursor(String cursor) {
            processor.setCursor(cursor);
        }

        public void setLite(boolean lite) {
            processor.setLite(lite);
        }

        public Set<Entry<String, String>> getParams() {
            return processor.getParams();
        }

        public DebugProcessor<T> toDebugProcessor() {
            throw new UnsupportedOperationException("debug processor is not supported this method.");
        }

        protected abstract T returnEmptyResponse();
    }
}
