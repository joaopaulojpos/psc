package basicas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//Pra auditoria
@Entity
@Table(name="StatusReceita")
public class StatusReceita {
	@Id
	@GeneratedValue
	@Column(name="id_status_receita")
	private Integer idStatusReceita;
	
	@OneToMany(mappedBy="statusReceita")	
	private List<Usuario> listaUsuarioAlteracoes;
	
	@Column(name="data_alteracao", nullable=false)
	private Calendar dataAlteracao;
	
	@Column(name="status", nullable=false)
	private Enum status;	
	
	@OneToMany(mappedBy="statusReceita", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;

	public Integer getIdStatusReceita() {
		return idStatusReceita;
	}

	public void setIdStatusReceita(Integer idStatusReceita) {
		this.idStatusReceita = idStatusReceita;
	}

	public List<Usuario> getListaUsuarioAlteracoes() {
		return listaUsuarioAlteracoes;
	}

	public void setListaUsuarioAlteracoes(List<Usuario> listaUsuarioAlteracoes) {
		this.listaUsuarioAlteracoes = listaUsuarioAlteracoes;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Enum getStatus() {
		return status;
	}

	public void setStatus(Enum status) {
		this.status = status;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public StatusReceita() {
		super();
	}

	public StatusReceita(Integer idStatusReceita, List<Usuario> listaUsuarioAlteracoes, Calendar dataAlteracao,
			Enum status, List<Receita> listaReceitas) {
		super();
		this.idStatusReceita = idStatusReceita;
		this.listaUsuarioAlteracoes = listaUsuarioAlteracoes;
		this.dataAlteracao = dataAlteracao;
		this.status = status;
		this.listaReceitas = listaReceitas;
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
