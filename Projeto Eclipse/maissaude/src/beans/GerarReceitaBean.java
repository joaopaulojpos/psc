package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sun.glass.ui.GestureSupport;

import basicas.Doenca;
import basicas.EnumPerfil;
import basicas.Medicamento;
import basicas.Paciente;
import basicas.Receita;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@ManagedBean
@SessionScoped
public class GerarReceitaBean {



	private List<Medicamento> listaMedicamentos;
	private List<Medicamento> listaMedicamentosReceita;
	private Medicamento medicamentoRemover;
	private Medicamento medicamentoAdd;	
	private List<Paciente> listaPacientes;
	private Paciente pacienteSelecionado;
	private Doenca doencaSelecionada;
	private List<Doenca> listaDoencas;
//	private DualListModel<Medicamento> dualList;
	
	SimpleDateFormat simpleDateFormat; 
	
//	public DualListModel<Medicamento> getDualList() {
//		return dualList;
//	}
//	
//	public void setDualList(DualListModel<Medicamento> dualList) {
//		this.dualList = dualList;
//	}
	
	public List<Medicamento> getListaMedicamentosReceita() {
		return listaMedicamentosReceita;
	}
	
	public void setListaMedicamentosReceita(List<Medicamento> listaMedicamentosReceita) {
		this.listaMedicamentosReceita = listaMedicamentosReceita;
	}
	
	public Medicamento getMedicamentoAdd() {
		return medicamentoAdd;
	}
	
	public void setMedicamentoAdd(Medicamento medicamentoAdd) {
		this.medicamentoAdd = medicamentoAdd;
	}
	
	public List<Doenca> getListaDoencas() {
		return listaDoencas;
	}
	public void setListaDoencas(List<Doenca> listaDoencas) {
		this.listaDoencas = listaDoencas;
	}
	
	
	public Doenca getDoencaSelecionada() {
		return doencaSelecionada;
	}
	 
	public void setDoencaSelecionada(Doenca doencaSelecionada) {
		this.doencaSelecionada = doencaSelecionada;
	}
	
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
	
	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamento) {
		this.listaMedicamentos = listaMedicamento;
	}
	
	public Medicamento getMedicamentoRemover() {
		return medicamentoRemover;
	}

	public void setMedicamentoRemover(Medicamento medicamentoRemover) {
		this.medicamentoRemover = medicamentoRemover;
	}

	   //Construtor
	   
    @PostConstruct
    public void init() {
    	try{
    		listaMedicamentos = alimentarTableMedicamentos();   
    		listaPacientes = alimentarTablePacientes();
    		listaDoencas = alimentarTableDoenca();
    		listaMedicamentosReceita = new ArrayList<Medicamento>();
    		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    
    //Métodos
            
    public void addMedicamento(ActionEvent actionEvent){
    	try{    		    		
    		listaMedicamentosReceita.add(medicamentoAdd);
    		addMessage("Medicamento: " + medicamentoAdd.getNome() + " adicionado na Receita.");
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    
    public void gerarReceita(ActionEvent actionEvent){
    	try{    		    		
    		Receita receita = new Receita();
    		receita.setDoenca(doencaSelecionada);    
    		
    		System.out.println("doença: " + receita.getDoenca().getNome());
    		receita.setListaMedicamentos(listaMedicamentosReceita);
    		receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111"));
    		receita.setPaciente(pacienteSelecionado);    		
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    

        
    
    //Métodos Auxiliares
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public Usuario pegarUsuarioLogado() throws ValidacaoException{
		Usuario atendente = new Usuario();
		atendente.setIdUsuario(3);
		atendente.setLogin("karine.bandao");
		atendente.setPerfil(EnumPerfil.MEDICO.toString());
		atendente.setSenha("123456");			
		/*
		//pegando Usuario setado na Session pelo LoginBean(no LoginBean tem  um metodo sessionMap.put q bota o usuario nessa lista Map)
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();						
		Usuario usuarioLogado = (Usuario) sessionMap.get("logado");
		*/		
		return atendente;
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
    
    public List<Doenca> alimentarTableDoenca(){
    	List<Doenca> lista = null;
    	try{    		
    		lista = Fachada.getInstance().listarDoenca();    
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
		return lista;
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
}
