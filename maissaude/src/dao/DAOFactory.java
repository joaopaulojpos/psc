package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOGenerico;;

public abstract class DAOFactory {

	
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("hibernatePU");		
	}
	
//	public static AlunoDAO getAlunoDAO(){
//		AlunoDAO dao = new AlunoDAO(factory);
//		return dao;
//	}

	
}
