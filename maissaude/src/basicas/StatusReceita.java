package basicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Pra auditoria
@Entity
@Table(name="StatusReceita")
public class StatusReceita {
	@Id
	@GeneratedValue
	@Column(name="id_status_receita")
	private Integer idStatusReceita;
		
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuarioAlteracao;
	
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

	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
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

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public StatusReceita() {
		super();
	}

	public StatusReceita(Integer idStatusReceita, Usuario usuarioAlteracao, Calendar dataAlteracao, String status,
			Receita receita) {
		super();
		this.idStatusReceita = idStatusReceita;
		this.usuarioAlteracao = usuarioAlteracao;
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
