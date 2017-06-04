package rn;

import java.util.List;


import basicas.Paciente;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.PersistenciaException;
import util.exceptions.ValidacaoException;

/**
 * 
 * @author Rhuan
 *
 */
public class RNPaciente {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNPaciente(){
		VALIDA = new Validacao();
	}
	
	public void inserir(Paciente paciente) throws ValidacaoException{
		validar(paciente);
		inserirPaciente(paciente);
	}
	
	public void editar(Paciente paciente) throws ValidacaoException{
		editarPaciente(paciente);
	}
	
	public List<Paciente> listar(){
		return listarPacientes();
	}
	
	public Paciente listarPacienteCPF(String cpf){
		return listarCPF(cpf);
	}
	
	public Paciente listarPacienteCNS(String cns){
		return listarCNS(cns);
	}
	
	public void remover(Paciente paciente){
		removerPaciente(paciente);
	}
	
//--------------Métodos auxiliares---------------\\
	
	private void inserirPaciente(Paciente paciente) throws ValidacaoException{
		try {
			dao.getDAOPaciente().inserir(paciente);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void validar(Paciente paciente)throws ValidacaoException{
		VALIDA.cpf(paciente.getCpf().toString());
		validaCNS(paciente.getCns());
	}
	
	public void validaCNS(String cns) throws ValidacaoException{
		//Ex.: 111.2222.3333.4444

		String regex = "^\\d{3}.\\d{4}.\\d{4}.\\d{4}$";
		
		if(cns==null){
			throw new ValidacaoException("CNS inválido");
		}
		
		if(cns.isEmpty()){
			throw new ValidacaoException("CNS inválido");
		}
		if(cns.length()<=0){
			throw new ValidacaoException("CNS inválido");
		}
		if(!cns.matches(regex)){
			throw new ValidacaoException("CNS inválido");
		}
	}
	
	private void editarPaciente(Paciente paciente) throws ValidacaoException{
		try {
			dao.getDAOPaciente().editar(paciente);
		} catch (PersistenciaException e) {
			throw new ValidacaoException("Erro na conexão com o Banco de dados.");
		}
	}
	
	private void removerPaciente(Paciente paciente){
		dao.getDAOPaciente().remover(paciente);
	}
	
	private List<Paciente> listarPacientes(){
		return dao.getDAOPaciente().listar();
	}
	
	private Paciente listarCNS(String cns){
		return dao.getDAOPaciente().pesquisarCNS(cns);
	}
	
	private Paciente listarCPF(String cpf){
		return dao.getDAOPaciente().pesquisarCPF(cpf);
	}
}
