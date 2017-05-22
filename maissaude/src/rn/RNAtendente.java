package rn;

import java.util.List;


import basicas.Atendente;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNAtendente {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNAtendente(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Atendente atendente) throws ValidacaoException{
		validar(atendente);
		inserirAtendente(atendente);
	}
	
	public void editar(Atendente atendente){
		editarAtendente(atendente);
	}
	
	public List<Atendente> listar(){
		return listarAtendentes();
	}
	
	public void remover(Atendente atendente){
		removerAtendente(atendente);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirAtendente(Atendente atendente){
		dao.getDAOAtendente().inserir(atendente);
	}
	
	private void validar(Atendente atendente)throws ValidacaoException{
		VALIDA.cpf(atendente.getCpf().toString());
	}
	
	private void editarAtendente(Atendente atendente){
		dao.getDAOAtendente().editar(atendente);
	}
	
	private void removerAtendente(Atendente atendente){
		dao.getDAOAtendente().remover(atendente);
	}
	
	private List<Atendente> listarAtendentes(){
		return dao.getDAOAtendente().listar();
	}
}
