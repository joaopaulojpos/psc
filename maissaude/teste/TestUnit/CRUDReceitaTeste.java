package TestUnit;


import java.util.Calendar;

import org.junit.Test;


import basicas.Receita;
import rn.Fachada;
import rn.RNReceita;
import util.exceptions.ValidacaoException;

public class CRUDReceitaTeste {


	RNReceita rnreceita = new RNReceita();
	
	@Test
	public void inserirTest() {
		
		Receita receita = new Receita();
		receita.setAtendente(Fachada.getInstance().listarAtendentesCRF("CR/PE 22266"));
		receita.setDataGeracao(Calendar.getInstance());
		receita.setDoenca(Fachada.getInstance().listarDoencaporCND("A03-B03"));
		receita.setListaMedicamentos(Fachada.getInstance().listarMedicamentos());
		receita.setListaStatusReceita(null);
		receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 22244"));
		receita.setPaciente(Fachada.getInstance().listarPacienteporCNS("222.3333.4444.5555"));
		receita.setPrazo(Calendar.getInstance());
		
		
		try {
			rnreceita.inserir(receita);
		} catch (ValidacaoException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void removerTest(){
		Receita receita1 = new Receita();
		try {
			receita1 = Fachada.getInstance().pesquisarReceitaId(2);

//			DAOFactory.getDAOReceita().remover(receita1);
		} catch (ValidacaoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarTest() throws ValidacaoException{
		Receita receita1 = new Receita();
		receita1 = Fachada.getInstance().pesquisarReceitaId(2);
		receita1.setDataGeracao(Calendar.getInstance());
		Fachada.getInstance().editarReceita(receita1);
	}
	@Test
	public void pesquisarCRM(){
		Receita m = new Receita();
		Fachada.getInstance().listarReceita();
	}
	
}
