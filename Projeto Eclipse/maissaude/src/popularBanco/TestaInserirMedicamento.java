package popularBanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Medicamento;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirMedicamento {

	public TestaInserirMedicamento(){
		inserirMedicamento();
	}

	public void inserirMedicamento(){
		medicamento1();
		medicamento2();
		medicamento3();
		medicamento4();
		medicamento5();
		medicamento6();
		medicamento7();
	}
	
	public void medicamento1(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(false);
			med.setNome("REPOFLOR 100MG COM 12 CÁPSULAS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medicamento2(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(true);
			med.setNome("ATENOLOL 25MG COM 30 COMPRIMIDOS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}

	public void medicamento3(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(true);
			med.setNome("AGLUCOSE 50MG COM 30 COMPRIMIDOS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medicamento4(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(false);
			med.setNome("BENEGRIP COM 6 COMPRIMIDOS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medicamento5(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(true);
			med.setNome("SINVASTACOR 10MG C/ 30 COMPRIMIDOS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medicamento6(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(true);
			med.setNome("ESPAÇADOR AGACHAMBER PARA BRONCODILATADOR COM 1 UNIDADE");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
	
	public void medicamento7(){
		EntityManagerFactory emf = null;
		try {
					
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Medicamento med = new Medicamento();
			med.setControlado(false);
			med.setNome("TYLENOL 750MG COM 4 COMPRIMIDOS");
			
			Fachada.getInstance().inserirMedicamento(med);	
			
		} catch (ValidacaoException | ClassNotFoundException e) { 
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
}
