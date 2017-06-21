package popularBanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Atendente;
import basicas.EnumPerfil;
import basicas.Medico;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirAtendente {
	
	public TestaInserirAtendente(){
		inserirAtendente();
	}
	
	public void inserirAtendente(){
		atendente1();
		atendente2();
		atendente3();		
	}
	
	public void atendente1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Atendente atendente = new Atendente();
			atendente.setCpf("785.974.883-52");
			atendente.setFarmaceutico(false);
			atendente.setNome("Douglas Correia Lima");
			atendente.setRg("43.433.243-4");
			
			Usuario user = new Usuario();
			user.setLogin("douglas.lima");
			user.setPerfil(EnumPerfil.ATENDENTE.toString());
			user.setSenha("123456");
			atendente.setUsuario(user);
			
						
			Fachada.getInstance().inserirUsuario(user);			
			Fachada.getInstance().inserirAtendente(atendente);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}	
	}
	
	public void atendente2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Atendente atendente = new Atendente();
			atendente.setCpf("511.572.465-08");
			atendente.setFarmaceutico(false);
			atendente.setNome("Vitoria Santos Rodrigues");
			atendente.setRg("32.157.625-1");
			
			Usuario user = new Usuario();
			user.setLogin("vitoria.rodrigues");
			user.setPerfil(EnumPerfil.ATENDENTE.toString());
			user.setSenha("123456");
			atendente.setUsuario(user);
			
						
			Fachada.getInstance().inserirUsuario(user);			
			Fachada.getInstance().inserirAtendente(atendente);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}	
	}
	
	public void atendente3(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Atendente atendente = new Atendente();
			atendente.setCpf("774.623.336-86");
			atendente.setFarmaceutico(true);
			atendente.setNome("Brenda Barros Oliveira");
			atendente.setRg("10.977.549-1");
			atendente.setCrf("CRF/PE 11111");
			
			Usuario user = new Usuario();
			user.setLogin("brenda.oliveira");
			user.setPerfil(EnumPerfil.ATENDENTE.toString());
			user.setSenha("123456");
			atendente.setUsuario(user);
			
						
			Fachada.getInstance().inserirUsuario(user);			
			Fachada.getInstance().inserirAtendente(atendente);
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
