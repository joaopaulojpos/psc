package TestUnit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import basicas.Atendente;
import basicas.Paciente;
import rn.Fachada;
import rn.RNPaciente;
import util.exceptions.ValidacaoException;

public class CRUDPacienteTest {

	RNPaciente rnpaciente = new RNPaciente();
	
	@Test
	public void inserirTest() throws ValidacaoException{
		
		Paciente paciente = new Paciente();
		paciente.setCpf("123.434.455-65");
		paciente.setCns("111.2222.5555.6677");
		paciente.setNome("Nixon Dantas");
		paciente.setRg("2.333.221");
		
		rnpaciente.inserir(paciente);
		
		assertEquals(paciente,Fachada.getInstance().listarPacienteporCNS(paciente.getCns()));
		
	}
	
	@Test
	public void removerTest(){
		Paciente paciente1 = new Paciente();
		paciente1 = Fachada.getInstance().listarPacienteporCNS("111.2222.5555.6677");
		Fachada.getInstance().removerPaciente(paciente1);
	}

	@Test
	public void alterarTest(){
		Paciente paciente1 = new Paciente();
		paciente1 = Fachada.getInstance().listarPacienteporCNS("111.2222.5555.6666");
		paciente1.setNome("Pablo");
		Fachada.getInstance().editarPaciente(paciente1);
		paciente1 = new Paciente();
		paciente1 = Fachada.getInstance().listarPacienteporCNS("111.2222.5555.6666");
		assertEquals(paciente1.getNome(),"Pablo");
	}
	
	@Test
	public void pesquisarCNS(){
		Paciente p = new Paciente();
		
		p =rnpaciente.listarPacienteCNS("222.3333.4444.5555");
		assertEquals(p.getNome(),"Rhuan Nixon");
	}
}
