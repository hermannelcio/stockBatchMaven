package org.apache.maven.batch.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.WriteResult;

public class EntityDao<T> implements IDao {
	
    private Class<T> persistentClass;
    private DBCollection dbCollection;

    public EntityDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection = MongoConnection.getInstance().getDB().getCollection(persistentClass.getSimpleName());
    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }

	@Override
	public void save(Map<String, Object> mapEntity) {
        BasicDBObject document = new BasicDBObject(mapEntity);
        dbCollection.save(document);
        System.out.println("Save :> " + document);
	}

	@Override
	public void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity) {
        BasicDBObject query = new BasicDBObject(mapQuery);
        BasicDBObject entity = new BasicDBObject();
        entity.put("$set", new BasicDBObject(mapEntity));
        dbCollection.update(query, entity);
	}

	@Override
	public void delete(Map<String, Object> mapEntity) {
        BasicDBObject entity = new BasicDBObject(mapEntity);
        dbCollection.remove(entity);
	}

	@Override
	public DBObject findOne(Map<String, Object> mapEntity) {
       BasicDBObject query = new BasicDBObject(mapEntity);
       return dbCollection.findOne(query);
	}

	@Override
	public List<DBObject> findAll() {
        List<DBObject> list = new ArrayList<DBObject>();
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
	}

	@Override
	public List<DBObject> findKeyValue(Map<String, Object> keyValue) {
        List<DBObject> list = new ArrayList<DBObject>();
        DBCursor cursor = dbCollection.find(new BasicDBObject(keyValue));
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
	}
	
	@Override
	public DBObject findlast(String campo) {
       DBCursor cursor = dbCollection.find().sort(new BasicDBObject(campo,-1)).limit(1);
       return (DBObject) cursor.next();
	}
	
	
	public void apaga(String campo){
		@SuppressWarnings("deprecation")
		Date fromDate = new Date(114, 11, 31);
		
//		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("tentando: " + campo);
//        map.put(campo, new QueryBuilder().greaterThanEquals(fromDate));
        
        
        BasicDBObject query = new BasicDBObject();//campo, new BasicDBObject("$gt", fromDate));
        
        dbCollection.remove(query);
	}
	
}
