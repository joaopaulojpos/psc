package dao;


import basicas.Doenca;

/**
 * 
 * @author rndantas
 *
 */
public interface IDoenca {
	
	public Doenca pesquisarCND(String cnd);
	public Doenca pesquisarNome(String nome);
}
