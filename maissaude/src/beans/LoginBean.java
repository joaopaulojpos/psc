package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import basicas.Usuario;
import rn.Fachada;
import util.exceptions.LoginInvalidoException;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login;
	private String senha;
	private Usuario usuarioLogado;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String efetuarLogin(){
		try {
			usuarioLogado = Fachada.efetuarLogin(login, senha);
			// return para página de menu
		} catch (LoginInvalidoException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login/Senha inexistente"));
		} // return de volta ao index.xhtml
		return "/index.xhtml?faces-redirect=true";
	}

}
