package popularBanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Doenca;
import rn.Fachada;
import util.exceptions.ValidacaoException;

public class TestaInserirDoenca {
	//https://www.terra.com.br/vida-e-estilo/saude/doencas-e-tratamentos/avc-e-cancer-veja-as-doencas-cronicas-mais-comuns-no-brasil,4a1dc03634c5c410VgnVCM10000098cceb0aRCRD.html
	
	EntityManagerFactory emf = null;
	
	public TestaInserirDoenca(){
		inserirDoenca();
	}

	public void inserirDoenca(){
		doenca1();
		doenca2();
		doenca3();				
		doenca4();
		doenca5();
		doenca6();		
	}
	
	//Métodos Auxiliares
	
	public void doenca1(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A01-A01");
			doenca.setNome("Diarreia");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
            }
		}
	}
	
	public void doenca2(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A02-A02");
			doenca.setNome("Hipertensão Arterial");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
            }
		}
	}
	
	public void doenca3(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A03-A03");
			doenca.setNome("Diabetes");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
            }
		}
	}
	
	public void doenca4(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A04-A04");
			doenca.setNome("Colesterol alto");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
            }
		}
	}
	
	public void doenca5(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A05-A05");
			doenca.setNome("Asma");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
			} catch (ValidacaoException | ClassNotFoundException e) { 
				e.printStackTrace();
			}finally{
				// Fechando o gerenciador.			 						
				if (emf != null) {
	                emf.close();
            }
		}
	}
	
	public void doenca6(){
		try {						
			Class.forName("com.mysql.jdbc.Driver");
			// Obtendo o gerenciador de entidades
			emf = Persistence.createEntityManagerFactory("maissaude");
					
			Doenca doenca = new Doenca();
			doenca.setCnd("A06-A06");
			doenca.setNome("Gripe");
			
			Fachada.getInstance().inserirDoenca(doenca);	
			
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
