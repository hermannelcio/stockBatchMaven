package org.apache.maven.batch.converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.batch.entities.DiarioBase;

import com.mongodb.DBObject;

public class DiarioBaseConverter {
	
   public Map<String, Object> converterToMap(DiarioBase diarioBase) {
        
	   Map<String, Object> mapDiario = new HashMap<String, Object>();
        
        mapDiario.put("idHead", diarioBase.getIdHead());
        mapDiario.put("tipoRegistro", diarioBase.getTipoRegistro());
        mapDiario.put("dataPregao", diarioBase.getDataPregao());
        mapDiario.put("codigoBDI", diarioBase.getCodigoBDI());
        mapDiario.put("codigoNegociacaoPapel", diarioBase.getCodigoNegociacaoPapel());
        mapDiario.put("tipoMercado", diarioBase.getTipoMercado());
        mapDiario.put("nomeResumidoPapel", diarioBase.getNomeResumidoPapel());
        mapDiario.put("especificacaoPapel", diarioBase.getEspecificacaoPapel());
        mapDiario.put("prazoMercadoTermo", diarioBase.getPrazoMercadoTermo());
        mapDiario.put("moedaReferencia", diarioBase.getMoedaReferencia());
        mapDiario.put("precoAbertura", diarioBase.getPrecoAbertura());
        mapDiario.put("precoMaximo", diarioBase.getPrecoMaximo());
        mapDiario.put("precoMinimo", diarioBase.getPrecoMinimo());
        mapDiario.put("precoMedio", diarioBase.getPrecoMedio());
        mapDiario.put("precoFechamento", diarioBase.getPrecoFechamento());
        mapDiario.put("precoMelhorOfertaCompra", diarioBase.getPrecoMelhorOfertaCompra());
        mapDiario.put("precoMelhorOfertaVenda", diarioBase.getPrecoMelhorOfertaVenda());
        mapDiario.put("negociosEfetuados", diarioBase.getNegociosEfetuados());
        mapDiario.put("titulosNegociados", diarioBase.getTitulosNegociados());
        mapDiario.put("volumeNegociado", diarioBase.getVolumeNegociado());
        mapDiario.put("precoMercadoOpcoes", diarioBase.getPrecoMercadoOpcoes());
        mapDiario.put("indicadorCorrecao", diarioBase.getIndicadorCorrecao());
        mapDiario.put("dataVencimentoOpcoes", diarioBase.getDataVencimentoOpcoes());
        mapDiario.put("fatorCotacao", diarioBase.getFatorCotacao());
        mapDiario.put("precoPontoRefDolar", diarioBase.getPrecoPontoRefDolar());
        mapDiario.put("codigoIsin", diarioBase.getCodigoIsin());
        mapDiario.put("numeroDistribuicao", diarioBase.getNumeroDistribuicao());

        return mapDiario;
        
    }

    public DiarioBase converterToObject(DBObject dbo) {
    	
    	DiarioBase diarioBase = new DiarioBase();
    	
    	if(dbo != null){
	    	diarioBase.setId(dbo.get("_id").toString());
	    	diarioBase.setIdHead(dbo.get("idHead").toString());
	    	diarioBase.setTipoRegistro((long) (dbo.get("tipoRegistro")));
	    	diarioBase.setDataPregao((Date) dbo.get("dataPregao"));
	    	diarioBase.setCodigoBDI((String) dbo.get("codigoBDI"));
	    	diarioBase.setCodigoNegociacaoPapel((String) dbo.get("codigoNegociacaoPapel"));
	    	diarioBase.setTipoMercado((long) dbo.get("tipoMercado"));
	    	diarioBase.setNomeResumidoPapel((String) dbo.get("nomeResumidoPapel"));
	    	diarioBase.setEspecificacaoPapel((String) dbo.get("especificacaoPapel"));
	    	diarioBase.setPrazoMercadoTermo((String) dbo.get("prazoMercadoTermo"));
	    	diarioBase.setMoedaReferencia((String) dbo.get("moedaReferencia"));
	    	diarioBase.setPrecoAbertura((double) dbo.get("precoAbertura"));
	        diarioBase.setPrecoMaximo((double) dbo.get("precoMaximo"));
	        diarioBase.setPrecoMinimo((double) dbo.get("precoMinimo"));
	        diarioBase.setPrecoMedio((double) dbo.get("precoMedio"));
	        diarioBase.setPrecoFechamento((double) dbo.get("precoFechamento"));
	        diarioBase.setPrecoMelhorOfertaCompra((double) dbo.get("precoMelhorOfertaCompra"));
	        diarioBase.setPrecoMelhorOfertaVenda((double) dbo.get("precoMelhorOfertaVenda"));
	        diarioBase.setNegociosEfetuados((Integer) dbo.get("negociosEfetuados"));
	        diarioBase.setTitulosNegociados((long) dbo.get("titulosNegociados"));
	        diarioBase.setVolumeNegociado((double) dbo.get("volumeNegociado"));
	        diarioBase.setPrecoMercadoOpcoes((double) dbo.get("precoMercadoOpcoes"));
	        diarioBase.setIndicadorCorrecao((long) dbo.get("indicadorCorrecao"));
	        diarioBase.setDataVencimentoOpcoes((Date) dbo.get("dataVencimentoOpcoes"));
	        diarioBase.setFatorCotacao((Integer) dbo.get("fatorCotacao"));
	        diarioBase.setPrecoPontoRefDolar((double) dbo.get("precoPontoRefDolar"));
	        diarioBase.setCodigoIsin((String) dbo.get("codigoIsin"));
	        diarioBase.setNumeroDistribuicao((int) dbo.get("numeroDistribuicao"));
    	}

        return diarioBase;
    }
}
