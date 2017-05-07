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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author Rhuan
 *
 */
@Entity
@Table(name="Medicamento")
public class Medicamento {

	@Id
	@GeneratedValue
	@Column(name="id_medicamento")
	private Integer idMedicamento;
		
	@Column(length=200)
	private String nome;	
	
	@Column(name="isControlado")
	private boolean isControlado;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receita_medicamento",
				joinColumns=@JoinColumn(name="id_medicamento"),
				inverseJoinColumns=@JoinColumn(name="id_receita"))
	private List<Receita> listaReceitas;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getIsControlado() {
		return isControlado;
	}

	public void setIsControlado(boolean isControlado) {
		this.isControlado = isControlado;
	}

	public void setId(Integer id) {
		this.idMedicamento = id;
	}	

	public Integer getId() {
		return idMedicamento;
	}
	
	public Medicamento(){}
	
	public Medicamento(Integer id, String nome, boolean isControlado){		
		setId(id);
		setNome(nome);
		setIsControlado(isControlado);		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMedicamento == null) ? 0 : idMedicamento.hashCode());
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
		if (idMedicamento == null) {
			if (other.idMedicamento != null)
				return false;
		} else if (!idMedicamento.equals(other.idMedicamento))
			return false;
		return true;
	}
	
}
