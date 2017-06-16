package popularBanco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Doenca;
import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import basicas.StatusReceita;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirReceita {
	
	public TestaInserirReceita(){
		inserirReceita();
	}
	
	public void inserirReceita(){
		receita1();
	}
	
	public void receita1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Receita receita = new Receita();			
			receita.setDoenca(Fachada.getInstance().pesquisarDoencaporCND("A01-A01"));
			
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
									
			receita.setControlada(false);	
														
			Fachada.getInstance().inserirReceita(receita);
			
			//STATUS ABERTA
			StatusReceita status = new StatusReceita();
			
			Calendar alteracao = Calendar.getInstance();																						
			status.setDataAlteracao(alteracao);
					
			status.setUsuarioAlteracao(Fachada.getInstance().listarAtendentesCPF("785.974.883-52").getUsuario());			
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
