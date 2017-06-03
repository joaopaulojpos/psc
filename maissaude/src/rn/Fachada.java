package rn;

import java.util.List;

import basicas.Atendente;
import basicas.Doenca;
import basicas.Medicamento;
import basicas.Medico;
import basicas.Paciente;
import basicas.Receita;
import util.exceptions.ValidacaoException;

public class Fachada {

	private static Fachada instance;
	private RNMedico rnMedico;
	private RNPaciente rnPaciente;
	private RNAtendente rnAtendente;
	private RNMedicamento rnMedicamento;
	private RNDoenca rnDoenca;
	private RNReceita rnReceita;
	
	private Fachada(){
		rnMedico = new RNMedico();
		rnPaciente = new RNPaciente();
		rnAtendente = new RNAtendente();
		rnMedicamento = new RNMedicamento();
		rnDoenca = new RNDoenca();
		rnReceita = new RNReceita();
	}
	
	/**
	 * Método singleton
	 * @return devolve um uma instancia de Fachada.
	 */
	public static Fachada getInstance(){
		if(instance==null) instance= new Fachada();
		return instance;
	}
	
	//-----Medico
	public void inserirMedico(Medico medico) throws ValidacaoException{
		rnMedico.inserir(medico);
	}
	
	public void editarMedico(Medico medico) throws ValidacaoException{
		rnMedico.editar(medico);
	}
	
	public List<Medico> listarMedicos(){
		return rnMedico.listar();
	}
	
	public Medico listarMedicoCRM(String crm){
		return rnMedico.listarMedicoCRM(crm);
	}
	
	public void removerMedico(Medico medico){
		rnMedico.remover(medico);
	}
	//-------Medico
	
	//-----Paciente
	public void inserirPaciente(Paciente paciente) throws ValidacaoException{
		rnPaciente.inserir(paciente);
	}
	
	public void editarPaciente(Paciente paciente){
		rnPaciente.editar(paciente);
	}
	
	public List<Paciente> listarPacientes(){
		return rnPaciente.listar();
	}
	
	public Paciente listarPacienteporCPF(String cpf){
		return rnPaciente.listarPacienteCPF(cpf);
	}
	
	public Paciente listarPacienteporCNS(String cns){
		return rnPaciente.listarPacienteCNS(cns);
	}
	
	public void removerPaciente(Paciente paciente){
		rnPaciente.remover(paciente);
	}
	//-------Paciente
	
	//-----Atendente
	public void inserirAtendente(Atendente atendente) throws ValidacaoException{
		rnAtendente.inserir(atendente);
	}
	
	public void editarAtendente(Atendente atendente){
		rnAtendente.editar(atendente);
	}
	
	public List<Atendente> listarAtendentes(){
		return rnAtendente.listar();
	}
	
	public Atendente listarAtendentesCRF(String crf){
		return rnAtendente.listarAtendenteCRF(crf);
	}
	
	public void removerAtendente(Atendente atendente){
		rnAtendente.remover(atendente);
	}
	//-------Atendente
	
	//-----Medicamento
	public void inserirMedicamento(Medicamento medicamento) throws ValidacaoException{
		rnMedicamento.inserir(medicamento);
	}
	
	public void editarMedicamento(Medicamento medicamento){
		rnMedicamento.editar(medicamento);
	}
	
	public List<Medicamento> listarMedicamentos(){
		return rnMedicamento.listar();
	}
	
	public void removerMedicamento(Medicamento medicamento){
		rnMedicamento.remover(medicamento);
	}
	//-------Medicamento

	//-----Doenca
	public void inserirDoenca(Doenca doenca) throws ValidacaoException{
		rnDoenca.inserir(doenca);
	}
	
	public void editarDoenca(Doenca doenca){
		rnDoenca.editar(doenca);
	}
	
	public List<Doenca> listarDoenca(){
		return rnDoenca.listar();
	}
	
	public Doenca listarDoencaporCND(String cnd){
		return rnDoenca.listarDoencaCND(cnd);
	}
	
	public void removerDoenca(Doenca doenca){
		rnDoenca.remover(doenca);
	}
	//-------Doenca
	
	//-----Receita
		public void inserirReceita(Receita receita) throws ValidacaoException{
			rnReceita.inserir(receita);
		}
		
		public void editarReceita(Receita receita){
			rnReceita.editar(receita);
		}
		
		public List<Receita> listarReceita(){
			return rnReceita.listar();
		}
		
		//-------Receita
}
