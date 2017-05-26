package utilTestes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import basicas.Atendente;
import basicas.Doenca;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import dao.DAODoenca;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@SuppressWarnings("deprecation")
public class TestaDAOOld {
	

		@SuppressWarnings("deprecation")
		public static void main(String [] args) {
			// Obtendo o gerenciador de entidades
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("maissaude");
//			EntityManager em = emf.createEntityManager();
			// Abrindo transações
//			EntityTransaction et = em.getTransaction();
//			et.begin();
			// Instanciar objeto para inserir
			/*		
//			Doenca d = em.find(Doenca.class, 1);
//			
//			Farmaceutico f = em.find(Farmaceutico.class, 1);
//			
//			Medicamento me = em.find(Medicamento.class, 1);
//			
//			Medico med = em.find(Medico.class, 1);
//			
//			Paciente m = em.find(Paciente.class, 1);
			
			
			// Realizando a operação de persistência
//			Receituario re = em.find(Receituario.class, 1);
			*/
			Fachada f = Fachada.getInstance();
			List<Medicamento> m = new ArrayList<Medicamento>();
			Medico me = new Medico();
			Paciente p = new Paciente();
			Doenca d = new Doenca();
			Receita r = new Receita();
			m.add(f.listarMedicamentos().get(0));
			
			Atendente a = new Atendente();
			a.setIdPessoa(65536);
			
			r.setDoenca(f.listarDoencaporCND("123"));
			r.setAtendente(a);
			r.setListaMedicamentos(m);
			r.setMedico(f.listarMedicoCRM("CRF/PE 5265"));
			r.setPaciente(f.listarPacienteporCPF("111.111.222-00"));
			try {
				f.inserirReceita(r);
			} catch (ValidacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				// TODO Auto-generated catch block
//			em.persist(d);
//			et.commit();
//			// Fechando o gerenciador.
//			em.close(); 
//			emf.close();


		}
	
}
