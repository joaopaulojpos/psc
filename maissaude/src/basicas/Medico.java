package basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length=100,nullable=false)
	private String nome;
	
	@Column(unique=true)
	private Integer CRM;
	
	public Medico(){}
	
	public Medico(Integer id, String nome, Integer cRM) {
		super();
		this.id = id;
		this.nome = nome;
		this.CRM = cRM;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
}
