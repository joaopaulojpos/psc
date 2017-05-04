package basicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.DoencaDAO;

public class Programa {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Obtendo o gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
		EntityManager em = emf.createEntityManager();
		// Abrindo transações
		EntityTransaction et = em.getTransaction();
		et.begin();
		// Instanciar objeto para inserir
		
//		Doenca d = em.find(Doenca.class, 1);
//		
//		Farmaceutico f = em.find(Farmaceutico.class, 1);
//		
//		Medicamento me = em.find(Medicamento.class, 1);
//		
//		Medico med = em.find(Medico.class, 1);
//		
//		Paciente m = em.find(Paciente.class, 1);
		
		
		// Realizando a operação de persistência
//		Receituario re = em.find(Receituario.class, 1);
		
		Doenca d = new Doenca();
		d.setDescricao("Qualquer coisa");
		d.setCausa("");
		d.setGravidade(Gravidade.ALTISSIMA);
		DoencaDAO dao = new DoencaDAO(emf);
		dao.remover(d);
		
		// Fechando o gerenciador.
		em.close(); 
		emf.close();


	}

}
