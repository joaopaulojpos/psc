package dao;


import javax.persistence.EntityManagerFactory;

import basicas.Receita;

public class DAOReceita extends DAOGenerico<Receita>{

	public DAOReceita(EntityManagerFactory emf) {
		super(emf);
	}

}
