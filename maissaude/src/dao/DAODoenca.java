package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Doenca;
import basicas.Medico;

public class DAODoenca extends DAOGenerico<Doenca> implements IDoenca{

	public DAODoenca(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Doenca pesquisarCND(String cnd) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT d FROM Doenca d WHERE d.cnd = :filtro";
		Query q = em.createQuery(consulta, Doenca.class);
		q.setParameter("filtro", cnd);
		List<Doenca> doencas = q.getResultList();
		if(doencas == null || doencas.isEmpty()){
			return null;
		}else{
			return doencas.get(0);
		}	
	}

}
