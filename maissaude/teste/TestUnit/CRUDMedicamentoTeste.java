package TestUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import basicas.Medicamento;
import rn.Fachada;
import rn.RNMedicamento;
import util.exceptions.ValidacaoException;

public class CRUDMedicamentoTeste {

RNMedicamento rnmedicamento = new RNMedicamento();

	@Test
	public void inserirTest() throws ValidacaoException{
		
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setNome("TiraDor");
		medicamento.setListaReceitas(null);
		
		rnmedicamento.inserir(medicamento);
		
	}
	
	
	@Test
	public void removerTest(){
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setIdMedicamento(6);
		medicamento.setNome("TiraDor");
		medicamento.setListaReceitas(null);
		Fachada.getInstance().removerMedicamento(medicamento);
	}

	@Test
	public void alterarTest() throws ValidacaoException{
		Medicamento medicamento = new Medicamento();
		medicamento.setControlado(true);
		medicamento.setIdMedicamento(1);
		medicamento.setNome("TiraDor");
		medicamento.setListaReceitas(null);
		List<Medicamento> medicamentos = Fachada.getInstance().listarMedicamentos();
		assertEquals(medicamento,medicamentos.get(0));
	}
	
	@Ignore
	@Test
	public void pesquisarCRM(){
		Medicamento m = new Medicamento();
		
//		m =rnmedicamento.listar();
	}

}
