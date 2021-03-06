package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Atendente;
import basicas.Medico;

public class DAOMedico extends DAOGenerico<Medico> implements IMedico{

	public DAOMedico(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Medico pesquisarCRM(String crm) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT m FROM Medico m WHERE m.crm = :filtro";
		Query q = em.createQuery(consulta, Medico.class);
		q.setParameter("filtro", crm);
		List<Medico> medicos = q.getResultList();
		if(medicos == null || medicos.isEmpty()){
			return null;
		}else{
			return medicos.get(0);
		}	
	}
	
	
	//Achei q ia precisar desse m�todo ai criei, mas depois vi q n�o precisava, vou deixar ai pq vai q depois precisa...	 
	@Override
	public Medico pesquisarUserId(Integer id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT m FROM Medico m WHERE m.usuario.idUsuario = :filtro";
		Query q = em.createQuery(consulta, Atendente.class);
		q.setParameter("filtro", id);
		List<Medico> Medicos = q.getResultList();		
		if(!Medicos.isEmpty()){
			return Medicos.get(0);
		}else{
			return null;
		}	
	}

}
