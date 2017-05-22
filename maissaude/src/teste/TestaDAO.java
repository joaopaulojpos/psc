package teste;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Atendente;
import basicas.Doenca;
import basicas.EnumEstado;
import basicas.EnumGravidade;
import basicas.EstadoReceita;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import basicas.Usuario;
import dao.DAOAtendente;
import dao.DAODoenca;
import dao.DAOEstadoReceita;
import dao.DAOMedicamento;
import dao.DAOMedico;
import dao.DAOPaciente;
import dao.DAOReceita;
import dao.DAOUsuario;

@SuppressWarnings("deprecation")
public class TestaDAO {
	public static void main(String args[]){
		EntityManagerFactory emf = null;
		//		EntityManager em = null;
//		EntityTransaction et = null;
		
		try{
//		// Obtendo o gerenciador de entidades
				emf = Persistence.createEntityManagerFactory("maissaude");
		//		em = emf.createEntityManager();
//		// Abrindo transações
//		et = em.getTransaction();
//		et.begin();
//		// Instanciar objeto para inserir
		
		Medicamento tylenol = new Medicamento();
		tylenol.setControlado(false);
		tylenol.setNome("Tylenol");		
		 
		Medicamento benegripe = new Medicamento();
		benegripe.setControlado(false);
		benegripe.setNome("Benegripe");				
		
		Paciente paciente = new Paciente();
		paciente.setCns("123456789876543");
		paciente.setCpf("11111111111");
		paciente.setNome("Neymar");
		paciente.setRg("11111111");
		
		Atendente atendente = new Atendente();
		atendente.setCpf("22222222222");
		atendente.setCrf("222222");
		atendente.setFarmaceutico(false);
		atendente.setLogin("pedro_silva");
		atendente.setNome("Pedro Silva");
		atendente.setRg("22222222");
		atendente.setSenha("pedrosilva");		
		
		Medico medico = new Medico();
		medico.setCpf("33333333");
		medico.setCrm("333333");
		medico.setLogin("pablo_neruda");
		medico.setNome("Pablo Neruda");
		medico.setRg("3333333");
		medico.setSenha("pabloneruda");		
		
		Doenca doenca = new Doenca();
		doenca.setNome("Febre");
		doenca.setCnd("1");		
		doenca.setGravidade(EnumGravidade.BAIXA.toString());
		
		Usuario ministerio = new Usuario();
		ministerio.setCpf("4444444");
		ministerio.setLogin("galvao_bueno");
		ministerio.setNome("Galvao Bueno");
		ministerio.setRg("444444");
		ministerio.setSenha("44444");
		
		Receita receita = new Receita();
		receita.setAtendente(atendente);						
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");	
		receita.setDataGeracao(GregorianCalendar.getInstance());
		receita.setDoenca(doenca);
		receita.setMedico(medico);
		receita.setPaciente(paciente);				
		receita.setPrazo(GregorianCalendar.getInstance());
		
		EstadoReceita estadoReceitaGerada = new EstadoReceita();
		estadoReceitaGerada.setDataAlteracao(GregorianCalendar.getInstance());		
		estadoReceitaGerada.setUsuarioAlteracao(medico);
		estadoReceitaGerada.setEstado(EnumEstado.ABERTA.toString());
				
		EstadoReceita estadoReceitaFechada = new EstadoReceita();
		estadoReceitaFechada.setDataAlteracao(GregorianCalendar.getInstance());		
		estadoReceitaFechada.setUsuarioAlteracao(atendente);
		estadoReceitaFechada.setEstado(EnumEstado.FECHADA.toString());
		
		
//		Adicionando Receita nos 2 estados
		estadoReceitaGerada.setReceita(receita);
		estadoReceitaFechada.setReceita(receita);
		
		
////		Adicionando os 2 estados na lista de estados da Receita
//		List<EstadoReceita> listaStatusReceita = new ArrayList<EstadoReceita>();
//		listaStatusReceita.add(estadoReceitaGerada);
//		listaStatusReceita.add(estadoReceitaFechada);
////		Adicionando a lista de estados na Receita
//		receita.setListaEstadoReceita(listaStatusReceita);	
//		//Adicionando os 2 Medicamentos na lista de Medicamentos da Receita
//		List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
//		listaMedicamentos.add(tylenol);
//		listaMedicamentos.add(benegripe);
//		//Adicionando a lista de Medicamentos na Receita
//		receita.setListaMedicamentos(listaMedicamentos);
//		
//		//Adicionando Receita na lista de Receitas das classes
//		List<Receita> listaReceitas = new ArrayList<Receita>();
//		listaReceitas.add(receita);		
//		tylenol.setListaReceitas(listaReceitas);
//		benegripe.setListaReceitas(listaReceitas);
//		doenca.setListaReceitas(listaReceitas);
//		paciente.setListaReceitas(listaReceitas);
//		atendente.setListaReceitas(listaReceitas);
//		medico.setListaReceitas(listaReceitas);		
//		
//		List<EstadoReceita> listaEstadoReceitaMedico = new ArrayList<EstadoReceita>();
//		listaEstadoReceitaMedico.add(estadoReceitaGerada);
//		medico.setListaEstadoReceita(listaEstadoReceitaMedico);//Método vindo da superclasse Usuario
//		
//		List<EstadoReceita> listaEstadoReceitaAtendente = new ArrayList<EstadoReceita>();
//		listaEstadoReceitaAtendente.add(estadoReceitaFechada);
//		atendente.setListaEstadoReceita(listaEstadoReceitaAtendente);//Método vindo da superclasse Usuario
						
		//Persistindo
		



		DAOMedicamento daoMedicamento = new DAOMedicamento(emf);
		daoMedicamento.inserir(tylenol);		
		daoMedicamento.inserir(benegripe);
		
		DAOPaciente daoPaciente = new DAOPaciente(emf);
		daoPaciente.inserir(paciente);
	
	
		DAOAtendente daoAtendente = new DAOAtendente(emf);
		daoAtendente.inserir(atendente);

		DAOMedico daoMedico = new DAOMedico(emf);
		daoMedico.inserir(medico);
		
		DAOUsuario daoMinisterio = new DAOUsuario(emf);
		daoMinisterio.inserir(ministerio);
		
		DAODoenca daoDoenca = new DAODoenca(emf);		
		daoDoenca.inserir(doenca);
			

		
		DAOReceita daoReceita = new DAOReceita(emf);
		daoReceita.inserir(receita);
		
		DAOEstadoReceita daoEstadoReceitaGerada = new DAOEstadoReceita(emf);		
		daoEstadoReceitaGerada.inserir(estadoReceitaGerada);

		DAOEstadoReceita daoEstadoReceitaFechada = new DAOEstadoReceita(emf);		
		daoEstadoReceitaFechada.inserir(estadoReceitaFechada);
		

		

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// Fechando o gerenciador.			 						
			if (emf != null) {
                emf.close();
            }
		}
	}
}
