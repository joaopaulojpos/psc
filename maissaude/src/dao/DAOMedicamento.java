package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Medicamento;

public class DAOMedicamento extends DAOGenerico<Medicamento> implements IMedicamento{

	public DAOMedicamento(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Medicamento pesquisarNome(String nome) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT m FROM Medicamento m WHERE m.nome = :filtro";
		Query q = em.createQuery(consulta, Medicamento.class);
		q.setParameter("filtro", nome);
		List<Medicamento> medicamentos = q.getResultList();
		return medicamentos.get(0);
	}
}
