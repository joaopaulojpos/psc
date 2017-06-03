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
	
	public Medico listarMedicoCRM(String crm){
		return listarCRM(crm);
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
		VALIDA.nome(medico.getNome());
		validaCRM(medico.getCrm());
		
	}
	
	public void validaCRM(String crm) throws ValidacaoException{
		//Ex.: CRM/PE 82333
		String regex = "^CRM/PE \\d{5}$";
		
		if(crm==null){
			throw new ValidacaoException("CRM inválido");
		}
		
		if(crm.isEmpty()){
			throw new ValidacaoException("CRM inválido");
		}
		if(crm.length()<=0){
			throw new ValidacaoException("CRM inválido");
		}
		if(!crm.matches(regex)){
			throw new ValidacaoException("CRM inválido");
		}
	}
	
	private void editarMedico(Medico medico) throws ValidacaoException{
		VALIDA.checkId(medico.getIdPessoa());
		dao.getDAOMedico().editar(medico);
	}
	
	private void removerMedico(Medico medico){
		dao.getDAOMedico().remover(medico);
	}
	
	private List<Medico> listarMedicos(){
		return dao.getDAOMedico().listar();
	}
	
	private Medico listarCRM(String crm){
		return dao.getDAOMedico().pesquisarCRM(crm);
	}
}
