package jp.coxs.twitter.favrt.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-07-07 16:12:08")
/** */
public final class TwitterUserMeta extends org.slim3.datastore.ModelMeta<jp.coxs.twitter.favrt.model.TwitterUser> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.lang.Boolean> apiLimit = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.lang.Boolean>(this, "apiLimit", "apiLimit", boolean.class);

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Set<java.lang.String>> followIds = new org.slim3.datastore.StringCollectionAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Set<java.lang.String>>(this, "followIds", "followIds", java.util.Set.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser> followsNextCursor = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser>(this, "followsNextCursor", "followsNextCursor");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Date> lastFollowSearchDate = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Date>(this, "lastFollowSearchDate", "lastFollowSearchDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser> accessToken = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser>(this, "accessToken", "accessToken");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser> id = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser>(this, "id", "id");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser> requestToken = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser>(this, "requestToken", "requestToken");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser> tokenSecret = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser>(this, "tokenSecret", "tokenSecret");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Date> updateDate = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.util.Date>(this, "updateDate", "updateDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.TwitterUser, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TwitterUserMeta slim3_singleton = new TwitterUserMeta();

    /**
     * @return the singleton
     */
    public static TwitterUserMeta get() {
       return slim3_singleton;
    }

    /** */
    public TwitterUserMeta() {
        super("BaseUser", jp.coxs.twitter.favrt.model.TwitterUser.class, java.util.Arrays.asList("jp.coxs.twitter.favrt.model.TwitterUser"));
    }

    @Override
    public jp.coxs.twitter.favrt.model.TwitterUser entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jp.coxs.twitter.favrt.model.TwitterUser model = new jp.coxs.twitter.favrt.model.TwitterUser();
        model.setApiLimit(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("apiLimit")));
        model.setFollowIds(new java.util.HashSet<java.lang.String>(toList(java.lang.String.class, entity.getProperty("followIds"))));
        model.setFollowsNextCursor((java.lang.String) entity.getProperty("followsNextCursor"));
        model.setLastFollowSearchDate((java.util.Date) entity.getProperty("lastFollowSearchDate"));
        model.setAccessToken((java.lang.String) entity.getProperty("accessToken"));
        model.setId((java.lang.String) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setRequestToken((java.lang.String) entity.getProperty("requestToken"));
        model.setTokenSecret((java.lang.String) entity.getProperty("tokenSecret"));
        model.setUpdateDate((java.util.Date) entity.getProperty("updateDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("apiLimit", m.isApiLimit());
        entity.setProperty("followIds", m.getFollowIds());
        entity.setProperty("followsNextCursor", m.getFollowsNextCursor());
        entity.setProperty("lastFollowSearchDate", m.getLastFollowSearchDate());
        entity.setProperty("accessToken", m.getAccessToken());
        entity.setProperty("id", m.getId());
        entity.setProperty("requestToken", m.getRequestToken());
        entity.setProperty("tokenSecret", m.getTokenSecret());
        entity.setProperty("updateDate", m.getUpdateDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        entity.setProperty("slim3.classHierarchyList", classHierarchyList);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        jp.coxs.twitter.favrt.model.TwitterUser m = (jp.coxs.twitter.favrt.model.TwitterUser) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("apiLimit");
        encoder0.encode(writer, m.isApiLimit());
        writer.setNextPropertyName("defaultProfile");
        encoder0.encode(writer, m.getDefaultProfile());
        if(m.getFollowIds() != null){
            writer.setNextPropertyName("followIds");
            writer.beginArray();
            for(java.lang.String v : m.getFollowIds()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getFollowsNextCursor() != null){
            writer.setNextPropertyName("followsNextCursor");
            encoder0.encode(writer, m.getFollowsNextCursor());
        }
        if(m.getLastFollowSearchDate() != null){
            writer.setNextPropertyName("lastFollowSearchDate");
            encoder0.encode(writer, m.getLastFollowSearchDate());
        }
        if(m.getProfileImageUrl() != null){
            writer.setNextPropertyName("profileImageUrl");
            encoder0.encode(writer, m.getProfileImageUrl());
        }
        if(m.getScreenName() != null){
            writer.setNextPropertyName("screenName");
            encoder0.encode(writer, m.getScreenName());
        }
        if(m.getAccessToken() != null){
            writer.setNextPropertyName("accessToken");
            encoder0.encode(writer, m.getAccessToken());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRequestToken() != null){
            writer.setNextPropertyName("requestToken");
            encoder0.encode(writer, m.getRequestToken());
        }
        if(m.getTokenSecret() != null){
            writer.setNextPropertyName("tokenSecret");
            encoder0.encode(writer, m.getTokenSecret());
        }
        if(m.getUpdateDate() != null){
            writer.setNextPropertyName("updateDate");
            encoder0.encode(writer, m.getUpdateDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected jp.coxs.twitter.favrt.model.TwitterUser jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jp.coxs.twitter.favrt.model.TwitterUser m = new jp.coxs.twitter.favrt.model.TwitterUser();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("apiLimit");
        m.setApiLimit(decoder0.decode(reader, m.isApiLimit()));
        reader = rootReader.newObjectReader("defaultProfile");
        m.setDefaultProfile(decoder0.decode(reader, m.getDefaultProfile()));
        reader = rootReader.newObjectReader("followIds");
        {
            java.util.HashSet<java.lang.String> elements = new java.util.HashSet<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("followIds");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setFollowIds(elements);
            }
        }
        reader = rootReader.newObjectReader("followsNextCursor");
        m.setFollowsNextCursor(decoder0.decode(reader, m.getFollowsNextCursor()));
        reader = rootReader.newObjectReader("lastFollowSearchDate");
        m.setLastFollowSearchDate(decoder0.decode(reader, m.getLastFollowSearchDate()));
        reader = rootReader.newObjectReader("profileImageUrl");
        m.setProfileImageUrl(decoder0.decode(reader, m.getProfileImageUrl()));
        reader = rootReader.newObjectReader("screenName");
        m.setScreenName(decoder0.decode(reader, m.getScreenName()));
        reader = rootReader.newObjectReader("accessToken");
        m.setAccessToken(decoder0.decode(reader, m.getAccessToken()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("requestToken");
        m.setRequestToken(decoder0.decode(reader, m.getRequestToken()));
        reader = rootReader.newObjectReader("tokenSecret");
        m.setTokenSecret(decoder0.decode(reader, m.getTokenSecret()));
        reader = rootReader.newObjectReader("updateDate");
        m.setUpdateDate(decoder0.decode(reader, m.getUpdateDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}