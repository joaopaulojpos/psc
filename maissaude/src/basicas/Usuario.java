package basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario extends Pessoa{	
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="id_status_receita")
	private StatusReceita statusReceita;

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

	public StatusReceita getStatusReceita() {
		return statusReceita;
	}

	public void setStatusReceita(StatusReceita statusReceita) {
		this.statusReceita = statusReceita;
	}

	public Usuario(){
		super();
	}
	
	public Usuario(Integer id, String login, String senha){
		setId(id);
		setLogin(login);
		setSenha(senha);		
	}
}
