package basicas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Pra auditoria
@Entity
@Table(name="EstadoReceita")
public class EstadoReceita {
	@Id
	@GeneratedValue
	@Column(name="id_estado_receita")
	private Integer idEstadoReceita;
		
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuarioAlteracao;
	
	@Column(name="data_alteracao", nullable=false)
	private Calendar dataAlteracao;
	
	@Column(name="estado", nullable=false)
	private String estado;	
	
	@ManyToOne
	@JoinColumn(name="id_receita", nullable=false)
	private Receita receita;

	public Integer getIdEstadoReceita() {
		return idEstadoReceita;
	}

	public void setIdEstadoReceita(Integer idEstadoReceita) {
		this.idEstadoReceita = idEstadoReceita;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public EstadoReceita() {
		super();
	}

	public EstadoReceita(Integer idEstadoReceita, Usuario usuarioAlteracao, Calendar dataAlteracao, String estado,
			Receita receita) {
		super();
		this.idEstadoReceita = idEstadoReceita;
		this.usuarioAlteracao = usuarioAlteracao;
		this.dataAlteracao = dataAlteracao;
		this.estado = estado;
		this.receita = receita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstadoReceita == null) ? 0 : idEstadoReceita.hashCode());
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
		EstadoReceita other = (EstadoReceita) obj;
		if (idEstadoReceita == null) {
			if (other.idEstadoReceita != null)
				return false;
		} else if (!idEstadoReceita.equals(other.idEstadoReceita))
			return false;
		return true;
	}

}
