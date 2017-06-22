package beans;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import basicas.Doenca;
import basicas.Usuario;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@ManagedBean
@RequestScoped
public class DoencaBean {
	private Doenca doencaSelecionada;
	private List<Doenca> listaDoenca;
   @ManagedProperty("#{loginBean}")
   private LoginBean loginBean;
   
   
   //Getter's e Setter's
   public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
   
   public Usuario pegarUsuarioLogado() throws ValidacaoException{
   	Usuario usuario = new Usuario();
   	usuario = loginBean.getUsuarioLogado();    	    	    			
		return usuario;		
	}
	
	public Doenca getDoencaSelecionada() {
		return doencaSelecionada;
	}
	public void setDoencaSelecionada(Doenca doencaSelecionada) {
		this.doencaSelecionada = doencaSelecionada;
	}
	public List<Doenca> getListaDoenca() {
		return listaDoenca;
	}
	public void setListaDoenca(List<Doenca> listaDoenca) {
		this.listaDoenca = listaDoenca;
	}
	
	//Construtores
    @PostConstruct
    public void init() {
    	try{
    		listaDoenca = alimentarTableDoenca();	    		
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}
    }  

    //Métodos
    
	public void inserirDoenca(){
		addMessage("Oi");
	}
	
	public void removerDoenca(){
		addMessage("remover");									
		try {
			Fachada.getInstance().removerDoenca(doencaSelecionada);
			alimentarTableDoenca();
		} catch (ValidacaoException e) { 
			addErro(e.getMessage());
		}									
	}
	
	public void editarDoenca(){
		addMessage("editar");
	}
	
	public void telaNovaDoenca(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
				null,
				"/ministerio/novaDoenca.xhtml?faces-redirect=true");		
	}
	

    
    private List<Doenca> alimentarTableDoenca() {    	
    	List<Doenca> doencas = new ArrayList<>();
    	try{
    		doencas = Fachada.getInstance().listarDoenca();	    	   		
    	}catch(Exception e){
    		addMessage(e.getMessage());
    	}	
    	return doencas;
	}
	
    //Métodos Auxiliares
    public void addGrowl(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage("mensagensGrowl", message);
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage("mensagens", message);
    }
    public void addErro(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage("mensagens", message);
    }
    
    
    public void paginaDoenca(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
				null,
				"/ministerio/cadastroDoenca.xhtml?faces-redirect=true");	
    }
    
}
