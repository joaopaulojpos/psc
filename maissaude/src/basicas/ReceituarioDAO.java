package basicas;

import javax.persistence.EntityManagerFactory;

import dao.DAOGenerico;

public class ReceituarioDAO extends DAOGenerico<Receituario>{

	public ReceituarioDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
