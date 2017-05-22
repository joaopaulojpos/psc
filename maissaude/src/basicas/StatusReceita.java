package basicas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Pra auditoria
@Entity
@Table(name="StatusReceita")
public class StatusReceita {
	@Id
	@GeneratedValue
	@Column(name="id_status_receita")
	private Integer idStatusReceita;
		
	@OneToOne
	@JoinColumn(name="id_Pessoa")
	private Usuario usuarioQueAlterou;
	
	@Column(name="data_alteracao", nullable=false)
	private Calendar dataAlteracao;
	
	@Column(name="status", nullable=false)
	private String status;	
	
	@ManyToOne
	@JoinColumn(name="id_receita", nullable=false)
	private Receita receita;

	public Integer getIdStatusReceita() {
		return idStatusReceita;
	}

	public void setIdStatusReceita(Integer idStatusReceita) {
		this.idStatusReceita = idStatusReceita;
	}

	public Usuario getListaUsuarioAlteracoes() {
		return usuarioQueAlterou;
	}

	public void setListaUsuarioAlteracoes(Usuario usuarioQueAlterou) {
		this.usuarioQueAlterou = usuarioQueAlterou;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Receita getListaReceitas() {
		return receita;
	}

	public void setListaReceitas(Receita receita) {
		this.receita = receita;
	}

	public StatusReceita() {
		super();
	}

	public StatusReceita(Integer idStatusReceita, Usuario usuarioQueAlterou, Calendar dataAlteracao,
			String status, Receita receita) {
		super();
		this.idStatusReceita = idStatusReceita;
		this.usuarioQueAlterou = usuarioQueAlterou;
		this.dataAlteracao = dataAlteracao;
		this.status = status;
		this.receita = receita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStatusReceita == null) ? 0 : idStatusReceita.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusReceita other = (StatusReceita) obj;
		if (idStatusReceita == null) {
			if (other.idStatusReceita != null)
				return false;
		} else if (!idStatusReceita.equals(other.idStatusReceita))
			return false;
		return true;
	}	
}
