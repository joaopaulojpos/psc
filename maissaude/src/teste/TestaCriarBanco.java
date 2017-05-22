package teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriarBanco {
	public static void main(String args[]){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("maissaude");
	}
}
