package basicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Usuario")
public class Usuario{	
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@Column(name="login", nullable=false)
	private String login;
	
	@Column(name="senha", nullable=false)
	private String senha;		
	
	@Column(name="perfil", nullable=false)
	private String perfil;

	@OneToMany(mappedBy="usuarioAlteracao", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<StatusReceita> listaStatusReceita;
	
	@OneToOne(mappedBy="usuario")
	@Cascade(CascadeType.ALL)
	Atendente atendente;
	
	@OneToOne(mappedBy="usuario")
	@Cascade(CascadeType.ALL)
	Medico medico;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<StatusReceita> getListaStatusReceita() {
		return listaStatusReceita;
	}

	public void setListaStatusReceita(List<StatusReceita> listaStatusReceita) {
		this.listaStatusReceita = listaStatusReceita;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String login, String senha, String perfil, List<StatusReceita> listaStatusReceita, Atendente atendente, Medico medico) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.listaStatusReceita = listaStatusReceita;
		this.atendente= atendente;
		this.medico = medico;
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
