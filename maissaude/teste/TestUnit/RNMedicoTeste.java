package TestUnit;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import basicas.Medico;
import rn.Fachada;
import rn.RNMedico;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNMedicoTeste {

	RNMedico rnmedico = new RNMedico();
	Validacao valid = new Validacao();
	Medico medico;
	
//--------VALIDAÇÕES DO CPF-----------\\
	/**
	 * Se cpf está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfNulo() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf(null);
		valid.cpf(medico.getCpf());
	}
	
	/**
	 * Se cpf está vazio
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfVazio() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf("");
		valid.cpf(medico.getCpf());
	}
	
	/**
	 * Se cpf está no formato inválido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfInválido() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf("12345678900");
		valid.cpf(medico.getCpf());
	}
	
	/**
	 * Se cpf está com algum digito faltando
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfFaltandoDigitos() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf("123.456.789-0");
		valid.cpf(medico.getCpf());
	}
	
	/**
	 * Se cpf está com um digito a mais.
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfComDigitosAMais() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf("123.456.728-002");
		valid.cpf(medico.getCpf());
	}
	
	/**
	 * Se cpf está correto
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfCorreto() throws ValidacaoException {
		medico = new Medico();
		medico.setCpf("123.456.728-00");
		valid.cpf(medico.getCpf());
	}
	
//--------VALIDAÇÕES DO NOME--------------\\
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeNulo() throws ValidacaoException {
		medico = new Medico();
		medico.setNome(null);
		valid.nome(medico.getNome());
	}
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeVazio() throws ValidacaoException {
		medico = new Medico();
		medico.setNome("");
		valid.nome(medico.getNome());
	}
	
	/**
	 * Se o campo nome aceita mais de 200 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeAcima200() throws ValidacaoException {
		medico = new Medico();
		//201 caracteres
		medico.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		valid.nome(medico.getNome());
	}
	
	/**
	 * Se o campo nome aceita menos de 3 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeMenor3() throws ValidacaoException {
		medico = new Medico();
		//201 caracteres
		medico.setNome("aa");
		valid.nome(medico.getNome());
	}
	
	/**
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeValido() throws ValidacaoException {
		medico = new Medico();
		//201 caracteres
		medico.setNome("Rhuan");
		valid.nome(medico.getNome());
	}
	
	
//-------------VALIDAÇÃO DO CRM------------\\
	
	
	/** 
	 * Se o campo crm está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRMNulo() throws ValidacaoException {
		medico = new Medico();
		medico.setCrm(null);
		rnmedico.validaCRM(medico.getCrm());
	}
	
	/** 
	 * Se o campo crm está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRMVazio() throws ValidacaoException {
		medico = new Medico();
		medico.setCrm("");
		rnmedico.validaCRM(medico.getCrm());
	}
	
	/** 
	 * Se o campo crm está inválido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRMInvalido() throws ValidacaoException {
		medico = new Medico();
		medico.setCrm("CRM/PE 2d2222");
		rnmedico.validaCRM(medico.getCrm());
	}
	
	/** 
	 * Campo preenchido corretamente
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCRMCorreto() throws ValidacaoException {
		medico = new Medico();
		medico.setCrm("CRM/PE 22222");
		rnmedico.validaCRM(medico.getCrm());
	}

	//-------------VALIDAÇÃO DO RG------------\\
	
	
		/** 
		 * Se o campo rg está nulo
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGNulo() throws ValidacaoException {
			medico = new Medico();
			medico.setRg(null);
			valid.rg(medico.getRg());
		}
		
		/** 
		 * Se o campo rg está vazio
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGVazio() throws ValidacaoException {
			medico = new Medico();
			medico.setRg("");
			valid.rg(medico.getRg());
		}
		
		/** 
		 * Se o campo rg está inválido
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGInvalido() throws ValidacaoException {
			medico = new Medico();
			medico.setRg("2333444");
			valid.rg(medico.getRg());
		}
		
		/** 
		 * Campo preenchido corretamente
		 * Esperado: FALHA
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGCorreto() throws ValidacaoException {
			medico = new Medico();
			medico.setRg("2.333.444");
			valid.rg(medico.getRg());
		}
		
//-------------------CRUD---------------\\
		
		
		@Test
		public void inserirTest() throws ValidacaoException{
			
			Medico medico = new Medico();
			medico.setCpf("123.434.455-64");
			medico.setCrm("CRM/PE 22233");
			medico.setNome("Nixon Dantas");
			medico.setRg("2.333.222");
			medico.setLogin("rhuan");
			medico.setSenha("12345");
			
			rnmedico.inserir(medico);
			
			assertEquals(medico,Fachada.getInstance().listarMedicoCRM(medico.getCrm()));
			
		}
		
		@Test
		public void removerTest(){
			Medico medico1 = new Medico();
			medico1 = Fachada.getInstance().listarMedicoCRM("CRM/PE 22233");
			Fachada.getInstance().removerMedico(medico1);
		}
}
