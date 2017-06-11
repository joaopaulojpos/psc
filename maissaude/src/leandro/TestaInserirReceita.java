package leandro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Doenca;
import basicas.EnumPerfil;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirReceita {
	
	public TestaInserirReceita(){
		inserirReceita();
	}
	
	public void inserirReceita(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Receita receita = new Receita();			
			receita.setDoenca(Fachada.getInstance().listarDoencaporCND("A11-A11"));
			receita.setListaMedicamentos(Fachada.getInstance().listarMedicamentos());
			receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111"));
			receita.setPaciente(Fachada.getInstance().listarPacienteporCNS("444.4444.4444.4444"));			
			
			Calendar geracao = new GregorianCalendar(2017, 6, 8);			
			Calendar praz = new GregorianCalendar(2017, 7, 8);
			receita.setDataGeracao(geracao);
			receita.setPrazo(praz);			
									
							
			Fachada.getInstance().inserirReceita(receita);
			
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
