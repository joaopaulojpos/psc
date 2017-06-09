package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import basicas.Receita;
import rn.Fachada;
import util.exceptions.ValidacaoException;

@ManagedBean
@ViewScoped
public class ReceitaBean {
	   private List<Receita> receitas;
	   private Receita receitaSelecionada;
	   
	    @PostConstruct
	    public void init() {
	    	try{
	    		receitas = alimentarReceitas();
	    	}catch(Exception e){
	    		addMessage(e.getMessage());
	    	}
	    }
	    
	    public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }	    
	    	    
	    public List<Receita> getReceitas() {
	        return receitas;
	    }
	    
	    private List<Receita> alimentarReceitas() throws Exception{
	    	try{
	    		List<Receita> receitas = new ArrayList<>();
		    	receitas = Fachada.getInstance().listarReceita();	    	
		    	return receitas;	
	    	}catch(Exception e){
	    		throw new Exception(e.getMessage());
	    	}
	    	
	    }
	    
		public void despacharReceita(ActionEvent actionEvent){						
			try {
				Fachada.getInstance().despacharStatusReceita(receitaSelecionada);
			} catch (ValidacaoException e) {
				addMessage(e.getMessage());
			}
		}
		
	    public void buttonAction(ActionEvent actionEvent) {
	        addMessage("Welcome to Primefaces!!");
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
}
