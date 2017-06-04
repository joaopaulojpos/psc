package TestUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import basicas.Doenca;
import basicas.EnumGravidade;
import rn.Fachada;
import rn.RNDoenca;
import util.exceptions.ValidacaoException;

public class CRUDDoencaTeste {

	RNDoenca rndoenca = new RNDoenca();
	
	@Test
	public void inserirTest() throws ValidacaoException{
		
		Doenca doenca = new Doenca();
		doenca.setNome("Hemorroidas");
		doenca.setGravidade(EnumGravidade.ALTA.toString());
		doenca.setCnd("A-01");
		doenca.setListaReceitas(null);
		
		rndoenca.inserir(doenca);
		
		assertEquals(doenca,Fachada.getInstance().listarDoencaporCND(doenca.getCnd()));
	}
	
	@Test
	public void removerTest(){
		Doenca doenca1 = new Doenca();
		doenca1 = Fachada.getInstance().listarDoencaporCND("A-01");
		
		Fachada.getInstance().removerDoenca(doenca1);
	}

	@Test
	public void alterarTest(){
		Doenca doenca1 = new Doenca();
		doenca1 = Fachada.getInstance().listarDoencaporCND("A01-B01");
		doenca1.setNome("Dengue Hemorragica");
		try {
			Fachada.getInstance().editarDoenca(doenca1);
		} catch (ValidacaoException e) {
			e.printStackTrace();
		}
		doenca1 = new Doenca();
		doenca1 = Fachada.getInstance().listarDoencaporCND("A01-B01");
		assertEquals(doenca1.getNome(),"Dengue Hemorragica");
	}
	
	@Test
	public void pesquisarCnd(){
		Doenca d = new Doenca();
		
<<<<<<< HEAD
		d =rndoenca.listarDoencaCND("A02-B02");
		assertEquals(d.getNome(),"AVC");
=======
		d =rndoenca.listarDoencaCND("A-02");
		assertEquals(d.getNome(),"Cachumba");


	}
>>>>>>> 7d65577f95410ab0f0c520f623e53240860ae2e1
	}
}
