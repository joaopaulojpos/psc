package basicas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		// Obtendo o gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
		EntityManager em = emf.createEntityManager();
		// Abrindo transações
		EntityTransaction et = em.getTransaction();
		et.begin();
		// Instanciar objeto para inserir
		Medico m = new Medico();
		m.setNome("Rhuan Nixon");
		m.setCRM(123456);
		// Realizando a operação de persistência
		em.persist(m);
		et.commit();
		// Fechando o gerenciador.
		em.close(); 
		emf.close();


	}

}
