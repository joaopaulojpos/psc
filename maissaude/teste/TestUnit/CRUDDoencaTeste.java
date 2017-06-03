package TestUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import basicas.Doenca;
import rn.Fachada;
import rn.RNDoenca;
import util.exceptions.ValidacaoException;

public class CRUDDoencaTeste {

	RNDoenca rndoenca = new RNDoenca();
	
	@Test
	public void inserirTest() throws ValidacaoException{
		
		Doenca doenca = new Doenca();
		doenca.setNome("Hemorroidas");
		doenca.setGravidade("Media");
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
		doenca1 = Fachada.getInstance().listarDoencaporCND("A-01");
		doenca1.setNome("Hemorroidas de Botao");
		Fachada.getInstance().editarDoenca(doenca1);
		doenca1 = new Doenca();
		doenca1 = Fachada.getInstance().listarDoencaporCND("B-02");
		assertEquals(doenca1.getNome(),"Hemorroidas de Botao");
	}
	
	@Test
	public void pesquisarCnd(){
		Doenca d = new Doenca();
		
		d =rndoenca.listarDoencaCND("A-02");
		assertEquals(d.getNome(),"Cachumba");


		
	}
