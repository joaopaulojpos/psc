package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Atendente;
import basicas.Usuario;

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
		List<Atendente> atendentes = q.getResultList();
		if(atendentes == null || atendentes.isEmpty()){
			return null;
		}else{
			return atendentes.get(0);
		}	
	}

	@Override
	public Atendente pesquisarCpf(String cpf) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT a FROM Atendente a WHERE a.cpf = :filtro";
		Query q = em.createQuery(consulta, Atendente.class);
		q.setParameter("filtro", cpf);
		List<Atendente> Atendentes = q.getResultList();		
		if(!Atendentes.isEmpty()){
			return Atendentes.get(0);
		}else{
			return null;
		}				
	}

	@Override
	public Atendente pesquisarId(Integer id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT a FROM Atendente a WHERE a.idPessoa = :filtro";
		Query q = em.createQuery(consulta, Atendente.class);
		q.setParameter("filtro", id);
		List<Atendente> Atendentes = q.getResultList();		
		if(!Atendentes.isEmpty()){
			return Atendentes.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public Atendente pesquisarUserId(Integer id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT a FROM Atendente a WHERE a.usuario.idUsuario = :filtro";
		Query q = em.createQuery(consulta, Atendente.class);
		q.setParameter("filtro", id);
		List<Atendente> Atendentes = q.getResultList();		
		if(!Atendentes.isEmpty()){
			return Atendentes.get(0);
		}else{
			return null;
		}	
	}
}