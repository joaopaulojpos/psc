package TestUnit;


import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import basicas.Atendente;
import basicas.Doenca;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import rn.Fachada;
import rn.RNReceita;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNReceitaTestes {

	RNReceita rn = new RNReceita();
	Receita receita = new Receita();
	Validacao valida = new Validacao();
	Atendente atendente;
	Medico medico;
	Doenca doenca;
	Fachada fachada = Fachada.getInstance();
	
	
	@Before
	public void basicas(){
		
		atendente = new Atendente();
		medico = new Medico();
		doenca = new Doenca();
		
		doenca.setCnd("A01-B01");
		doenca.setGravidade("ALTA");
		doenca.setNome("Dengue");
		
		medico.setCpf("123.434.455-66");
		medico.setCrm("CRM/PE 22233");
		medico.setNome("Rhuan Nixon");
		medico.setRg("2.333.444");
		
		atendente.setCpf("123.434.455-66");
		atendente.setCrf("CRF/PE 22233");
		atendente.setNome("Nixon Dantas");
		atendente.setRg("2.333.222");
		
		Paciente paciente = new Paciente();
		paciente.setCpf("123.434.455-65");
		paciente.setCns("111.2222.5555.6677");
		paciente.setNome("Nixon Dantas");
		paciente.setRg("2.333.221");
		
		receita.setListaMedicamentos(fachada.listarMedicamentos());
		receita.setDoenca(fachada.listarDoencaporCND("A01-B01"));
		receita.setAtendente(atendente);
		receita.setDataGeracao(Calendar.getInstance());
		receita.setDoenca(doenca);
		receita.setListaMedicamentos(Fachada.getInstance().listarMedicamentos());
		receita.setMedico(medico);
		receita.setPaciente(paciente);
		receita.setPrazo(Calendar.getInstance());
		
	}
//----------------------VALIDAÇÃO DA RECEITA-------------\\	
	@Test
	public void testaAtendenteNulo() throws ValidacaoException {
		valida.checkNull(receita.getAtendente());
		valida.checkNull(receita.getMedico());
		valida.checkNull(receita.getDoenca());
		valida.checkNull(receita.getPaciente());
		rn.validaMedicamentos(receita);
	}
	
	@Test
	public void testaMedicoNulo() throws ValidacaoException {
		valida.checkNull(medico);
	}

	@Test
	public void testaDoencaNulo() throws ValidacaoException {
		valida.checkNull(doenca);
	}
	
	@Test
	public void testaMedicamentoNulo() throws ValidacaoException {
		rn.validaMedicamentos(receita);
	}
	
	@Ignore
	public void verificaData(){
		
	}
}
