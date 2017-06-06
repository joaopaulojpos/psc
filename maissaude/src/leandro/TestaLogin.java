package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.EnumPerfil;
import basicas.Medico;
import rn.Fachada;
import rn.RNMedico;
import util.exceptions.ValidacaoException;

public class TestaLogin {
	public static void main(String args[]){
		EntityManagerFactory emf = null;
		try {
					
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medico medico = new Medico();
			medico.setCpf("111.111.111-61");
			//Ex.: CRM/PE 82333
			medico.setCrm("CRM/PE 11111");
			medico.setLogin("celio_maranhao");
			medico.setNome("Celio Maranhao");
			medico.setRg("1.111.111");
			medico.setSenha("celioMedico123");
			medico.setPerfil(EnumPerfil.MEDICO.toString());
						
				Fachada.getInstance().inserirMedico(medico);
			} catch (ValidacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
	            }
			}
			
	}
}
