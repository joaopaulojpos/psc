package rn;

import java.util.List;


import basicas.Receita;
import dao.DAOFactory;
import util.Validacao;
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
	
	public void editar(Receita receita){
		editarReceita(receita);
	}
	
	public List<Receita> listar(){
		return listarReceitas();
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirReceita(Receita receita){
		dao.getDAOReceita().inserir(receita);
	}
	
	private void validar(Receita receita)throws ValidacaoException{
		VALIDA.checkNull(receita.getDoenca());
		VALIDA.checkNull(receita.getMedico());
		VALIDA.checkNull(receita.getPaciente());
	}
	
	private void editarReceita(Receita receita){
		dao.getDAOReceita().editar(receita);
	}
	
	
	private List<Receita> listarReceitas(){
		return dao.getDAOReceita().listar();
	}
}
