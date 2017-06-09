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
	
	public Receita pesquisarID(String id){
		return pesquisarReceitaId(id);
	}
	
	
//--------------Métodos auxiliares---------------\\
	

	private void inserirReceita(Receita receita){
		dao.getDAOReceita().inserir(receita);
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
	
	private void editarReceita(Receita receita){
		dao.getDAOReceita().editar(receita);
	}
	
	
	private List<Receita> listarReceitas(){
		return dao.getDAOReceita().listar();
	}
	
	private Receita pesquisarReceitaId(String id){
		Integer idReceita = validarInteiro(id);		
		return dao.getDAOReceita().pesquisarID(idReceita);
	}
	
	private Integer validarInteiro(String idReceita){
		try{
			Integer id = Integer.parseInt(idReceita);	
			return id;
		}catch(NumberFormatException nfe){
			throw new NumberFormatException("Digite apenas números.\n" +  nfe.getMessage());
		}
	}
	
	private void validarStatus(Receita receita) throws ValidacaoException{
		try{
		VALIDA.checkNull(receita);
		VALIDA.checkNull(receita.getUltimoStatus());
		}catch(ValidacaoException e){
			throw new ValidacaoException("Receita com Status inválido.\n");
		}
	}
			
}
