package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ExemploBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}