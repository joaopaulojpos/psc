package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Medicamento;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirMedicamento {

	public TestaInserirMedicamento(){
		inserirMedicamento();
	}

	public void inserirMedicamento(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(false);
			med.setNome("Repoflor");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
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
