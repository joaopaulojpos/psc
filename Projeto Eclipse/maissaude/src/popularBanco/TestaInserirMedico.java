package popularBanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumPerfil;
import basicas.Medico;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirMedico {
	
	public TestaInserirMedico(){
		inserirMedico();
	}
	
	public void inserirMedico(){
		medico1();
		medico2();
		medico3();
		medico4();			
	}
	
	public void medico1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			
			medico.setCpf("017.127.754-64");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 11111");
			
			medico.setNome("Karine Brandão");
			medico.setRg("20.203.874-9");						
			Usuario usuario = new Usuario();
			usuario.setLogin("karine.brandao");
			usuario.setSenha("123456");
			usuario.setPerfil(EnumPerfil.MEDICO.toString());			
			medico.setUsuario(usuario);
						
			Fachada.getInstance().inserirUsuario(usuario);			
			Fachada.getInstance().inserirMedico(medico);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medico2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			
			medico.setCpf("533.334.126-59");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 22222");
			
			medico.setNome("Vicente Costa");
			medico.setRg("10.569.946-9");						
			Usuario usuario = new Usuario();
			usuario.setLogin("vicente.costa");
			usuario.setSenha("123456");
			usuario.setPerfil(EnumPerfil.MEDICO.toString());			
			medico.setUsuario(usuario);
						
			Fachada.getInstance().inserirUsuario(usuario);			
			Fachada.getInstance().inserirMedico(medico);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medico3(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			
			medico.setCpf("888.473.625-04");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 33333");
			
			medico.setNome("Gustavo Godoy");
			medico.setRg("30.394.226-5");						
			Usuario usuario = new Usuario();
			usuario.setLogin("gustavo.godoy");
			usuario.setSenha("123456");
			usuario.setPerfil(EnumPerfil.MEDICO.toString());			
			medico.setUsuario(usuario);
						
			Fachada.getInstance().inserirUsuario(usuario);			
			Fachada.getInstance().inserirMedico(medico);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medico4(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			
			medico.setCpf("396.272.538-55");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 44444");
			
			medico.setNome("Lais Vieira");
			medico.setRg("30.394.226-5");						
			Usuario usuario = new Usuario();
			usuario.setLogin("lais.vieira");
			usuario.setSenha("123456");
			usuario.setPerfil(EnumPerfil.MEDICO.toString());			
			medico.setUsuario(usuario);
						
			Fachada.getInstance().inserirUsuario(usuario);			
			Fachada.getInstance().inserirMedico(medico);
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
