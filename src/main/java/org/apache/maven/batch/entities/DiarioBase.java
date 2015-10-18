package org.apache.maven.batch.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.batch.util.BatchUtils;


public class DiarioBase {
	private String idHead;
	private String id;
	private long tipoRegistro;
	private Date dataPregao;
	private String codigoBDI;
	private String codigoNegociacaoPapel;
	private long tipoMercado;
	private String nomeResumidoPapel;
	private String especificacaoPapel;
	private String prazoMercadoTermo;
	private String moedaReferencia;
	private double precoAbertura;
	private double precoMaximo;
	private double precoMinimo;
	private double precoMedio;
	private double precoFechamento;
	private double precoMelhorOfertaCompra;
	private double precoMelhorOfertaVenda;
	private Integer negociosEfetuados;
	private long titulosNegociados;
	private double volumeNegociado;
	private double precoMercadoOpcoes;
	private long indicadorCorrecao;
	private Date dataVencimentoOpcoes;
	private Integer fatorCotacao;
	private double precoPontoRefDolar;
	private String codigoIsin;
	private int numeroDistribuicao;
	
	
	public String getIdHead() {
		return idHead;
	}
	public void setIdHead(String idHead) {
		this.idHead = idHead;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	
	public long getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(long tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	
	public Date getDataPregao() {
		return dataPregao;
	}
	public void setDataPregao(Date dataPregao){
		this.dataPregao = dataPregao;
	}
	public void setDataPregao(String datapre) {
		this.dataPregao = trataData(datapre);
	}
	
	public String getCodigoBDI() {
		return codigoBDI;
	}
	public void setCodigoBDI(String codigoBDI) {
		this.codigoBDI = codigoBDI;
	}
	
	public String getCodigoNegociacaoPapel() {
		return codigoNegociacaoPapel;
	}
	public void setCodigoNegociacaoPapel(String codigoNegociacaoPapel) {
		this.codigoNegociacaoPapel = codigoNegociacaoPapel;
	}
	
	public long getTipoMercado() {
		return tipoMercado;
	}
	public void setTipoMercado(long tipoMercado) {
		this.tipoMercado = tipoMercado;
	}
	
	public String getNomeResumidoPapel() {
		return nomeResumidoPapel;
	}
	public void setNomeResumidoPapel(String nomeResumidoPapel) {
		this.nomeResumidoPapel = nomeResumidoPapel;
	}
	
	public String getEspecificacaoPapel() {
		return especificacaoPapel;
	}
	public void setEspecificacaoPapel(String especificacaoPapel) {
		this.especificacaoPapel = especificacaoPapel;
	}
	
	public String getPrazoMercadoTermo() {
		return prazoMercadoTermo;
	}
	public void setPrazoMercadoTermo(String prazoMercadoTermo) {
		this.prazoMercadoTermo = prazoMercadoTermo;
	}
	
	public String getMoedaReferencia() {
		return moedaReferencia;
	}
	public void setMoedaReferencia(String moedaReferencia) {
		this.moedaReferencia = moedaReferencia;
	}
	
	public double getPrecoAbertura() {
		return precoAbertura;
	}
	public void setPrecoAbertura(double precoAbertura) {
		this.precoAbertura = precoAbertura;
	}
	
	public double getPrecoMaximo() {
		return precoMaximo;
	}
	public void setPrecoMaximo(double precoMaximo) {
		this.precoMaximo = precoMaximo;
	}
	
	public double getPrecoMinimo() {
		return precoMinimo;
	}
	public void setPrecoMinimo(double precoMinimo) {
		this.precoMinimo = precoMinimo;
	}
	
	public double getPrecoMedio() {
		return precoMedio;
	}
	public void setPrecoMedio(double precoMedio) {
		this.precoMedio = precoMedio;
	}
	
	public double getPrecoFechamento() {
		return precoFechamento;
	}
	public void setPrecoFechamento(double precoFechamento) {
		this.precoFechamento = precoFechamento;
	}
	
	public double getPrecoMelhorOfertaCompra() {
		return precoMelhorOfertaCompra;
	}
	public void setPrecoMelhorOfertaCompra(double precoMelhorOfertaCompra) {
		this.precoMelhorOfertaCompra = precoMelhorOfertaCompra;
	}
	
	public double getPrecoMelhorOfertaVenda() {
		return precoMelhorOfertaVenda;
	}
	public void setPrecoMelhorOfertaVenda(double precoMelhorOfertaVenda) {
		this.precoMelhorOfertaVenda = precoMelhorOfertaVenda;
	}
	
	public Integer getNegociosEfetuados() {
		return negociosEfetuados;
	}
	public void setNegociosEfetuados(Integer negociosEfetuados) {
		this.negociosEfetuados = negociosEfetuados;
	}
	
	public long getTitulosNegociados() {
		return titulosNegociados;
	}
	public void setTitulosNegociados(long titulosNegociados) {
		this.titulosNegociados = titulosNegociados;
	}
	
	public double getVolumeNegociado() {
		return volumeNegociado;
	}
	public void setVolumeNegociado(double volumeNegociado) {
		this.volumeNegociado = volumeNegociado;
	}
	
	public double getPrecoMercadoOpcoes() {
		return precoMercadoOpcoes;
	}
	public void setPrecoMercadoOpcoes(double precoMercadoOpcoes) {
		this.precoMercadoOpcoes = precoMercadoOpcoes;
	}
	
	public long getIndicadorCorrecao() {
		return indicadorCorrecao;
	}
	public void setIndicadorCorrecao(long indicadorCorrecao) {
		this.indicadorCorrecao = indicadorCorrecao;
	}
	
	public Date getDataVencimentoOpcoes() {
		return dataVencimentoOpcoes;
	}
	public void setDataVencimentoOpcoes(Date dataVencimentoOpcoes){
		this.dataVencimentoOpcoes = dataVencimentoOpcoes;
	}
	public void setDataVencimentoOpcoes(String dataven) {
		this.dataVencimentoOpcoes = trataData(dataven);
	}
	
	public Integer getFatorCotacao() {
		return fatorCotacao;
	}
	public void setFatorCotacao(Integer fatorCotacao) {
		this.fatorCotacao = fatorCotacao;
	}
	
	public double getPrecoPontoRefDolar() {
		return precoPontoRefDolar;
	}
	public void setPrecoPontoRefDolar(double precoPontoRefDolar) {
		this.precoPontoRefDolar = precoPontoRefDolar;
	}
	
	public String getCodigoIsin() {
		return codigoIsin;
	}
	public void setCodigoIsin(String codigoIsin) {
		this.codigoIsin = codigoIsin;
	}
	
	public int getNumeroDistribuicao() {
		return numeroDistribuicao;
	}
	public void setNumeroDistribuicao(int numeroDistribuicao) {
		this.numeroDistribuicao = numeroDistribuicao;
	}
	
	public DiarioBase carregaValores(String linha, String idHead){
		int i = 0;
		this.setIdHead(idHead);
        this.setTipoRegistro(Long.parseLong(linha.substring(i, i=i+2)));
        this.setDataPregao(linha.substring(i, i=i+8));
        this.setCodigoBDI(linha.substring(i, i=i+2));
        this.setCodigoNegociacaoPapel(linha.substring(i, i=i+12).trim());
        this.setTipoMercado(Long.parseLong(linha.substring(i, i=i+3)));
        this.setNomeResumidoPapel(linha.substring(i, i=i+12).trim());
        this.setEspecificacaoPapel(linha.substring(i, i=i+10));
        this.setPrazoMercadoTermo(linha.substring(i, i=i+3).trim());
        this.setMoedaReferencia(linha.substring(i, i=i+4).trim());
        this.setPrecoAbertura(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMaximo(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMinimo(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMedio(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoFechamento(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMelhorOfertaCompra(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMelhorOfertaVenda(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setNegociosEfetuados(new Integer ((linha.substring(i, i=i+5))));
        this.setTitulosNegociados(Long.parseLong(linha.substring(i, i=i+18)));
        this.setVolumeNegociado(Double.parseDouble(linha.substring(i, i=i+16) + "." +linha.substring(i, i=i+2)));
        this.setPrecoMercadoOpcoes(Double.parseDouble(linha.substring(i, i=i+11) + "." +linha.substring(i, i=i+2)));
        this.setIndicadorCorrecao(Long.parseLong(linha.substring(i, i=i+1)));
        this.setDataVencimentoOpcoes(linha.substring(i, i=i+8));
        this.setFatorCotacao(new Integer(linha.substring(i, i=i+7)));
        this.setPrecoPontoRefDolar(Double.parseDouble(linha.substring(i, i=i+7) + "." +linha.substring(i, i=i+6)));
        this.setCodigoIsin(linha.substring(i, i=i+12));
        this.setNumeroDistribuicao(new Short(linha.substring(i, i=i+3)));
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
	
	public DiarioBase() {
		super();	
	}

    public DiarioBase(String idHead, String tipoRegistro, String dataPregao, String codigoBDI, String codigoNegociacaoPapel, String tipoMercado,
    				  String nomeResumidoPapel, String especificacaoPapel, String prazoMercadoTermo, String moedaReferencia,  String precoAbertura,  
    				  String precoMaximo,  String precoMinimo, String precoMedio, String precoFechamento, String precoMelhorOfertaCompra, String precoMelhorOfertaVenda,
    				  String negociosEfetuados, String titulosNegociados, String volumeNegociado, String precoMercadoOpcoes, String indicadorCorrecao, 
    				  String dataVencimentoOpcoes, String fatorCotacao, String precoPontoRefDolar, String codigoIsin, String numeroDistribuicao) {
		this.idHead 				= idHead;
        this.tipoRegistro 			= Long.parseLong(tipoRegistro);
        this.dataPregao 			= trataData(dataPregao);
        this.codigoBDI				= codigoBDI;
        this.codigoNegociacaoPapel	= codigoNegociacaoPapel;
        this.tipoMercado			= Long.parseLong(tipoMercado);
        this.nomeResumidoPapel		= nomeResumidoPapel;
        this.especificacaoPapel		= especificacaoPapel;
        this.prazoMercadoTermo		= prazoMercadoTermo;
        this.moedaReferencia		= moedaReferencia;
        this.precoAbertura			= Double.parseDouble(precoAbertura);
        this.precoMaximo			= Double.parseDouble(precoMaximo);
        this.precoMinimo			= Double.parseDouble(precoMinimo);
        this.precoMedio				= Double.parseDouble(precoMedio);
        this.precoFechamento		= Double.parseDouble(precoFechamento);
        this.precoMelhorOfertaCompra = Double.parseDouble(precoMelhorOfertaCompra);
        this.precoMelhorOfertaVenda	= Double.parseDouble(precoMelhorOfertaVenda);
        this.negociosEfetuados		= new Integer(negociosEfetuados);
        this.titulosNegociados		= Long.parseLong(titulosNegociados);
        this.volumeNegociado		= Double.parseDouble(volumeNegociado);
        this.precoMercadoOpcoes		= Double.parseDouble(precoMercadoOpcoes);
        this.indicadorCorrecao		= Long.parseLong(indicadorCorrecao);
        this.dataVencimentoOpcoes	= trataData(dataVencimentoOpcoes);
        this.fatorCotacao			= new Integer(fatorCotacao);
        this.precoPontoRefDolar		= Double.parseDouble(precoPontoRefDolar);
        this.codigoIsin				= codigoIsin;
        this.numeroDistribuicao		= new Short(numeroDistribuicao);
    }

    @Override
    public String toString() {
        return "DiarioBase{" +
                "id='" + id + '\'' +
                ", idHead='" + tipoRegistro + '\'' +
                ", tipoRegistro='" + tipoRegistro + '\'' +
                ", dataPregao='" + dataPregao + '\'' +
                ", codigoBDI='" + codigoBDI + '\'' +
                ", codigoNegociacaoPapel='" + codigoNegociacaoPapel + '\'' +
                ", tipoMercado='" + tipoMercado + '\'' +
                ", nomeResumidoPapel='" + nomeResumidoPapel + '\'' +
                ", especificacaoPapel='" + especificacaoPapel + '\'' +
                ", prazoMercadoTermo='" + prazoMercadoTermo + '\'' +
                ", moedaReferencia='" + moedaReferencia + '\'' +
                ", precoAbertura='" + precoAbertura + '\'' +
                ", precoMaximo='" + precoMaximo + '\'' +
                ", precoMinimo='" + precoMinimo + '\'' +
                ", precoMedio='" + precoMedio + '\'' +
                ", precoFechamento='" + precoFechamento + '\'' +
                ", precoMelhorOfertaCompra='" + precoMelhorOfertaCompra + '\'' +
                ", precoMelhorOfertaVenda='" + precoMelhorOfertaVenda + '\'' +
                ", negociosEfetuados='" + negociosEfetuados + '\'' +
                ", titulosNegociados='" + titulosNegociados + '\'' +
                ", volumeNegociado='" + volumeNegociado + '\'' +
                ", precoMercadoOpcoes='" + precoMercadoOpcoes + '\'' +
                ", indicadorCorrecao='" + indicadorCorrecao + '\'' +
                ", dataVencimentoOpcoes='" + dataVencimentoOpcoes + '\'' +
                ", fatorCotacao='" + fatorCotacao + '\'' +
                ", precoPontoRefDolar='" + precoPontoRefDolar + '\'' +
                ", codigoIsin='" + codigoIsin + '\'' +
                ", numeroDistribuicao='" + numeroDistribuicao + '\'' +
                '}';
    }

}
