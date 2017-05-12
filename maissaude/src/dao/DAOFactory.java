package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAOFactory {

	
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("hibernatePU");		
	}
	
	public static MedicoDAO getMedicoDAO(){
		MedicoDAO dao = new MedicoDAO(factory);
		return dao;
	}

	public static PacienteDAO getPacienteDAO(){
		PacienteDAO dao = new PacienteDAO(factory);
		return dao;
	}
	
	public static FarmaceuticoDAO getFarmaceuticoDAO(){
		FarmaceuticoDAO dao = new FarmaceuticoDAO(factory);
		return dao;
	}
	
	public static MedicamentoDAO getMedicamentoDAO(){
		MedicamentoDAO dao = new MedicamentoDAO(factory);
		return dao;
	}
	
	public static DoencaDAO getDoencaDAO(){
		DoencaDAO dao = new DoencaDAO(factory);
		return dao;
	}
}
