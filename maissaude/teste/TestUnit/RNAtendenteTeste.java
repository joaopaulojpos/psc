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
	
//--------VALIDAÇÕES DO CPF-----------\\
	/**
	 * Se cpf está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfNulo() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf(null);
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf está vazio
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfVazio() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf está no formato inválido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfInválido() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("12345678900");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf está com algum digito faltando
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfFaltandoDigitos() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.789-0");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf está com um digito a mais.
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfComDigitosAMais() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.728-002");
		valid.cpf(atendente.getCpf());
	}
	
	/**
	 * Se cpf está correto
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfCorreto() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCpf("123.456.728-00");
		valid.cpf(atendente.getCpf());
	}
	
//--------VALIDAÇÕES DO NOME--------------\\
	
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
	
	
//-------------VALIDAÇÃO DO CRF------------\\
	
	
	/** 
	 * Se o campo crm está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFNulo() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf(null);
		rnatendente.validaCRF(atendente.getCrf());
	}
	
	/** 
	 * Se o campo crm está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRFVazio() throws ValidacaoException {
		atendente = new Atendente();
		atendente.setCrf("");
		rnatendente.validaCRF(atendente.getCrf());
	}
	
	/** 
	 * Se o campo crm está inválido
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

	//-------------VALIDAÇÃO DO RG------------\\
	
	
		/** 
		 * Se o campo rg está nulo
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGNulo() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg(null);
			valid.rg(atendente.getRg());
		}
		
		/** 
		 * Se o campo rg está vazio
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGVazio() throws ValidacaoException {
			atendente = new Atendente();
			atendente.setRg("");
			valid.rg(atendente.getRg());
		}
		
		/** 
		 * Se o campo rg está inválido
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
