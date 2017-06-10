package TestUnit;


import org.junit.Ignore;
import org.junit.Test;

import basicas.Doenca;
import rn.RNDoenca;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNDoencaTeste {

	RNDoenca rndoenca = new RNDoenca();
	Validacao valid = new Validacao();
	Doenca doenca;

	//--------VALIDAÇÕES DO NOME--------------\\
		
		@Test(expected=ValidacaoException.class)
		public void testeNomeNulo() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setNome(null);
			valid.nome(doenca.getNome());
		}
		
		@Test(expected=ValidacaoException.class)
		public void testeNomeVazio() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setNome("");
			valid.nome(doenca.getNome());
		}
		
		/**
		 * Se o campo nome aceita mais de 200 caracteres
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeNomeAcima200() throws ValidacaoException {
			doenca = new Doenca();
			//201 caracteres
			doenca.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			valid.nome(doenca.getNome());
		}
		
		/**
		 * Se o campo nome aceita menos de 3 caracteres
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeNomeMenor3() throws ValidacaoException {
			doenca = new Doenca();
			//201 caracteres
			doenca.setNome("aa");
			valid.nome(doenca.getNome());
		}
		
		/**
		 * Esperado: FALHA
		 * @throws ValidacaoException
		 */
		@Test(expected=ValidacaoException.class)
		public void testeNomeValido() throws ValidacaoException {
			doenca = new Doenca();
			//201 caracteres
			doenca.setNome("Febre");
			valid.nome(doenca.getNome());
		}
		
//----------------VALIDAÇÃO DO CND-------------\\
		
		@Test(expected=ValidacaoException.class)
		public void testeCNDNulo() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setCnd(null);
			rndoenca.validaCnd(doenca.getCnd());
		}
		
		@Test(expected=ValidacaoException.class)
		public void testeCNDVazio() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setCnd("");
			rndoenca.validaCnd(doenca.getCnd());
		}
		
		
		@Test(expected=ValidacaoException.class)
		public void testeCNDInvalido() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setCnd("ABBD-DDD");
			rndoenca.validaCnd(doenca.getCnd());
		}
		
		@Ignore
		@Test(expected=ValidacaoException.class)
		public void testeCNDCorreto() throws ValidacaoException {
			doenca = new Doenca();
			doenca.setCnd("A00-DDD");
			rndoenca.validaCnd(doenca.getCnd());
		}
}
