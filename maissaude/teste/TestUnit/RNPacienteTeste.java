package TestUnit;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import basicas.Paciente;
import rn.Fachada;
import rn.RNPaciente;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNPacienteTeste {

	RNPaciente rnpaciente = new RNPaciente();
	Validacao valid = new Validacao();
	Paciente paciente;
	
//--------VALIDAÇÕES DO CPF-----------\\
	/**
	 * Se cpf está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfNulo() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf(null);
		valid.cpf(paciente.getCpf());
	}
	
	/**
	 * Se cpf está vazio
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfVazio() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf("");
		valid.cpf(paciente.getCpf());
	}
	
	/**
	 * Se cpf está no formato inválido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfInválido() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf("12345678900");
		valid.cpf(paciente.getCpf());
	}
	
	/**
	 * Se cpf está com algum digito faltando
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfFaltandoDigitos() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf("123.456.789-0");
		valid.cpf(paciente.getCpf());
	}
	
	/**
	 * Se cpf está com um digito a mais.
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfComDigitosAMais() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf("123.456.728-002");
		valid.cpf(paciente.getCpf());
	}
	
	/**
	 * Se cpf está correto
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCpfCorreto() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCpf("123.456.728-00");
		valid.cpf(paciente.getCpf());
	}
	
//--------VALIDAÇÕES DO NOME--------------\\
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeNulo() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setNome(null);
		valid.nome(paciente.getNome());
	}
	
	@Test(expected=ValidacaoException.class)
	public void testeNomeVazio() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setNome("");
		valid.nome(paciente.getNome());
	}
	
	/**
	 * Se o campo nome aceita mais de 200 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeAcima200() throws ValidacaoException {
		paciente = new Paciente();
		//201 caracteres
		paciente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		valid.nome(paciente.getNome());
	}
	
	/**
	 * Se o campo nome aceita menos de 3 caracteres
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeMenor3() throws ValidacaoException {
		paciente = new Paciente();
		//201 caracteres
		paciente.setNome("aa");
		valid.nome(paciente.getNome());
	}
	
	/**
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeNomeValido() throws ValidacaoException {
		paciente = new Paciente();
		//201 caracteres
		paciente.setNome("Rhuan");
		valid.nome(paciente.getNome());
	}
	
	
//-------------VALIDAÇÃO DO CNS------------\\
	
	
	/** 
	 * Se o campo cns está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCNSNulo() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCns(null);
		rnpaciente.validaCNS(paciente.getCns());
	}
	
	/** 
	 * Se o campo cns está nulo
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCNSVazio() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCns("");
		rnpaciente.validaCNS(paciente.getCns());
	}
	
	/** 
	 * Se o campo cns está inválido
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCNSInvalido() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCns("111.2222.3333.444");
		rnpaciente.validaCNS(paciente.getCns());
	}
	
	/** 
	 * Campo preenchido corretamente
	 * Esperado: FALHA
	 * @throws ValidacaoException
	 */
	@Test(expected=ValidacaoException.class)
	public void testeCNSCorreto() throws ValidacaoException {
		paciente = new Paciente();
		paciente.setCns("111.2222.3333.4444");
		rnpaciente.validaCNS(paciente.getCns());
	}

	//-------------VALIDAÇÃO DO RG------------\\
	
	
		/** 
		 * Se o campo rg está nulo
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGNulo() throws ValidacaoException {
			paciente = new Paciente();
			paciente.setRg(null);
			valid.rg(paciente.getRg());
		}
		
		/** 
		 * Se o campo rg está vazio
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGVazio() throws ValidacaoException {
			paciente = new Paciente();
			paciente.setRg("");
			valid.rg(paciente.getRg());
		}
		
		/** 
		 * Se o campo rg está inválido
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGInvalido() throws ValidacaoException {
			paciente = new Paciente();
			paciente.setRg("2333444");
			valid.rg(paciente.getRg());
		}
		
		/** 
		 * Campo preenchido corretamente
		 * Esperado: FALHA
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeRGCorreto() throws ValidacaoException {
			paciente = new Paciente();
			paciente.setRg("2.333.444");
			valid.rg(paciente.getRg());
		}
		
//-----------------CRUD----------------\\		
		@Test
		public void inserirTest() throws ValidacaoException{
			
			Paciente paciente = new Paciente();
			paciente.setCpf("123.434.455-64");
			paciente.setCns("111.2222.5555.6666");
			paciente.setNome("Nixon Dantas");
			paciente.setRg("2.333.222");
			
			rnpaciente.inserir(paciente);
			
			assertEquals(paciente,Fachada.getInstance().listarPacienteporCNS(paciente.getCns()));
			
		}
		
		@Test
		public void removerTest(){
			Paciente paciente1 = new Paciente();
			paciente1 = Fachada.getInstance().listarPacienteporCNS("111.2222.5555.6666");
			Fachada.getInstance().removerPaciente(paciente1);
		}
}
