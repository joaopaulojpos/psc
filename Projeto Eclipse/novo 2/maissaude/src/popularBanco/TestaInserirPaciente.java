package popularBanco;

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
		paciente1();
		paciente2();
		paciente3();
		paciente4();
		paciente5();
		paciente6();
			
	}
	
	public void paciente1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1234");
			paciente.setCpf("025.855.271-90");
			paciente.setNome("Alice Cavalcanti Souza");
			paciente.setRg("42.103.057-4");
			
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
	
	public void paciente2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1235");
			paciente.setCpf("748.380.740-77");
			paciente.setNome("Emilly Fernandes Ferreira");
			paciente.setRg("45.628.170-8");
			
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
	
	public void paciente3(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1236");
			paciente.setCpf("467.491.434-58");
			paciente.setNome("Isabella Goncalves Santos");
			paciente.setRg("44.444.090-2");
			
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
	
	public void paciente4(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1237");
			paciente.setCpf("549.625.129-00");
			paciente.setNome("Julia Ribeiro Cunha");
			paciente.setRg("17.520.926-1");
			
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
	
	public void paciente5(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1238");
			paciente.setCpf("474.695.637-50");
			paciente.setNome("Vinícius Dias Ferreira");
			paciente.setRg("47.954.686-1");
			
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
	
	public void paciente6(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Paciente paciente = new Paciente();
			paciente.setCns("123.1234.1234.1239");
			paciente.setCpf("134.401.589-18");
			paciente.setNome("Luis Barros Araujo");
			paciente.setRg("42.069.424-9");
			
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
