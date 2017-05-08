package dao;

import javax.persistence.EntityManagerFactory;

import basicas.Paciente;

public class DAOPaciente extends DAOGenerico<Paciente>{

	public DAOPaciente(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
