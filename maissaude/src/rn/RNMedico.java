package rn;

import java.util.List;


import basicas.Medico;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNMedico {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNMedico(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Medico medico) throws ValidacaoException{
		validar(medico);
		inserirMedico(medico);
	}
	
	public void editar(Medico medico) throws ValidacaoException{
		editarMedico(medico);
	}
	
	public List<Medico> listar(){
		return listarMedicos();
	}
	
	public void remover(Medico medico){
		removerMedico(medico);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirMedico(Medico medico){
		dao.getDAOMedico().inserir(medico);
	}
	
	private void validar(Medico medico)throws ValidacaoException{
		VALIDA.cpf(medico.getCpf());
		VALIDA.crm(medico.getCrm().toString());
	}
	
	private void editarMedico(Medico medico) throws ValidacaoException{
		VALIDA.checkId(medico.getId());
		dao.getDAOMedico().editar(medico);
	}
	
	private void removerMedico(Medico medico){
		dao.getDAOMedico().remover(medico);
	}
	
	private List<Medico> listarMedicos(){
		return dao.getDAOMedico().listar();
	}
}
