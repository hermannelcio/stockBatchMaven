package org.apache.maven.batch.converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.batch.entities.Head;
import org.bson.types.ObjectId;

import com.mongodb.DBObject;

public class HeadConverter {
	
	   public Map<String, Object> converterToMap(Head head) {
	        
		   Map<String, Object> mapHead = new HashMap<String, Object>();
		   
		   mapHead.put("tipoRegistroh", head.getTipoRegistroh());
		   mapHead.put("nomeArquivoh", head.getNomeArquivoh());
		   mapHead.put("codigoOrigemH", head.getCodigoOrigemH());
		   mapHead.put("dataGeracaoArqH", head.getDataGeracaoArqH());
		   mapHead.put("totalRegistros", head.getTotalRegistros());

		   return mapHead;
	    }
	   
	   public Map<String, Object> converterToMapWithId(Head head) {
	        
		   Map<String, Object> mapHead = new HashMap<String, Object>();
		   
		   mapHead.put("_id", new ObjectId(head.getId()));
		   mapHead.put("tipoRegistroh", head.getTipoRegistroh());
		   mapHead.put("nomeArquivoh", head.getNomeArquivoh());
		   mapHead.put("codigoOrigemH", head.getCodigoOrigemH());
		   mapHead.put("dataGeracaoArqH", head.getDataGeracaoArqH());
		   mapHead.put("totalRegistros", head.getTotalRegistros());

		   return mapHead;
	    }
	   
	   public Map<String, Object> converterToMapSearch(Head head) {
	        
		   Map<String, Object> mapHead = new HashMap<String, Object>();
		   mapHead.put("nomeArquivoh", head.getNomeArquivoh());
		   return mapHead;
	    }

	    public Head converterToObject(DBObject dbo) {
	    	
	    	final Head head = new Head();
	    	
	    	if(dbo != null){
		    	head.setId(dbo.get("_id").toString());
		    	head.setTipoRegistroh((long) dbo.get("tipoRegistroh"));
		    	head.setNomeArquivoh((String) dbo.get("nomeArquivoh"));
		    	head.setCodigoOrigemH((String) dbo.get("codigoOrigemH"));
		    	head.setDataGeracaoArqH((Date) dbo.get("dataGeracaoArqH"));
		    	if(dbo.get("totalRegistros") != null)
		    		head.setTotalRegistros((long) dbo.get("totalRegistros"));
	    	}
	        return head;
	    }

}
