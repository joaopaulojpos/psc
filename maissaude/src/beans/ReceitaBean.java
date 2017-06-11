package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
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
				Usuario usuaario = pegarUsuarioLogado();
				System.out.println(usuaario.getLogin());
				//Fachada.getInstance().inserirStatusReceita(abrirReceita());
				//Fachada.getInstance().despacharStatusReceita(receitaSelecionada);
			} catch (ValidacaoException e) {
				addMessage(e.getMessage());
			}
		}
		
		
		//Método não funcionando n sei pq
		public Usuario pegarUsuarioLogado() throws ValidacaoException{
			Usuario u  = new Usuario();
			u.setIdUsuario(3);
			u.setLogin("ferrari");
			u.setPerfil(EnumPerfil.MEDICO.toString());
			u.setSenha("123456");
			
			
			//pegando Usuario setado na Session pelo LoginBean(no LoginBean tem  um metodo sessionMap.put q bota o usuario nessa lista Map)
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();						
			Usuario usuarioLogado = (Usuario) sessionMap.get("logado");
			
			if(u.getLogin().equals("asadsjffkajfls")){
				throw new ValidacaoException("asfa");
			}
			return usuarioLogado;
		}
		
		
		
		
		public StatusReceita abrirReceita(){
			StatusReceita status = new StatusReceita();
			status.setDataAlteracao(Calendar.getInstance());
			status.setReceita(receitaSelecionada);
			status.setStatus(EnumStatus.ABERTA.toString());
			//status.setUsuarioAlteracao(usuarioAlteracao);
			return status;
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
