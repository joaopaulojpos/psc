package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BeanUsuario  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    private String senhaDigitada;
    private String login;


	public String getSenhaDigitada() {
		return senhaDigitada;
	}


	public void setSenhaDigitada(String senhaDigitada) {
		this.senhaDigitada = senhaDigitada;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	} 

}
