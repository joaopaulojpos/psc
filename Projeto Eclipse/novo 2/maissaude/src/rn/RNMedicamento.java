package rn;

import java.util.List;


import basicas.Medicamento;
import dao.DAOFactory;
//import util.Validacao;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNMedicamento {

	private DAOFactory dao;
//	private final Validacao VALIDA;
	
	public RNMedicamento(){
//		VALIDA = new Validacao();
	}
	
	public void inserir(Medicamento medicamento) throws ValidacaoException{
		validar(medicamento);
		inserirMedicamento(medicamento);
	}
	
	public void editar(Medicamento medicamento){
		editarMedicamento(medicamento);
	}
	
	public List<Medicamento> listar(){
		return listarMedicamentos();
	}
	
	public Medicamento pesquisarNome(String nome){
		return pesquisarMedicamento(nome);
	}
	
	public void remover(Medicamento medicamento){
		removerMedicamento(medicamento);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirMedicamento(Medicamento medicamento){
		dao.getDAOMedicamento().inserir(medicamento);
	}
	
	private void validar(Medicamento medicamento)throws ValidacaoException{
	}
	
	private void editarMedicamento(Medicamento medicamento){
		dao.getDAOMedicamento().editar(medicamento);
	}
	
	private void removerMedicamento(Medicamento medicamento){
		dao.getDAOMedicamento().remover(medicamento);
	}
	
	private List<Medicamento> listarMedicamentos(){
		return dao.getDAOMedicamento().listar();
	}
	
	private Medicamento pesquisarMedicamento(String nome){
		return dao.getDAOMedicamento().pesquisarNome(nome);
	}
}
