package rn;

import java.util.List;

import basicas.Receita;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.PersistenciaException;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNReceita {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNReceita(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Receita receita) throws ValidacaoException{
		validar(receita);
		inserirReceita(receita);
	}
	
	public void editar(Receita receita) throws ValidacaoException{
		editarReceita(receita);
	}
	
	public Receita pesquisarReceitaID(Integer id) throws ValidacaoException{
		return pesquisarReceita(id);
	}
	
	public List<Receita> listar(){
		return listarReceitas();
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirReceita(Receita receita) throws ValidacaoException{
		try {
			dao.getDAOReceita().inserir(receita);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void validar(Receita receita)throws ValidacaoException{
		VALIDA.checkNull(receita.getDoenca());
		VALIDA.checkNull(receita.getMedico());
		VALIDA.checkNull(receita.getPaciente());
		validaMedicamentos(receita);
	}
	
	public void validaMedicamentos(Receita receita) throws ValidacaoException{
		if(receita.getListaMedicamentos()==null){
			throw new ValidacaoException("Receita sem medicamento");
		}
		if(receita.getListaMedicamentos().size()<=0){
			throw new ValidacaoException("Receita sem medicamento");
		}
	}
	
	private void editarReceita(Receita receita) throws ValidacaoException{
		try {
			dao.getDAOReceita().editar(receita);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}

	private Receita pesquisarReceita(Integer id) throws ValidacaoException{
		try {
			return dao.getDAOReceita().pesquisarId(id);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private List<Receita> listarReceitas(){
		return dao.getDAOReceita().listar();
	}
}
