package popularBanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumPerfil;
import basicas.Ministerio;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirMinisterio{
	
	public TestaInserirMinisterio(){
		inserirMinisterio();
	}
	
	public void inserirMinisterio(){
		ministerio1();
		ministerio2();
	}
	
	public void ministerio1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			
			Usuario usuario = new Usuario();
			usuario.setLogin("davi.alves");
			usuario.setPerfil(EnumPerfil.MINISTERIO.toString());
			usuario.setSenha("123456");			
			
			Ministerio ministerio = new Ministerio();
			ministerio.setCpf("162.379.796-97");
			ministerio.setNome("Davi Oliveira Alves");
			ministerio.setRg("32.265.853-6");
			ministerio.setUsuario(usuario);
			
						
			Fachada.getInstance().inserirUsuario(usuario);
			Fachada.getInstance().inserirMinisterio(ministerio);
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}				
	}
	
	public void ministerio2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			
			Usuario usuario = new Usuario();
			usuario.setLogin("thais.pereira");
			usuario.setPerfil(EnumPerfil.MINISTERIO.toString());
			usuario.setSenha("123456");			
			
			Ministerio ministerio = new Ministerio();
			ministerio.setCpf("345.661.631-72");
			ministerio.setNome("Thaís Carvalho Pereira");
			ministerio.setRg("35.777.950-2");
			ministerio.setUsuario(usuario);
			
						
			Fachada.getInstance().inserirUsuario(usuario);
			Fachada.getInstance().inserirMinisterio(ministerio);
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
