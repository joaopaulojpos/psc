package basicas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.MedicoDAO;

public class Programa {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Obtendo o gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
		EntityManager em = emf.createEntityManager();
		// Abrindo transa��es
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
		
		
		// Realizando a opera��o de persist�ncia
//		Receituario re = em.find(Receituario.class, 1);
		
		Doenca d = new Doenca();
		d.setDescricao("Qualquer coisa");
		d.setCausa("");
		d.setGravidade(Gravidade.ALTISSIMA);
		MedicoDAO dao = new MedicoDAO(emf);
		javax.swing.JOptionPane.showMessageDialog(null,dao.medicoPorCrm(123455).toString());
		
		// Fechando o gerenciador.
		em.close(); 
		emf.close();


	}

}
