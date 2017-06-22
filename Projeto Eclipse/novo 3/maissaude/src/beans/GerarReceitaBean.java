package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import basicas.Doenca;
import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.Medicamento;
import basicas.Paciente;
import basicas.Receita;
import basicas.StatusReceita;
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
	private List<Doenca> listaDoencas;
	SimpleDateFormat simpleDateFormat;
//	private Paciente paciente;
//	private Doenca doenca;
	private String cpf;
	private String nomeDoenca;	

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    
    public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeDoenca() {
		return nomeDoenca;
	}
	public void setNomeDoenca(String nomeDoenca) {
		this.nomeDoenca = nomeDoenca;
	}
	
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
			if(listaMedicamentosReceita.contains(medicamentoAdd)){
				addMessage("Esse Medicamento já foi inserido na Receita.");
			}else{
				listaMedicamentosReceita.add(medicamentoAdd);
				addMessage("Medicamento: " + medicamentoAdd.getNome() + " adicionado na Receita.");
			}					    		    		    		    	
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    
    public void delMedicamento(ActionEvent actionEvent){
		try{			
			if(listaMedicamentosReceita.contains(medicamentoRemover)){
				listaMedicamentosReceita.remove(medicamentoRemover);
				addMessage("Medicamento: " + medicamentoRemover.getNome() + " removido da Receita.");
			}else{
				if(medicamentoRemover == null || medicamentoRemover.equals(null)){
					addMessage("Selecione um Medicamento da Receita para Remover.");
				}else{
					addMessage("O Medicamento: " + medicamentoRemover.getNome() + " já não consta na Receita.");
				}				
			}
											    		    		    		    
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }
    
    public void gerarReceita(ActionEvent actionEvent){
    	try{    		 
    		if(listaMedicamentosReceita == null || listaMedicamentosReceita.isEmpty()){
    			addMessage("Escolha ao menos 1 Medicamento antes de Gerar a Receita.");
    		}else{
    			
    		
    		Receita receita = new Receita();    	
    		System.out.println(getCpf() + " \n"  + getNomeDoenca());    		
    		receita.setDoenca(Fachada.getInstance().pesquisarDoencaPorNome(getNomeDoenca()));        		    		
    		receita.setListaMedicamentos(listaMedicamentosReceita);
    		receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111"));
    		receita.setPaciente(Fachada.getInstance().listarPacienteporCPF(getCpf()));   
    		
			Calendar dataGeracao = Calendar.getInstance();			
			Calendar dataPrazo =  Calendar.getInstance();
			dataPrazo.add(Calendar.MONTH, 1);						
    		receita.setDataGeracao(dataGeracao);
    		receita.setPrazo(dataPrazo);
    		
    		Fachada.getInstance().inserirReceita(receita);
    		
    		//Status Aberta
			StatusReceita status = new StatusReceita();
			
			Calendar alteracao = Calendar.getInstance();																						
			status.setDataAlteracao(alteracao);
			
			status.setUsuarioAlteracao(Fachada.getInstance().listarMedicoCRM("CRM/PE 11111").getUsuario());
			status.setStatus(EnumStatus.ABERTA.toString());		
			
			status.setReceita(receita);
			List<StatusReceita> listaStatus = new ArrayList<>();
			listaStatus.add(status);
			receita.setListaStatusReceita(listaStatus);
			receita.setUltimoStatus(status);
			
			Fachada.getInstance().inserirStatusReceita(status);	
			Fachada.getInstance().editarReceita(receita);    
			listaMedicamentosReceita.clear();
			cpf = "";
			nomeDoenca = "";
			medicamentoAdd = new Medicamento();
			addMessage("Receita Gerada com Sucesso!");		
			
    		}
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
    	Usuario usuario = new Usuario();
    	usuario = loginBean.getUsuarioLogado();  
    	return usuario;
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
    
    public void homeMedico(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
				null,
				"/medico/homeMedico.xhtml?faces-redirect=true");	
    }
    
    public void paginaGerarReceita(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
				null,
				"/medico/prescreverReceita.xhtml?faces-redirect=true");	
    }
}
