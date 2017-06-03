package TestUnit;

import static org.junit.Assert.*;

import org.junit.Test;


import basicas.Medico;
import rn.Fachada;
import rn.RNMedico;
import util.exceptions.ValidacaoException;

public class CRUDMedicoTeste {


	RNMedico rnmedico = new RNMedico();
	
	@Test
	public void inserirTest() throws ValidacaoException{
		
		Medico medico = new Medico();
		medico.setCpf("321.171.333-54");
		medico.setCrm("CRM/PE 11122");
		medico.setNome("Pablo Neruda");
		medico.setRg("1.222.333");
		medico.setLogin("Pablo");
		medico.setSenha("54321");
		
		rnmedico.inserir(medico);
		
		assertEquals(medico,Fachada.getInstance().listarMedicoCRM(medico.getCrm()));
	}
	
	@Test
	public void removerTest(){
		Medico medico1 = new Medico();
		medico1 = Fachada.getInstance().listarMedicoCRM("CRM/PE 11122");
		Fachada.getInstance().removerMedico(medico1);
	}

	@Test
	public void alterarTest() throws ValidacaoException{
		Medico medico1 = new Medico();
		medico1 = Fachada.getInstance().listarMedicoCRM("CRM/PE 11122");
		medico1.setNome("Charles");
		Fachada.getInstance().editarMedico(medico1);
		medico1 = new Medico();
		medico1 = Fachada.getInstance().listarMedicoCRM("CRM/PE 44455");
		assertEquals(medico1.getNome(),"Charles");
	}
	
	@Test
	public void pesquisarCRM(){
		Medico m = new Medico();
		
		m =rnmedico.listarMedicoCRM("CRM/PE 11122");
		assertEquals(m.getNome(),"Silvio Luis");
	}
}
