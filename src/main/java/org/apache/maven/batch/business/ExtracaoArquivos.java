package org.apache.maven.batch.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.maven.batch.dao.DiarioBaseDAO;
import org.apache.maven.batch.dao.HeadDAO;
import org.apache.maven.batch.entities.DiarioBase;
import org.apache.maven.batch.entities.Head;
import org.apache.maven.batch.util.BatchConstants;

public class ExtracaoArquivos {
	
	static HeadDAO daoh = new HeadDAO();
	static DiarioBaseDAO daoD = new DiarioBaseDAO();
	
	/**
     * Método que extrai arquivos para serem lidos 
     * @param stringDirBase
     * @param nomePastaOrigem
     * @param nomePastaDestino 
     */
    private static void extraiArquivos(String stringDirBase, String nomePastaOrigem, String nomePastaDestino){
        ManipulacaoArquivos manArq = new ManipulacaoArquivos();
        ArrayList<String> arquivos = manArq.verificaArquivosBaixados(stringDirBase + BatchConstants.path + nomePastaOrigem + File.separator);
        ArrayList<String> arquivosE = manArq.verificaArquivosBaixados(stringDirBase + BatchConstants.path + nomePastaDestino + File.separator);
        
        ManipulacaoArquivos.criaVerificaDiretorio(stringDirBase, nomePastaDestino + BatchConstants.path);
        
        for (String nome : arquivos) {
            String arquivoO = nome;
            String arquivoO3 = arquivoO.substring(0, arquivoO.lastIndexOf(".")) + ".TXT";
            arquivoO = arquivoO.substring(0, arquivoO.lastIndexOf(".")) + ".txt";
            String arquivoO2 = arquivoO;
            arquivoO = arquivoO.replace("_", ".");
            
            if(!arquivosE.contains(arquivoO) && !arquivosE.contains(arquivoO2) && !arquivosE.contains(arquivoO3)){
                String extensao = nome.substring(nome.length() - 3, nome.length());

                if(extensao.compareToIgnoreCase("zip") != 0){
                   arquivos.remove(nome);
                }
                manArq.extraiZip(stringDirBase + BatchConstants.path + nomePastaOrigem + BatchConstants.path + nome, stringDirBase + BatchConstants.path + nomePastaDestino + BatchConstants.path);
            }
        }
    }
    

  /**
   * Método que coordena a leitura e a gravação dos arquivos na tabela
   * @param arquivo
 * @param arquivos 
 * @throws Exception
   */
    private static void lerGravarArquivo(String arquivo, ArrayList<String> arquivos) throws Exception {
    	
        
        for (String arquiv : arquivos){
			Scanner ler = new Scanner(arquivo + arquiv);
	        String nome = ler.nextLine();
	        
	        Collection<DiarioBase> diariobaseCollection = new ArrayList<DiarioBase>();
	       
	        try (FileReader arq = new FileReader(nome)) {
				BufferedReader lerArq = new BufferedReader(arq);
	            String linha = lerArq.readLine();  
	           
	            Head headtrailer = new Head();
	            headtrailer = headtrailer.carregaValores(linha);
	            DiarioBase diario;
	            
	            if(daoh.verigicaRegistro(headtrailer)){
	            	headtrailer = daoh.findOneHead(headtrailer);
	            	if(null == headtrailer.getTotalRegistros()){
	                    String idhead = daoh.getLastId();
	                    linha = lerArq.readLine();
	                    
	                    while(!linha.substring(0, 2).equals("99")){
	                        diario = new DiarioBase().carregaValores(linha, idhead);
	                        
//	                        if(daoD.verigicaRegistro(diario)){
                			diariobaseCollection.add(diario);
                			System.out.println("Loop 1: "+ diariobaseCollection.size());
//	                		}
	                        linha = lerArq.readLine();
	                    }
	
	                    gravaDiarioBase(diariobaseCollection, linha, headtrailer);
	            	}
	            } else {
	            	daoh.persist(headtrailer);
	                String idhead = daoh.getLastId();
	                linha = lerArq.readLine();
	                while(!linha.substring(0, 2).equals("99")){
	                	diariobaseCollection.add(new DiarioBase().carregaValores(linha, idhead));
	                	System.out.println("Loop 2: "+ diariobaseCollection.size());
	                    linha = lerArq.readLine();
	                }
	                
	                gravaDiarioBase(diariobaseCollection, linha, headtrailer);
	            }
	            
	            
	            lerArq.close();
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(ExtracaoArquivos.class.getName()).log(Level.SEVERE, null, ex);
	            extracted(ex);
	        } catch (IOException ex) {
	            Logger.getLogger(ExtracaoArquivos.class.getName()).log(Level.SEVERE, null, ex);
	            extracted(ex);
	        } catch (Exception ex) {
	            Logger.getLogger(ExtracaoArquivos.class.getName()).log(Level.SEVERE, null, ex);
	            extracted(ex);
	        }
	        
	        ler.close();
        }
    }


private static void extracted(Exception ex) throws Exception {
	throw new Exception(ex);
}


private static void extracted(IOException ex) throws Exception {
	throw new Exception(ex);
}


private static void extracted(FileNotFoundException ex) throws Exception {
	throw new Exception(ex);
}

    /**
     * Método que grava na tabela diariobase
     * @param diariobaseCollection
     * @param linha
     * @param headtrailer
     * @param daoh
     * @param daoD
     * @throws Exception
     */
	private static void gravaDiarioBase(Collection<DiarioBase> diariobaseCollection, String linha, Head headtrailerOld) throws Exception {
		daoD.persist(diariobaseCollection);
		headtrailerOld = daoh.retornaRegistro(headtrailerOld);
		Head headtrailerNew = new Head();
		headtrailerNew.setId(headtrailerOld.getId());
		headtrailerNew.setTipoRegistroh(headtrailerOld.getTipoRegistroh());
		headtrailerNew.setNomeArquivoh(headtrailerOld.getNomeArquivoh());
		headtrailerNew.setCodigoOrigemH(headtrailerOld.getCodigoOrigemH());
		headtrailerNew.setDataGeracaoArqH(headtrailerOld.getDataGeracaoArqH());
		headtrailerNew.setTotalRegistros(linha);
		daoh.mergeTotalRegistro(headtrailerNew);
	}
    
    /**
     * Método que coordena a extração e a gravação dos arquivos
     * @param nomePastaOrigem
     * @param nomePastaDestino
     * @throws Exception
     */
	public static void extrairEPersistir(String pathLocal, String[] pastas) throws Exception {
        for (int i = 0; pastas.length > i; i++ ){
			extraiArquivos(pathLocal, pastas[i], pastas[i + 1]);
	        ManipulacaoArquivos manip = new ManipulacaoArquivos();
	        ArrayList<String> arquivos;
	        arquivos = manip.verificaArquivosBaixados(pathLocal + pastas[i + 1] + BatchConstants.path);
	        lerGravarArquivo(pathLocal + pastas[i + 1] + BatchConstants.path, arquivos);
	        i++;
        }
	}

}
