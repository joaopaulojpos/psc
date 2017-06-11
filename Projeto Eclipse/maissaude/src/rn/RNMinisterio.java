package rn;

import java.util.List;

import basicas.Ministerio;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNMinisterio {
	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNMinisterio(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Ministerio ministerio) throws ValidacaoException{
		validar(ministerio);
		inserirMinisterio(ministerio);
	}
	
	public void editar(Ministerio ministerio) throws ValidacaoException{
		editarMinisterio(ministerio);
	}
	
	public List<Ministerio> listar(){
		return listarMinisterios();
	}	
	
	public void remover(Ministerio ministerio){
		removerMinisterio(ministerio);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirMinisterio(Ministerio ministerio){
		dao.getDAOMinisterio().inserir(ministerio);
	}
	
	private void validar(Ministerio ministerio)throws ValidacaoException{
		VALIDA.cpf(ministerio.getCpf());		
		VALIDA.nome(ministerio.getNome());		
		
	}
	
	private void editarMinisterio(Ministerio ministerio) throws ValidacaoException{
		VALIDA.checkId(ministerio.getIdPessoa());
		dao.getDAOMinisterio().editar(ministerio);
	}
	
	private void removerMinisterio(Ministerio ministerio){
		dao.getDAOMinisterio().remover(ministerio);
	}
	
	private List<Ministerio> listarMinisterios(){
		return dao.getDAOMinisterio().listar();
	}	
}
