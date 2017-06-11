package leandro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumStatus;
import basicas.Receita;
import basicas.StatusReceita;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirStatusReceita {

	public TestaInserirStatusReceita(){
		inserirStatusReceita();
	}
	
	public void inserirStatusReceita(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			StatusReceita status = new StatusReceita();
			
			Calendar alteracao = new GregorianCalendar(2017, 6, 9);																						
			status.setDataAlteracao(alteracao);
		
			
			status.setUsuarioAlteracao(Fachada.getInstance().listarAtendentesCPF("222.222.222-22").getUsuario());			
			status.setStatus(EnumStatus.ABERTA.toString());		
			Receita rec = new Receita();
			rec = Fachada.getInstance().pesquisarReceitaID("1");
			List<StatusReceita> oldStatus = new ArrayList<>();
			oldStatus = rec.getListaStatusReceita();
			List<StatusReceita> newStatus = new ArrayList<>();
			newStatus.add(status);
			rec.setUltimoStatus(newStatus.get(newStatus.size()));
			Fachada.getInstance().editarReceita(rec);			
			Fachada.getInstance().inserirStatusReceita(status);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
	            }
			}
			
	}

}
