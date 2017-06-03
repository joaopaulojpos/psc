package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Atendente;

public class DAOAtendente extends DAOGenerico<Atendente> implements IAtendente{

	public DAOAtendente(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Atendente pesquisarCRF(String crf) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT a FROM Atendente a WHERE a.crf = :filtro";
		Query q = em.createQuery(consulta, Atendente.class);
		q.setParameter("filtro", crf);
		List<Atendente> Atendentes = q.getResultList();
		return Atendentes.get(0);
	}
}