package org.apache.maven.batch.start;

import java.util.Calendar;
import java.util.List;

import org.apache.maven.batch.business.DownloadCotacao;
import org.apache.maven.batch.business.ExtracaoArquivos;
import org.apache.maven.batch.dao.DiarioBaseDAO;
import org.apache.maven.batch.dao.HeadDAO;
import org.apache.maven.batch.entities.DiarioBase;
import org.apache.maven.batch.entities.Head;
import org.apache.maven.batch.util.BatchConstants;


public class MainCarregaBase {
    
    
	 public static void main(String[] args) throws Exception {
		DiarioBaseDAO dao = new DiarioBaseDAO();
		HeadDAO daoH = new HeadDAO();
		
//		Head head = new Head();
//		head.setNomeArquivoh("COTAHIST.1986");
//		List<Head> heads = daoH.pesquisaHead(head);
//		
//		List<Head> headAll = daoH.findAllHead();
//		
//		Head head2 = daoH.findOneHead(head);
		
//		DiarioBase diario = new DiarioBase();
//		diario.setIdHead(headAll.get(3).getId());
		
//		List<DiarioBase> diarios = dao.findAllDiarios();
//		
//		System.out.println("chegou aqui");
		
//		dao.apaga();
//		daoH.apaga();
		
		
		Calendar hoje = Calendar.getInstance();
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DAY_OF_YEAR, - 1);
		Calendar ultimoRegistro = Calendar.getInstance();
		
		try{
			ultimoRegistro.setTime(dao.dataUltimoRegistro());
		} catch (Exception ex) { 
			ultimoRegistro.set(Calendar.YEAR, 1985);
		}
		
		String[] pastas = null;
		String[] arquivos = new String[6];
		boolean contem = false;
		int controle = 2;
		 
		while(ultimoRegistro.before(ontem)){
			pastas = DownloadCotacao.downloadArquivo(ultimoRegistro, hoje);
			contem = false;
			if(arquivos[0] == null || arquivos[0] == ""){
				arquivos[0] = pastas[1]; 
				arquivos[1] = pastas[2];
			}
			if(arquivos[0] != null || arquivos[0] != ""){
				for(int i = 0; arquivos.length > i; i++){
					if(arquivos[i] != null && arquivos[i].equals(pastas[1])){
						contem = true;
						break;
					}
				}
				if(!contem){
					arquivos[controle] = pastas[1];
					arquivos[controle + 1] = pastas[2];
					controle = controle + 2;
				}
			}
			
		}
		
		System.out.println("chegou aqui");
		ExtracaoArquivos.extrairEPersistir(BatchConstants.pathLocal, arquivos);

		
		 // Limpa Base e verifica a limpeza da Head Apenas
//		HeadDAO daoH = new HeadDAO();
//		List<DBObject> testeList = daoH.findAll();
//		
//		for (DBObject object : testeList) {
//			@SuppressWarnings("unused")
//			Head head = new HeadConverter().converterToObject(object);
//			String idhead = daoH.getLastId();
//			daoH.remove(head);
//			
//		}
//		
//		DiarioBaseDAO daoD = new DiarioBaseDAO();
//		List<DBObject> testeListD = daoD.findAll();
//		
//		for (DBObject object : testeListD) {
//			@SuppressWarnings("unused")
//			DiarioBase diario = new DiarioBaseConverter().converterToObject(object);
////			String idDiario = daoD.getLastId();
//			daoD.remove(diario);
//			
//		}
		
//		@SuppressWarnings("unused")
//		List<DBObject> testeList2 = daoH.findAll();
//		List<DBObject> testeList3 = daoD.findAll();
//		
		
	 }
}
