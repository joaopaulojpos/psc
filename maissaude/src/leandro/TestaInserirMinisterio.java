package leandro;

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
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			
			Usuario usuario = new Usuario();
			usuario.setLogin("roberto.justos");
			usuario.setPerfil(EnumPerfil.MINISTERIO.toString());
			usuario.setSenha("robertoMini123");			
			
			Ministerio ministerio = new Ministerio();
			ministerio.setCpf("333.333.333-33");
			ministerio.setNome("Roberto Justos");
			ministerio.setRg("3.333.333");
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
