package rn;

import java.util.List;


import basicas.Doenca;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.PersistenciaException;
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
	
	public void editar(Doenca doenca) throws ValidacaoException{
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
	
	private void inserirDoenca(Doenca doenca) throws ValidacaoException{
		try {
			dao.getDAODoenca().inserir(doenca);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void validar(Doenca doenca)throws ValidacaoException{
		VALIDA.nome(doenca.getNome());
//		validaCnd(doenca.getCnd());
	}
	
	public void validaCnd(String cnd) throws ValidacaoException{
		//Ex.: A00-B99
		String regex = "^{3}[a-zA-Z0-9]-{3}[a-zA-Z0-9]$";
		
		if(cnd==null){
			throw new ValidacaoException("CND inválido");
		}
		
		if(cnd.isEmpty()){
			throw new ValidacaoException("CND inválido");
		}
		
//		if(!cnd.matches(regex)){
//			throw new ValidacaoException("CND inválido");
//		}
	}
	
	private void editarDoenca(Doenca doenca) throws ValidacaoException{
		try {
			dao.getDAODoenca().editar(doenca);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
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
