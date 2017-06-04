package TestUnit;


import static org.junit.Assert.*;

import org.junit.Test;

import basicas.Medicamento;
import rn.RNMedicamento;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNMedicamentoTeste {

	RNMedicamento rnmedicamento = new RNMedicamento();
	Validacao valid = new Validacao();
	Medicamento medicamento;


	//--------VALIDAÇÕES DO NOME--------------\\
		
		@Test(expected=ValidacaoException.class)
		public void testeNomeNulo() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setNome(null);
			valid.nome(medicamento.getNome());
		}
		
		@Test(expected=ValidacaoException.class)
		public void testeNomeVazio() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setNome("");
			valid.nome(medicamento.getNome());
		}
		
		/**
		 * Se o campo nome aceita mais de 200 caracteres
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeNomeAcima200() throws ValidacaoException {
			medicamento = new Medicamento();
			//201 caracteres
			medicamento.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			valid.nome(medicamento.getNome());
		}
		
		/**
		 * Se o campo nome aceita menos de 3 caracteres
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeNomeMenor3() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setNome("aa");
			valid.nome(medicamento.getNome());
		}
		
		/**
		 * Esperado: FALHA
		 * @throws ValidacaoException
		 */
		@Test
		public void testeNomeValido() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setNome("Benegripe");
			valid.nome(medicamento.getNome());
		}

//------------VALIDAÇÃO DE CONTROLADO---------------\\
		
		@Test
		public void testeControladoFalso() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setControlado(false);
			assertEquals(false, medicamento.isControlado());
		}
		
		@Test
		public void testeControladoTrue() throws ValidacaoException {
			medicamento = new Medicamento();
			medicamento.setControlado(true);
			assertEquals(true, medicamento.isControlado());
		}
		
//----------------------CRUD---------------\\
		
		
}
