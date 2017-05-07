package dao;

import javax.persistence.EntityManagerFactory;

import basicas.Paciente;

public class PacienteDAO extends DAOGenerico<Paciente>{

	public PacienteDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
