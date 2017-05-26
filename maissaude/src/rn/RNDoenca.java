package rn;

import java.util.List;


import basicas.Doenca;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNDoenca {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNDoenca(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Doenca doenca) throws ValidacaoException{
		validar(doenca);
		inserirDoenca(doenca);
	}
	
	public void editar(Doenca doenca){
		editarDoenca(doenca);
	}
	
	public List<Doenca> listar(){
		return listarDoencas();
	}
	
	public Doenca listarDoencaCND(String cnd){
		return listarCND(cnd);
	}
	
	public void remover(Doenca doenca){
		removerDoenca(doenca);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirDoenca(Doenca doenca){
		dao.getDAODoenca().inserir(doenca);
	}
	
	private void validar(Doenca doenca)throws ValidacaoException{
	}
	
	private void editarDoenca(Doenca doenca){
		dao.getDAODoenca().editar(doenca);
	}
	
	private void removerDoenca(Doenca doenca){
		dao.getDAODoenca().remover(doenca);
	}
	
	private List<Doenca> listarDoencas(){
		return dao.getDAODoenca().listar();
	}
	
	private Doenca listarCND(String cnd){
		return dao.getDAODoenca().pesquisarCND(cnd);
	}
}
