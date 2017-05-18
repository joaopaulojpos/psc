package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import basicas.Doenca;
import dao.DAODoenca;
import dao.DAOMedicamento;

@SuppressWarnings("deprecation")
public class TestaDAO {
	public static void main(String args[]){
		// Obtendo o gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maissaude");
		EntityManager em = emf.createEntityManager();
		// Abrindo transações
		EntityTransaction et = em.getTransaction();
		et.begin();
		// Instanciar objeto para inserir
		Doenca doenca = new Doenca();
		doenca.setNome("Virose");
		doenca.setCnd(456789L);		
		
		//doenca.setId(1);
		
		//Persistindo
		DAODoenca daoDoenca = new DAODoenca(emf);
		
		daoDoenca.inserir(doenca);
		
		
		
		
		// Fechando o gerenciador.
		em.close(); 
		emf.close();

		
	}
}
