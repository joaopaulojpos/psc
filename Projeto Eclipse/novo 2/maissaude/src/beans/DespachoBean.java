package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import basicas.EnumStatus;
import basicas.Receita;
import basicas.StatusReceita;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@ManagedBean
@RequestScoped
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
			receitas = alimentarTableReceitas();
			addMessage("Receita n° " + receitaSelecionada.getIdReceita() + " despachada com sucesso!");
			//Fachada.getInstance().despacharStatusReceita(receitaSelecionada);
		} catch (ValidacaoException e) {
			addMessage(e.getMessage());
		}
	}
		
	
	//Métodos Auxiliares
	
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }			
	
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
    
    public Usuario pegarUsuarioLogado() throws ValidacaoException{
    	Usuario usuario = new Usuario();
    	usuario = loginBean.getUsuarioLogado();    	    	    			
		return usuario;		
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
	
    public void paginaDespacho(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
				null,
				"/atendente/despacharReceita.xhtml?faces-redirect=true");	
    }
}
