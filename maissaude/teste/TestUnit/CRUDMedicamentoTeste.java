package TestUnit;

import static org.junit.Assert.*;

import java.util.List;

//import org.junit.Ignore;
import org.junit.Test;

import basicas.Medicamento;
import rn.Fachada;
import rn.RNMedicamento;
import util.exceptions.ValidacaoException;

public class CRUDMedicamentoTeste {

RNMedicamento rnmedicamento = new RNMedicamento();

	@Test(expected=ValidacaoException.class)
	public void inserirTest() throws ValidacaoException{
		
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setNome("fafasdadsada");
		medicamento.setListaReceitas(null);
		
//		rnmedicamento.inserir(medicamento);
		
	}
	
	@Test(expected=ValidacaoException.class)
	public void removerTest(){
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setIdMedicamento(6);
		medicamento.setNome("dasds");
		medicamento.setListaReceitas(null);
//		Fachada.getInstance().removerMedicamento(medicamento);
	}

	@Test(expected=ValidacaoException.class)
	public void alterarTest() throws ValidacaoException{
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setIdMedicamento(1);
		medicamento.setNome("dsadadaad");
		medicamento.setListaReceitas(null);
		List<Medicamento> medicamentos = Fachada.getInstance().listarMedicamentos();
		assertEquals(medicamento,medicamentos.get(0));
	}
	
	@Test
	public void pesquisarCRM(){
		Medicamento m = new Medicamento();
		
//		m =rnmedicamento.listar();
	}

}
