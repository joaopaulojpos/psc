package rn;

import java.util.List;


import basicas.Paciente;
import dao.DAOFactory;
import util.Validacao;
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
	
	public void editar(Paciente paciente){
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
	
	private void inserirPaciente(Paciente paciente){
		dao.getDAOPaciente().inserir(paciente);
	}
	
	private void validar(Paciente paciente)throws ValidacaoException{
		VALIDA.cpf(paciente.getCpf().toString());
	}
	
	private void editarPaciente(Paciente paciente){
		dao.getDAOPaciente().editar(paciente);
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
