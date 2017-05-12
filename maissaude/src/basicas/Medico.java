package basicas;

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


@Entity
@Table(name="medico")
public class Medico {

	@Id
	@GeneratedValue
	@Column(name="id_medico")
	private Integer idMedico;
	
	@Column(length=100,nullable=false)
	private String nome;
	
	@Column(unique=true)
	private Integer CRM;
	
	@OneToMany(mappedBy="medico",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<Receituario> receituarios;
	
	public Medico(){}
	
	public Medico(Integer idMedico, String nome, Integer cRM) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.CRM = cRM;
	}
	
	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCRM() {
		return CRM;
	}

	public void setCRM(Integer cRM) {
		CRM = cRM;
	}

	public List<Receituario> getReceituarios() {
		return receituarios;
	}

	public void setReceituarios(List<Receituario> receituarios) {
		this.receituarios = receituarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CRM;
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
		Medico other = (Medico) obj;
		if (CRM != other.CRM)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", CRM=" + CRM + ", receituarios=" + receituarios
				+ "]";
	}
	
	
}
