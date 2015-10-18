package org.apache.maven.batch.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.batch.converter.DiarioBaseConverter;
import org.apache.maven.batch.entities.DiarioBase;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class DiarioBaseDAO extends EntityDao<DiarioBase> {
	
	public DiarioBaseDAO (){
		super(DiarioBase.class);
	}
 
    public DiarioBase getById(final String id) {
    	  Map<String, Object> map = new HashMap<String, Object>();
          map.put("_id", id);
    	  DBObject dbObject = findOne(map);
    	  DiarioBase diarioBase = new DiarioBaseConverter().converterToObject(dbObject);
          return diarioBase;
    }
    
    public void persist(DiarioBase diarioBase) throws Exception {
    	 Map<String, Object> mapDiarioBase = new DiarioBaseConverter().converterToMap(diarioBase);
         save(mapDiarioBase);
    }
    
    public void persist(Collection<DiarioBase> cotacoesDiarias) throws Exception {
        try {
            for (DiarioBase cot : cotacoesDiarias){
            	persist(cot);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    public void merge(DiarioBase diarioBaseOld, DiarioBase diarioBaseNew) throws Exception {
        Map<String, Object> query = new DiarioBaseConverter().converterToMap(diarioBaseOld);
        Map<String, Object> map = new DiarioBaseConverter().converterToMap(diarioBaseNew);
        update(query, map);
    }
    
    public List<DiarioBase> findAllDiarios() {
    	List<DBObject> dbObject = findAll();
		List<DiarioBase> diarios = new ArrayList<DiarioBase>();
		
		for (DBObject dbo : dbObject) {
			DiarioBase diarioBase = new DiarioBaseConverter().converterToObject(dbo);
			diarios.add(diarioBase);
		}
		
		return diarios;
    }
    
    
    public void remove(DiarioBase diarioBase) throws Exception {
        Map<String, Object> map = new DiarioBaseConverter().converterToMap(diarioBase);
        delete(map);
    }
 
    public void removeById(final String id) throws Exception {
        try {
        	DiarioBase diarioBase = getById(id);
            remove(diarioBase);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    
//    public String getLastId(){
//    	return new DiarioBaseConverter().converterToObject(findLast()).getId();
//    }

    public boolean verigicaRegistro(DiarioBase diariobase){
    	return pesquisaDiarioBase(diariobase).isEmpty();
    }

	public List<DiarioBase> pesquisaDiarioBase(DiarioBase diariobase) {
        List<DBObject> dbObject = findKeyValue(new DiarioBaseConverter().converterToMap(diariobase));

        List<DiarioBase> diarios = new ArrayList<DiarioBase>();

        for (DBObject dbo : dbObject) {
        	DiarioBase diarioBase = new DiarioBaseConverter().converterToObject(dbo);

        	diarios.add(diarioBase);
        }

        return diarios;
	}
    
    public DiarioBase retornaRegistro(DiarioBase diariobase){
    	return (DiarioBase) pesquisaDiarioBase(diariobase).get(0);
    }
    
    /**
     * 
     * @param idhead
     * @return
     */
	public List<String> buscaListaPapeis(String idhead){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idhead", idhead);
		List<DBObject> dbObject = findKeyValue(map);
		List<String> papeis = new ArrayList<String>();

		for (DBObject dbo : dbObject) {
			DiarioBase diarioBase = new DiarioBaseConverter().converterToObject(dbo);
			papeis.add(diarioBase.getCodigoNegociacaoPapel());
		}
		
		return papeis;
    }
    
	public Date dataUltimoRegistro(){
		return new DiarioBaseConverter().converterToObject(findlast("dataPregao")).getDataPregao();
    }
	
	public void apaga(){
		String campo = "dataPregao";
        apaga(campo);
	}
	
	public List<DiarioBase> findListaDiario(DiarioBase diariobase) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nomeResumidoPapel", "ACESITA");
		
        List<DBObject> dbObject = findKeyValue(map);

        List<DiarioBase> diarios = new ArrayList<DiarioBase>();

        for (DBObject dbo : dbObject) {
        	DiarioBase diarioBase = new DiarioBaseConverter().converterToObject(dbo);

        	diarios.add(diarioBase);
        }

        return diarios;
	}
}
