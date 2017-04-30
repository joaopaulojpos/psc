package basicas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		// Obtendo o gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
		EntityManager em = emf.createEntityManager();
		// Abrindo transações
		EntityTransaction et = em.getTransaction();
		et.begin();
		// Instanciar objeto para inserir
		
		Doenca d = new Doenca();
		d.setGravidade(Gravidade.BAIXA);
		d.setDescricao("Coceira na cabeça");
		d.setCausa("caspa");
		
		Farmaceutico f = new Farmaceutico();
		f.setNome("Farmaceutico Rhuan");
		f.setRegistroMS("111222333");
		
		Medicamento me = new Medicamento();
		me.setDescricao("AntiCaspa");
		me.setRegistroMS(12334456);
		me.setTipo("FISICA");
		
		Medico med = new Medico();
		med.setCRM(123456);
		med.setNome("Dr Rhuan");
		
		Endereco e = new Endereco();
		Paciente m = new Paciente();
		e.setBairro("Dois Unidos");
		e.setCep("23333333");
		e.setEstado("PE");
		e.setCidade("Recife");
		e.setRua("rua teste");
		m.setEndereco(e);
		m.setDataNasc(new Date(2000,01,21));
		m.setIdSUS(12312341);
		m.setNome("Lambinho");
		m.setSexo('M');
		
		List<Doenca> doencas = new ArrayList<Doenca>();
		List<Medicamento> remedio = new ArrayList<Medicamento>();
		doencas.add(d);
		remedio.add(me);
		Receituario r = new Receituario();
		r.setData(new Date(2017,02,02));
		r.setDoencas(doencas);
		r.setMedicamentos(remedio);
		r.setFarmaceutico(f);
		r.setMedico(med);
		r.setPaciente(m);
		r.setSituacao(Situacao.PENDENTE);
		r.setObservacao("Ta com a cabeça coçando");
		// Realizando a operação de persistência
		em.persist(r);
		et.commit();
		// Fechando o gerenciador.
		em.close(); 
		emf.close();


	}

}
