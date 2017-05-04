package dao;

import javax.persistence.EntityManagerFactory;

import basicas.Medicamento;

public class MedicamentoDAO extends DAOGenerico<Medicamento>{

	public MedicamentoDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
