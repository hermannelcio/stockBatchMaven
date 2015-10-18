package org.apache.maven.batch.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.batch.converter.HeadConverter;
import org.apache.maven.batch.entities.Head;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class HeadDAO extends EntityDao<Head>{
	
	public HeadDAO (){
		super(Head.class);
	}
	
    public Head getById(final String id) {
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("_id", new ObjectId(id));
		DBObject dbObject = findOne(map);
		Head head = new HeadConverter().converterToObject(dbObject);
		return head;
    }
    
    public void persist(Head head) {
    	Map<String, Object> mapHead = new HeadConverter().converterToMap(head);
        save(mapHead);
    }
    
    public void mergeTotalRegistro(Head headNew) {
    	Map<String, Object> query = new HashMap<String, Object>();
    	query.put("_id", new ObjectId(headNew.getId()));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRegistros", headNew.getTotalRegistros());
        update(query, map);
    }
    
    public void merge(Head headOld, Head headNew) {
    	Map<String, Object> query = new HeadConverter().converterToMapWithId(headOld);
        Map<String, Object> map = new HeadConverter().converterToMapWithId(headNew);
        update(query, map);
    }
    
    public List<Head> findAllHead() {
       	List<DBObject> dbObject = findAll();
		List<Head> heads = new ArrayList<Head>();
		
		for (DBObject dbo : dbObject) {
			Head head = new HeadConverter().converterToObject(dbo);
			heads.add(head);
		}
		
		return heads;
    }
    
    
    public void remove(Head head) {
    	Map<String, Object> map = new HeadConverter().converterToMap(head);
        delete(map);
    }
 
    public void removeById(final String id) {
        try {
        	Head head = getById(id);
            remove(head);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String getLastId(){
    	return new HeadConverter().converterToObject(findlast("_id")).getId();
    }

    public boolean verigicaRegistro(Head head){
    	return !pesquisaHead(head).isEmpty();
    }

    public List<Head> pesquisaHead(Head head) {
		List<DBObject> dbObject = findKeyValue(new HeadConverter().converterToMapSearch(head));
	    List<Head> heads = new ArrayList<Head>();
	    for (DBObject dbo : dbObject) {
	    	Head headList = new HeadConverter().converterToObject(dbo);
	    	heads.add(headList);
	    }
	    return heads;
	}
    
    public Head retornaRegistro(Head head){
    	return (Head) pesquisaHead(head).get(0);
    }

	public void apaga() {
		String campo = "dataGeracaoArqH";
        apaga(campo);
		
	}
	
	public Head findOneHead(Head head){
		Map<String, Object> map = new HeadConverter().converterToMapSearch(head);
		return new HeadConverter().converterToObject(findOne(map));
	}


}
