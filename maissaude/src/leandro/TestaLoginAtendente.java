package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Atendente;
import basicas.EnumPerfil;
import basicas.Medico;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaLoginAtendente {
	public static void main(String args[]){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Atendente atendente = new Atendente();
			atendente.setCpf("222.222.222-22");
			atendente.setFarmaceutico(false);
			atendente.setNome("João Silva");
			atendente.setRg("2.222.222");
			
			Usuario user = new Usuario();
			user.setLogin("joao.silva");
			user.setPerfil(EnumPerfil.ATENDENTE.toString());
			user.setSenha("joaoAtend123");
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
