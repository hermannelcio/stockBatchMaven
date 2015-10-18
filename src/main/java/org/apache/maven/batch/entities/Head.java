package org.apache.maven.batch.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.batch.util.BatchUtils;


public class Head {
	private String id;				
	private long tipoRegistroh;  		
	private String nomeArquivoh;  		
	private String codigoOrigemH;  		
	private Date dataGeracaoArqH; 
	private Long totalRegistros; 
	
	public class Oid{
		String $oid;
		public String get$oid() {
			return $oid;
		}
 
		public void set$oid(String $oid) {
			this.$oid = $oid;
		}
 
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setId(Object id) {
		this.id = id.toString();
	}
	
	public long getTipoRegistroh() {
		return tipoRegistroh;
	}
	
	public void setTipoRegistroh(long tipoRegistroh) {
		this.tipoRegistroh = tipoRegistroh;
	}
	
	public String getNomeArquivoh() {
		return nomeArquivoh;
	}
	
	public void setNomeArquivoh(String nomeArquivoh) {
		this.nomeArquivoh = nomeArquivoh;
	}
	
	public String getCodigoOrigemH() {
		return codigoOrigemH;
	}
	
	public void setCodigoOrigemH(String codigoOrigemH) {
		this.codigoOrigemH = codigoOrigemH;
	}
	
	public Date getDataGeracaoArqH() {
		return dataGeracaoArqH;
	}
	
	public void setDataGeracaoArqH(Date dataGeracaoArqH){
		this.dataGeracaoArqH = dataGeracaoArqH;
	}
	
	public void setDataGeracaoArqH(String dataHead) {
		this.dataGeracaoArqH = trataData(dataHead);
	}
	
	public Long getTotalRegistros() {
		return totalRegistros;
	}
	
	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	public void setTotalRegistros(String linha) {
		if(linha != null)
			if(linha.length() >= 42)
				this.totalRegistros = Long.parseLong(linha.substring(31, 42));
			else
				this.totalRegistros = Long.parseLong(linha);
		else
			this.totalRegistros = null;
	}
	
	public Head carregaValores(String linha){
		this.setTipoRegistroh(Long.parseLong(linha.substring(0, 2)));
        this.setNomeArquivoh(linha.substring(2, 15));
        this.setCodigoOrigemH(linha.substring(15, 23));
        this.setDataGeracaoArqH(linha.substring(23, 31));
		return this;
	}
	
	private Date trataData(String data) {
		Date retorno = null;
		try {
			if(BatchUtils.verificaData(data))
				retorno = new Date((new SimpleDateFormat("yyyyMMdd").parse(data)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Head() {
		super();	
	}
	
	public Head(String tipoRegistroh, String nomeArquivoh, String codigoOrigemH, String dataGeracaoArqH, String totalRegistros) {
		 this.tipoRegistroh		= Long.parseLong(tipoRegistroh);
		 this.nomeArquivoh		= nomeArquivoh;
		 this.codigoOrigemH		= codigoOrigemH;
		 this.dataGeracaoArqH	= trataData(dataGeracaoArqH);
		 this.totalRegistros	= Long.parseLong(totalRegistros);
	}
	
    @Override
    public String toString() {
        return "Head{" +
                "id='" + id + '\'' +
                ", tipoRegistroh='" + tipoRegistroh + '\'' +
                ", nomeArquivoh='" + nomeArquivoh + '\'' +
                ", codigoOrigemH='" + codigoOrigemH + '\'' +
                ", dataGeracaoArqH='" + dataGeracaoArqH + '\'' +
                ", totalRegistros='" + totalRegistros + '\'' +
                '}';
    }
	
}
