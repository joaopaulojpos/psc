package rn;

import java.util.List;


import basicas.Atendente;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.PersistenciaException;
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
	
	
	
	public void editar(Atendente atendente) throws ValidacaoException{
		editarAtendente(atendente);
	}
	
	public List<Atendente> listar(){
		return listarAtendentes();
	}
	
	public Atendente listarAtendenteCRF(String crf){
		return listarCRF(crf);
	}
	
	public Atendente pesquisarAtendenteID(Integer id) throws ValidacaoException{
		return pesquisarAtendente(id);
	}
	
	public void remover(Atendente atendente){
		removerAtendente(atendente);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirAtendente(Atendente atendente) throws ValidacaoException{
		try {
			dao.getDAOAtendente().inserir(atendente);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void validar(Atendente atendente)throws ValidacaoException{
		VALIDA.cpf(atendente.getCpf().toString());
		VALIDA.nome(atendente.getNome());
		if(atendente.isFarmaceutico()==true)
			validaCRF(atendente.getCrf());
	}
	
	public void validaCRF(String crf) throws ValidacaoException{
		//Ex.: CRF/PE 82333
		String regex = "^CRF/PE \\d{5}$";
		
		if(crf==null){
			throw new ValidacaoException("CRF inválido");
		}
		
		if(crf.isEmpty()){
			throw new ValidacaoException("CRF inválido");
		}
		if(crf.length()<=0){
			throw new ValidacaoException("CRF inválido");
		}
		if(!crf.matches(regex)){
			throw new ValidacaoException("CRF inválido");
		}
	}
	
	private void editarAtendente(Atendente atendente) throws ValidacaoException{
		try {
			dao.getDAOAtendente().editar(atendente);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void removerAtendente(Atendente atendente){
		dao.getDAOAtendente().remover(atendente);
	}
	
	private List<Atendente> listarAtendentes(){
		return dao.getDAOAtendente().listar();
	}
	
	private Atendente pesquisarAtendente(Integer id) throws ValidacaoException{
		try {
			return dao.getDAOAtendente().pesquisarId(id);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private Atendente listarCRF(String crf){
		return dao.getDAOAtendente().pesquisarCRF(crf);
	}
}
