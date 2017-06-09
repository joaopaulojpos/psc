package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import basicas.EnumPerfil;
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

	public void setUsuarioLogado(Usuario usuarioLogado) throws LoginInvalidoException {
		if(usuarioLogado == null){
			throw new LoginInvalidoException("Login inválido!\n");
		}
		this.usuarioLogado = usuarioLogado;
	}

	public LoginBean() throws LoginInvalidoException {
			
	}
	


	public void efetuarLogin(){
		try {
			setUsuarioLogado(Fachada.getInstance().efetuarLogin(login, senha));
			
			
			if(getUsuarioLogado().getPerfil().equals(EnumPerfil.ATENDENTE.toString())){
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
						null,
						"/atendente/despacharReceita.xhtml?faces-redirect=true");				
			} else if(getUsuarioLogado().getPerfil().equals(EnumPerfil.MEDICO.toString())){
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
						null,
						"/medico/homeMedico.xhtml?faces-redirect=true");
			} else
			if(getUsuarioLogado().getPerfil().equals(EnumPerfil.MINISTERIO.toString())){				
					FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
							null,
							"/ministerio/homeMinisterio.xhtml?faces-redirect=true");
			}else{
				throw new LoginInvalidoException("Login inválido!\n");
			}									
		}catch (LoginInvalidoException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login/Senha inexistente"));
		}
	}
	
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }	
}
