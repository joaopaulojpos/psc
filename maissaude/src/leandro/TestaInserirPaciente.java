package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Paciente;
import basicas.Receita;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirPaciente {

	public TestaInserirPaciente(){
		inserirPaciente();
	}
	
	public void inserirPaciente(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("444.4444.4444.4444");
			paciente.setCpf("444.444.444-44");
			paciente.setNome("Clovis Almeida");
			paciente.setRg("4.444.444");
			
			Fachada.getInstance().inserirPaciente(paciente);	
			
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
