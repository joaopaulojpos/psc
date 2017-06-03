package TestUnit;



import org.junit.Test;

import basicas.Atendente;
import rn.RNAtendente;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNAtendenteTeste {

	RNAtendente rnatendente = new RNAtendente();
	Validacao valid = new Validacao();
	Atendente atendente;
	
//--------VALIDA��ES DO CPF-----------\\
	/**
	 * Se cpf est� nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfNulo() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf(null);
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf est� vazio
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfVazio() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf est� no formato inv�lido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfInv�lido() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("12345678900");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf est� com algum digito faltando
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfFaltandoDigitos() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.789-0");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf est� com um digito a mais.
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfComDigitosAMais() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.728-002");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf est� correto
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfCorreto() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.728-00");
		valid.cpf(atendente.getCpf());
	}
	
//--------VALIDA��ES DO NOME--------------\\
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeNulo() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setNome(null);
		valid.nome(atendente.getNome());
	}
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeVazio() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setNome("");
		valid.nome(atendente.getNome());
	}
	
	/**
	 * Se o campo nome aceita mais de 200 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeAcima200() throws ValidacaoException {
		atendente = new Atendente();
		//201 caracteres
		atendente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		valid.nome(atendente.getNome());
	}
	
	/**
	 * Se o campo nome aceita menos de 3 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeMenor3() throws ValidacaoException {
		atendente = new Atendente();
		//201 caracteres
		atendente.setNome("aa");
		valid.nome(atendente.getNome());
	}
	
	/**
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeValido() throws ValidacaoException {
		atendente = new Atendente();
		//201 caracteres
		atendente.setNome("Rhuan");
		valid.nome(atendente.getNome());
	}
	
	
//-------------VALIDA��O DO CRF------------\\
	
	
	/** 
	 * Se o campo crm est� nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFNulo() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf(null);
		rnatendente.validaCRF(atendente.getCrf());
	}
	
	/** 
	 * Se o campo crm est� nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFVazio() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf("");
		rnatendente.validaCRF(atendente.getCrf());
	}
	
	/** 
	 * Se o campo crm est� inv�lido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFInvalido() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf("CRF/PE 2d2222");
		rnatendente.validaCRF(atendente.getCrf());
	}
	
	/** 
	 * Campo preenchido corretamente
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFCorreto() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf("CRF/PE 22222");
		rnatendente.validaCRF(atendente.getCrf());
	}

	//-------------VALIDA��O DO RG------------\\
	
	
		/** 
		 * Se o campo rg est� nulo
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGNulo() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg(null);
			valid.rg(atendente.getRg());
		}
		
		/** 
		 * Se o campo rg est� vazio
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGVazio() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg("");
			valid.rg(atendente.getRg());
		}
		
		/** 
		 * Se o campo rg est� inv�lido
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGInvalido() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg("2333444");
			valid.rg(atendente.getRg());
		}
		
		/** 
		 * Campo preenchido corretamente
		 * Esperado: FALHA
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGCorreto() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg("2.333.444");
			valid.rg(atendente.getRg());
		}
		
}
