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
	
	@Column(name="login", nullable=false)
	private String login;
	
	@Column(name="senha", nullable=false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="id_status_receita", nullable=false)
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

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, StatusReceita statusReceita) {
		super();
		this.login = login;
		this.senha = senha;
		this.statusReceita = statusReceita;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
