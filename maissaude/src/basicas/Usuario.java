package basicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Pessoa{	
	
	@Column(name="login", nullable=false)
	private String login;
	
	@Column(name="senha", nullable=false)
	private String senha;		

	@OneToMany(mappedBy="usuarioAlteracao", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<StatusReceita> listaStatusReceita;

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

	public List<StatusReceita> getListaStatusReceita() {
		return listaStatusReceita;
	}

	public void setListaStatusReceita(List<StatusReceita> listaStatusReceita) {
		this.listaStatusReceita = listaStatusReceita;
	}

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, List<StatusReceita> listaStatusReceita) {
		super();
		this.login = login;
		this.senha = senha;
		this.listaStatusReceita = listaStatusReceita;
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
