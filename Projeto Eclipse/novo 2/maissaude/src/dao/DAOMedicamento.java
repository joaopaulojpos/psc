package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Medicamento;
import basicas.Medico;

public class DAOMedicamento extends DAOGenerico<Medicamento> implements IMedicamento{

	public DAOMedicamento(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Medicamento pesquisarNome(String nome) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT m FROM Medicamento m WHERE m.nome Like :filtro";
		Query q = em.createQuery(consulta, Medicamento.class);
		q.setParameter("filtro", nome);
		List<Medicamento> medicamento = q.getResultList();
		if(medicamento == null || medicamento.isEmpty()){
			return null;
		}else{
			return medicamento.get(0);
		}	
	}

}
