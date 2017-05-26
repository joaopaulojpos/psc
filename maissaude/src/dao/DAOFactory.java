package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAOFactory {

	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("maissaude");		
	}
	
	public static DAOMedico getDAOMedico(){
		DAOMedico dao = new DAOMedico(factory);
		return dao;
	}
	
	public static DAOPaciente getDAOPaciente(){
		DAOPaciente dao = new DAOPaciente(factory);
		return dao;
	}

	public static DAOAtendente getDAOAtendente(){
		DAOAtendente dao = new DAOAtendente(factory);
		return dao;
	}
	
	public static DAOReceita getDAOReceita(){
		DAOReceita dao = new DAOReceita(factory);
		return dao;
	}
	
	public static DAOMedicamento getDAOMedicamento(){
		DAOMedicamento dao = new DAOMedicamento(factory);
		return dao;
	}
	
	public static DAODoenca getDAODoenca(){
		DAODoenca dao = new DAODoenca(factory);
		return dao;
	}
}
