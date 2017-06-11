package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Doenca;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirDoenca {

	public TestaInserirDoenca(){
		inserirDoenca();
	}

	public void inserirDoenca(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
//			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A11-A11");
			doenca.setNome("Diarreia");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
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
