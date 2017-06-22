package dao;


import basicas.Atendente;
import basicas.Usuario;

/**
 * 
 * @author rndantas
 *
 */
public interface IAtendente {
	
	public Atendente pesquisarCRF(String crf);
	public Atendente pesquisarCpf(String cpf);
	public Atendente pesquisarId(Integer id);
	public Atendente pesquisarUserId(Integer id);
}
