package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Medico;
import basicas.Receita;

public class DAOReceita extends DAOGenerico<Receita>{

	public DAOReceita(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
		
	public Receita pesquisarID(Integer id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT r FROM Receita r WHERE r.idReceita = :filtro";
		Query q = em.createQuery(consulta, Receita.class);
		q.setParameter("filtro", id);
		List<Receita> receitas = q.getResultList();
		if(receitas == null || receitas.isEmpty()){
			return null;
		}else{
			return receitas.get(0);
		}	
	}
	

	

}
