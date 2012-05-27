package jp.coxs.twitter.favrt.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-05-27 11:43:56")
/** */
public final class BaseUserMeta extends org.slim3.datastore.ModelMeta<jp.coxs.twitter.favrt.model.BaseUser> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser> accessToken = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser>(this, "accessToken", "accessToken");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser> id = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser>(this, "id", "id");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser> requestToken = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser>(this, "requestToken", "requestToken");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser> tokenSecret = new org.slim3.datastore.StringAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser>(this, "tokenSecret", "tokenSecret");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, java.util.Date> updateDate = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, java.util.Date>(this, "updateDate", "updateDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jp.coxs.twitter.favrt.model.BaseUser, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final BaseUserMeta slim3_singleton = new BaseUserMeta();

    /**
     * @return the singleton
     */
    public static BaseUserMeta get() {
       return slim3_singleton;
    }

    /** */
    public BaseUserMeta() {
        super("BaseUser", jp.coxs.twitter.favrt.model.BaseUser.class);
    }

    @Override
    public jp.coxs.twitter.favrt.model.BaseUser entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jp.coxs.twitter.favrt.model.BaseUser model = new jp.coxs.twitter.favrt.model.BaseUser();
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
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("accessToken", m.getAccessToken());
        entity.setProperty("id", m.getId());
        entity.setProperty("requestToken", m.getRequestToken());
        entity.setProperty("tokenSecret", m.getTokenSecret());
        entity.setProperty("updateDate", m.getUpdateDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
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
        jp.coxs.twitter.favrt.model.BaseUser m = (jp.coxs.twitter.favrt.model.BaseUser) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
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
    protected jp.coxs.twitter.favrt.model.BaseUser jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jp.coxs.twitter.favrt.model.BaseUser m = new jp.coxs.twitter.favrt.model.BaseUser();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
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