package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Medico;
import basicas.Paciente;

public class DAOPaciente extends DAOGenerico<Paciente> implements IPaciente{

	public DAOPaciente(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Paciente pesquisarCPF(String cpf) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT p FROM Paciente p WHERE p.cpf = :filtro";
		Query q = em.createQuery(consulta, Paciente.class);
		q.setParameter("filtro", cpf);
		List<Paciente> pacientes = q.getResultList();
		if(!pacientes.isEmpty()){
			return pacientes.get(0);
		}else{
			return null;
		}	
	}
	
	@Override
	public Paciente pesquisarCNS(String cns) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT p FROM Paciente p WHERE p.cns = :filtro";
		Query q = em.createQuery(consulta, Paciente.class);
		q.setParameter("filtro", cns);
		List<Paciente> pacientes = q.getResultList();
		if(pacientes == null || pacientes.isEmpty()){
			return null;
		}else{
			return pacientes.get(0);
		}	
	}
}
