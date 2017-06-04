package rn;

import java.util.List;


import basicas.Medicamento;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.PersistenciaException;
//import util.Validacao;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNMedicamento {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNMedicamento(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Medicamento medicamento) throws ValidacaoException{
		validar(medicamento);
		inserirMedicamento(medicamento);
	}
	
	public void editar(Medicamento medicamento) throws ValidacaoException{
		editarMedicamento(medicamento);
	}
	
	public List<Medicamento> listar(){
		return listarMedicamentos();
	}
	
	public Medicamento pesquisarMedicamentoId(Integer id) throws ValidacaoException{
		return pesquisarMedicamento(id);
	}
	
	public Medicamento pesquisarMedicamentoporNome(String nome){
		return pesquisarMedicamentoNome(nome);
	}
	
	public void remover(Medicamento medicamento){
		removerMedicamento(medicamento);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirMedicamento(Medicamento medicamento) throws ValidacaoException{
		try {
			dao.getDAOMedicamento().inserir(medicamento);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void validar(Medicamento medicamento)throws ValidacaoException{
		VALIDA.nome(medicamento.getNome());
	}
	
	private void editarMedicamento(Medicamento medicamento) throws ValidacaoException{
		try {
			dao.getDAOMedicamento().editar(medicamento);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void removerMedicamento(Medicamento medicamento){
		dao.getDAOMedicamento().remover(medicamento);
	}
	
	private List<Medicamento> listarMedicamentos(){
		return dao.getDAOMedicamento().listar();
	}
	
	private Medicamento pesquisarMedicamento(Integer id) throws ValidacaoException{
		try {
			return dao.getDAOMedicamento().pesquisarId(id);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private Medicamento pesquisarMedicamentoNome(String nome){
			return dao.getDAOMedicamento().pesquisarNome(nome);
	}
}
 