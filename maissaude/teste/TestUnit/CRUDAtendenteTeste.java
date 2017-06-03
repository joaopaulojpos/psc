package TestUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import basicas.Atendente;
import rn.Fachada;
import rn.RNAtendente;
import util.exceptions.ValidacaoException;

public class CRUDAtendenteTeste {


	RNAtendente rnatendente = new RNAtendente();
	
	@Test
	public void inserirTest() throws ValidacaoException{
		
		Atendente atendente = new Atendente();
		atendente.setCpf("123.434.455-64");
		atendente.setCrf("CRF/PE 22233");
		atendente.setNome("Nixon Dantas");
		atendente.setRg("2.333.222");
		atendente.setLogin("rhuan");
		atendente.setSenha("12345");
		
		rnatendente.inserir(atendente);
		
		assertEquals(atendente,Fachada.getInstance().listarAtendentesCRF(atendente.getCrf()));
	}
	
	@Test
	public void removerTest(){
		Atendente atendente1 = new Atendente();
		atendente1 = Fachada.getInstance().listarAtendentesCRF("CRF/PE 22233");
		Fachada.getInstance().removerAtendente(atendente1);
	}

	@Test
	public void alterarTest(){
		Atendente atendente1 = new Atendente();
		atendente1 = Fachada.getInstance().listarAtendentesCRF("CRF/PE 22244");
		atendente1.setNome("Pablo");
		Fachada.getInstance().editarAtendente(atendente1);
		atendente1 = new Atendente();
		atendente1 = Fachada.getInstance().listarAtendentesCRF("CRF/PE 22244");
		assertEquals(atendente1.getNome(),"Pablo");
	}
	
	@Test
	public void pesquisarCRF(){
		Atendente a = new Atendente();
		
		a =rnatendente.listarAtendenteCRF("CR/PE 22266");
		assertEquals(a.getNome(),"Rhuan Dantas");
	}
}
