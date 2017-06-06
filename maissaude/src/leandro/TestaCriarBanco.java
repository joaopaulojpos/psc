package leandro;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriarBanco {
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("maissaude");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
}
