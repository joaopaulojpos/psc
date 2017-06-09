package dao;


import basicas.Atendente;

/**
 * 
 * @author rndantas
 *
 */
public interface IAtendente {
	
	public Atendente pesquisarCRF(String crf);
	public Atendente pesquisarCpf(String cpf);
}
