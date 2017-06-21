package popularBanco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumStatus;
import basicas.Medicamento;
import basicas.Receita;
import basicas.StatusReceita;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirReceita {
	
	public TestaInserirReceita(){
		inserirReceita();
	}
	
	public void inserirReceita(){
		receita1();
		receita2();
	}
	
	public void receita1(){
		EntityManagerFactory emf = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Receita receita = new Receita();			
			receita.setDoenca(Fachada.getInstance().pesquisarDoencaPorCND("A01-A01"));
			
			List<Medicamento> listaMedicamentos = new ArrayList<>();
			Medicamento med1 = new Medicamento();
			med1 = Fachada.getInstance().pesquisarMedicamento("REPOFLOR 100MG COM 12 CÁPSULAS");
			listaMedicamentos.add(med1);
			receita.setListaMedicamentos(listaMedicamentos);
			
			receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111"));
			receita.setPaciente(Fachada.getInstance().listarPacienteporCNS("123.1234.1234.1234"));			
			
			Calendar geracao = Calendar.getInstance();			
			Calendar prazo =  Calendar.getInstance();
			prazo.add(Calendar.MONTH, 1);
						
			receita.setDataGeracao(geracao);
			receita.setPrazo(prazo);																			
														
			Fachada.getInstance().inserirReceita(receita);
			
			//STATUS ABERTA
			StatusReceita status = new StatusReceita();
			
			Calendar alteracao = Calendar.getInstance();																						
			status.setDataAlteracao(alteracao);
					
			status.setUsuarioAlteracao(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111").getUsuario());			
			status.setStatus(EnumStatus.ABERTA.toString());		
			

			status.setReceita(receita);
			List<StatusReceita> listaStatus = new ArrayList<>();
			listaStatus.add(status);
			receita.setListaStatusReceita(listaStatus);
			
			receita.setUltimoStatus(status);
			
			Fachada.getInstance().inserirStatusReceita(status);	
			Fachada.getInstance().editarReceita(receita);						
			
		} catch (ClassNotFoundException | ValidacaoException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}	
	}
	
	public void receita2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Receita receita = new Receita();			
			receita.setDoenca(Fachada.getInstance().pesquisarDoencaPorCND("A02-A02"));
			
			List<Medicamento> listaMedicamentos = new ArrayList<>();
			Medicamento med1 = new Medicamento();
			med1 = Fachada.getInstance().pesquisarMedicamento("ATENOLOL 25MG COM 30 COMPRIMIDOS");
			listaMedicamentos.add(med1);
			receita.setListaMedicamentos(listaMedicamentos);
			
			receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 22222"));
			receita.setPaciente(Fachada.getInstance().listarPacienteporCNS("123.1234.1234.1235"));			
			
			Calendar geracao = Calendar.getInstance();			
			Calendar prazo =  Calendar.getInstance();
			System.out.println(sdf.format(geracao.getTime()));
			System.out.println(sdf.format(prazo.getTime()));
			prazo.add(Calendar.MONTH, 1);
						
			System.out.println(sdf.format(geracao.getTime()));
			System.out.println(sdf.format(prazo.getTime()));
			receita.setDataGeracao(geracao);
			receita.setPrazo(prazo);																			
														
			Fachada.getInstance().inserirReceita(receita);
			
			//STATUS ABERTA
			StatusReceita status = new StatusReceita();
			
			Calendar alteracao = Calendar.getInstance();																						
			status.setDataAlteracao(alteracao);
					
			status.setUsuarioAlteracao(Fachada.getInstance().listarMedicoCRM("CRM/PE 22222").getUsuario());			
			status.setStatus(EnumStatus.ABERTA.toString());		
			

			status.setReceita(receita);
			List<StatusReceita> listaStatus = new ArrayList<>();
			listaStatus.add(status);
			receita.setListaStatusReceita(listaStatus);
			
			receita.setUltimoStatus(status);
			
			Fachada.getInstance().inserirStatusReceita(status);	
			Fachada.getInstance().editarReceita(receita);						
			
		} catch (ClassNotFoundException | ValidacaoException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}	
	}
	
}
