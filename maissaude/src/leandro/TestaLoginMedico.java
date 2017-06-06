package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumPerfil;
import basicas.Medico;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaLoginMedico {
	public static void main(String args[]){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			
			medico.setCpf("111.111.111-11");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 11111");
			
			medico.setNome("Celio Maranhao");
			medico.setRg("1.111.111");						
			Usuario usuario = new Usuario();
			usuario.setLogin("celio.maranhao");
			usuario.setSenha("celioMedico123");
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
