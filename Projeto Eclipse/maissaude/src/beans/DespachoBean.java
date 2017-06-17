package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.Receita;
import basicas.StatusReceita;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@ManagedBean
@ViewScoped
public class DespachoBean {
   private List<Receita> receitas;
   private Receita receitaSelecionada;
   	   	  	   
   public List<Receita> getReceitas() {
        return receitas;
    }
	   
   //Construtor
   
    @PostConstruct
    public void init() {
    	try{
    		receitas = alimentarTableReceitas();	    		
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }        	    	    	    
	    	    
    private List<Receita> alimentarTableReceitas(){
    	List<Receita> receitasAbertas = null;
    	List<Receita> receitas;
    	try{
    		receitas = new ArrayList<>();	 
    		receitasAbertas = new ArrayList<>();
	    	receitas = Fachada.getInstance().listarReceita();
	    	for(Receita receita : receitas){
	    		List<StatusReceita> listaStatus = new ArrayList<>();
	    		listaStatus = receita.getListaStatusReceita();
	    		for(StatusReceita status : listaStatus){
	    			receita.setUltimoStatus(status);		    			
	    		}		    		
	    	}		    	
	    	for(Receita receita : receitas){
	    		if(receita.getUltimoStatus().getStatus().equals(EnumStatus.ABERTA.toString())){
	    			receitasAbertas.add(receita);
	    		}
	    	}	    		
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}	
    	return receitasAbertas;
    }
    
	public void despacharReceita(ActionEvent actionEvent){						
		try {
			Usuario usuario = pegarUsuarioLogado();								
			Fachada.getInstance().inserirStatusReceita(despachar(usuario));
			addMessage("Receita n� " + receitaSelecionada.getIdReceita() + " despachada com sucesso!");
			//Fachada.getInstance().despacharStatusReceita(receitaSelecionada);
		} catch (ValidacaoException e) {
			addMessage(e.getMessage());
		}
	}
		
	
	//M�todos Auxiliares
	
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }			
	
    /*
     * Setando na m�o temporariamente enquanto n�o consigo pegar o usu�rio logado da session
     */
    public Usuario pegarUsuarioLogado() throws ValidacaoException{
		Usuario atendente = new Usuario();
		atendente.setIdUsuario(3);
		atendente.setLogin("brenda.oliveira");
		atendente.setPerfil(EnumPerfil.ATENDENTE.toString());
		atendente.setSenha("123456");			
		/*
		//pegando Usuario setado na Session pelo LoginBean(no LoginBean tem  um metodo sessionMap.put q bota o usuario nessa lista Map)
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();						
		Usuario usuarioLogado = (Usuario) sessionMap.get("logado");
		*/		
		return atendente;
	}

	public StatusReceita abrir(Usuario usuario){
		StatusReceita status = new StatusReceita();
		status.setDataAlteracao(Calendar.getInstance());
		status.setReceita(receitaSelecionada);
		status.setStatus(EnumStatus.ABERTA.toString());
		status.setUsuarioAlteracao(usuario);			
		return status;
	}
	
	public StatusReceita despachar(Usuario usuario){
		StatusReceita status = new StatusReceita();
		status.setDataAlteracao(Calendar.getInstance());
		status.setReceita(receitaSelecionada);
		status.setStatus(EnumStatus.FECHADA.toString());
		status.setUsuarioAlteracao(usuario);			
		return status;
	}
	
	public Receita getReceitaSelecionada() {
		return receitaSelecionada;
	}

	public void setReceitaSelecionada(Receita receitaSelecionada) {
		this.receitaSelecionada = receitaSelecionada;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
}
