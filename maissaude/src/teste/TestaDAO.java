package teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import basicas.Atendente;
import basicas.Doenca;
import basicas.EnumGravidade;
import basicas.EnumStatus;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Ministerio;
import basicas.Paciente;
import basicas.Receita;
import basicas.StatusReceita;
import dao.DAOAtendente;
import dao.DAODoenca;
import dao.DAOMedicamento;
import dao.DAOMedico;
import dao.DAOMinisterio;
import dao.DAOPaciente;
import dao.DAOReceita;
import dao.DAOStatusReceita;

@SuppressWarnings("deprecation")
public class TestaDAO {
	public static void main(String args[]){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try{
		// Obtendo o gerenciador de entidades
		emf = Persistence.createEntityManagerFactory("maissaude");
		em = emf.createEntityManager();
		// Abrindo transações
		EntityTransaction et = em.getTransaction();
		et.begin();
		// Instanciar objeto para inserir
		
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(false);
		medicamento.setNome("Tylenol");
//		medicamento.setListaReceitas(listaReceitas);
		
		Paciente paciente = new Paciente();
		paciente.setCns("123456789876543");
		paciente.setCpf("11111111111");
		paciente.setNome("Neymar");
		paciente.setRg("11111111");
//		paciente.setListaReceitas(listaReceitas);
		
		StatusReceita statusReceita = new StatusReceita();
		statusReceita.setDataAlteracao(GregorianCalendar.getInstance());
//		statusReceita.setListaReceitas(listaReceitas);
//		statusReceita.setListaUsuarioAlteracoes(listaUsuarioAlteracoes);
		statusReceita.setStatus(EnumStatus.DESPACHADA_PELO_ATENDENTE);
		
		Atendente atendente = new Atendente();
		atendente.setCpf("22222222222");
		atendente.setCrf("222222");
		atendente.setFarmaceutico(false);
//		atendente.setListaReceitas(listaReceitas);
		atendente.setLogin("pedro_silva");
		atendente.setNome("Pedro Silva");
		atendente.setRg("22222222");
		atendente.setSenha("pedrosilva");
		atendente.setStatusReceita(statusReceita);
		
		Medico medico = new Medico();
		medico.setCpf("33333333");
		medico.setCrm("333333");
//		medico.setListaReceitas(listaReceitas);
		medico.setLogin("pablo_neruda");
		medico.setNome("Pablo Neruda");
		medico.setRg("3333333");
		medico.setSenha("pabloneruda");
		medico.setStatusReceita(statusReceita);
		
		
		Doenca doenca = new Doenca();
		doenca.setNome("Febre");
		doenca.setCnd("1");		
		doenca.setGravidade(EnumGravidade.BAIXA);
//		doenca.setListaReceitas(listaReceitas);
		
		Receita receita = new Receita();
		receita.setAtendente(atendente);						
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");	
		receita.setDataGeracao(GregorianCalendar.getInstance());
		receita.setDoenca(doenca);
//		receita.setListaMedicamentos(listaMedicamentos);
		receita.setMedico(medico);
		receita.setPaciente(paciente);				
		receita.setPrazo(GregorianCalendar.getInstance());
		receita.setStatusReceita(statusReceita);						
		
		Ministerio ministerio = new Ministerio();
		ministerio.setCpf("4444444");
		ministerio.setLogin("galvao_bueno");
		ministerio.setNome("Galvao Bueno");
		ministerio.setRg("444444");
		ministerio.setSenha("44444");
		ministerio.setStatusReceita(statusReceita);
		
		
		//Persistindo
//		
		
//		DAOMedicamento daoMedicamento = new DAOMedicamento(emf);
//		daoMedicamento.inserir(medicamento);
		
//		DAOPaciente daoPaciente = new DAOPaciente(emf);
//		daoPaciente.inserir(paciente);
		
//		DAOStatusReceita daoStatusReceita = new DAOStatusReceita(emf);		
//		daoStatusReceita.inserir(statusReceita);
		
//		DAOAtendente daoAtendente = new DAOAtendente(emf);
//		daoAtendente.inserir(atendente);

//		DAOMedico daoMedico = new DAOMedico(emf);
//		daoMedico.inserir(medico);
		
//		DAOMinisterio daoMinisterio = new DAOMinisterio(emf);
//		daoMinisterio.inserir(ministerio);
		
//		DAODoenca daoDoenca = new DAODoenca(emf);		
//		daoDoenca.inserir(doenca);
		
//		DAOReceita daoReceita = new DAOReceita(emf);
//		daoReceita.inserir(receita);
//		

//		

//		

//		

//		

		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.
			em.close(); 
			emf.close();			
		}
		
		
		
		


		
	}
}
