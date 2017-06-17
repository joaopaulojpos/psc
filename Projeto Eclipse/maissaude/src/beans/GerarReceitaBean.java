package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import basicas.Medicamento;
import basicas.Paciente;
import rn.Fachada;

@ManagedBean
@ViewScoped
public class GerarReceitaBean {



	private List<Medicamento> listaMedicamentos;
	private Medicamento medicamentoSelecionado;
	private List<Paciente> listaPacientes;
	private Paciente pacienteSelecionado;
	
	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}
	
	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamentos;
	}

	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamentos = listaMedicamento;
	}
	
	public Medicamento getMedicamentoSelecionado() {
		return medicamentoSelecionado;
	}

	public void setMedicamentoSelecionado(Medicamento medicamentoSelecionado) {
		this.medicamentoSelecionado = medicamentoSelecionado;
	}

	   //Construtor
	   
    @PostConstruct
    public void init() {
    	try{
    		listaMedicamentos = alimentarTableMedicamentos();   
    		listaPacientes = alimentarTablePacientes();
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    
    public List<Paciente> alimentarTablePacientes(){
    	List<Paciente> lista = null;
    	try{    		
    		lista = Fachada.getInstance().listarPacientes();    
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
		return lista;
    }
    
    public List<Medicamento> alimentarTableMedicamentos(){
    	List<Medicamento> lista = null;
    	try{    		
    		lista = Fachada.getInstance().listarMedicamentos();    
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
		return lista;
    }
    
    //Métodos Auxiliares
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }	
}
