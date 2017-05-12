package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Medico;

public class MedicoDAO extends DAOGenerico<Medico> implements IMedicoDAO{

	public MedicoDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Medico> medicoPorCrm(Integer crm) {
		List<Medico> medicos = new ArrayList<Medico>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String sql = "SELECT m FROM Medico m where m.CRM = :filtro";
		Query q = em.createQuery(sql,Medico.class);
		q.setParameter("filtro", crm);
		medicos=q.getResultList();
		return medicos;
	}

}
