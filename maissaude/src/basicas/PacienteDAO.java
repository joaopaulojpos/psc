package basicas;

import javax.persistence.EntityManagerFactory;

import dao.DAOGenerico;

public class PacienteDAO extends DAOGenerico<Paciente>{

	public PacienteDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
