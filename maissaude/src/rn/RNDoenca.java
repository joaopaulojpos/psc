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
	
//--------------M�todos auxiliares---------------\\
	
	private void inserirDoenca(Doenca doenca){
		dao.getDAODoenca().inserir(doenca);
	}
	
	private void validar(Doenca doenca)throws ValidacaoException{
		VALIDA.nome(doenca.getNome());
//		validaCnd(doenca.getCnd());
	}
	
	public void validaCnd(String cnd) throws ValidacaoException{
		//Ex.: A00-B99
		String regex = "^{3}[a-zA-Z0-9]-{3}[a-zA-Z0-9]$";
		
		if(cnd==null){
			throw new ValidacaoException("CND inv�lido");
		}
		
		if(cnd.isEmpty()){
			throw new ValidacaoException("CND inv�lido");
		}
		if(cnd.length()<=0){
			throw new ValidacaoException("CND inv�lido");
		}
		if(!cnd.matches(regex)){
			throw new ValidacaoException("CND inv�lido");
		}
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
