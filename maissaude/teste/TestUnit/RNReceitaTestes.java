package TestUnit;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import basicas.Atendente;
import basicas.Doenca;
import basicas.Medico;
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
		
		receita.setListaMedicamentos(fachada.listarMedicamentos());
		receita.setDoenca(fachada.listarDoencaporCND("A01-B01"));
	}
//----------------------VALIDAÇÃO DA RECEITA-------------\\	
	@Test
	public void testaAtendenteNulo() throws ValidacaoException {
		valida.checkNull(atendente);
		valida.checkNull(medico);
		valida.checkNull(doenca);
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
