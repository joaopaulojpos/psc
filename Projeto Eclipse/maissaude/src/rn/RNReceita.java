package rn;

import java.util.List;

import basicas.Medicamento;
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
		receita.setControlada(isControlada(receita));
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
		validaControlada(receita);
	}
	
	private boolean isControlada(Receita receita){
		int countControlado = 0;
		int countNaoControlado = 0;
		boolean retorno = false;
		
		for(Medicamento med : receita.getListaMedicamentos()){
			if(med.isControlado()){
				countControlado++;
			}else{
				countNaoControlado++;
			}			
		}
		if(countControlado >= 1 && countNaoControlado == 0){
			retorno = true;
		}else
			if(countNaoControlado >= 1 && countControlado == 0){
				retorno = false;
			}
		return retorno;		
	}
	
	public void validaMedicamentos(Receita receita) throws ValidacaoException{
		if(receita.getListaMedicamentos()==null){
			throw new ValidacaoException("Receita sem medicamento");
		}
		if(receita.getListaMedicamentos().size()<=0){
			throw new ValidacaoException("Receita sem medicamento");
		}
	}
	
	public void validaControlada(Receita receita) throws ValidacaoException{
		int countControlado = 0;
		int countNaoControlado = 0;
		for(Medicamento med : receita.getListaMedicamentos()){
			if(med.isControlado()){
				countControlado++;
			}else{
				countNaoControlado++;
			}			
		}
		if(countControlado >= 1 && countNaoControlado >= 1){
			throw new ValidacaoException("Essa Receita possui Medicamentos Controlados e Não Controlados, uma Receita deve ter apenas Medicamentos Controlados ou Não Controlados.");
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
