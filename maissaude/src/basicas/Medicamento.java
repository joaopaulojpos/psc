package basicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Rhuan
 *
 */
//@Entity
//@Table(name="medicamento")
public class Medicamento {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
		
	@Column(length=200)
	private String nome;	
	
	@Column(name="isControlado")
	private boolean isControlado;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="receituario_medicamento",
//				joinColumns=@JoinColumn(name="id_medicamento"),
//				inverseJoinColumns=@JoinColumn(name="id_receituario"))
//	private List<Receituario> receituarios;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isControlado() {
		return isControlado;
	}

	public void setControlado(boolean isControlado) {
		this.isControlado = isControlado;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medicamento(){}

	public Integer getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
