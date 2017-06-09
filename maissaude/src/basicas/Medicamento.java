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
@Entity
@Table(name="Medicamento")
public class Medicamento {

	@Id
	@GeneratedValue
	@Column(name="id_medicamento")
	private Integer idMedicamento;
		
	@Column(length=200,unique=true,nullable=false)
	private String nome;	
	
	@Column(name="isControlado")
	private boolean isControlado;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receita_medicamento",
				joinColumns=@JoinColumn(name="id_medicamento"),
				inverseJoinColumns=@JoinColumn(name="id_receita"))
	private List<Receita> listaReceitas;

	public Integer getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

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

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public Medicamento() {
		super();
	}

	public Medicamento(Integer idMedicamento, String nome, boolean isControlado, List<Receita> listaReceitas) {
		super();
		this.idMedicamento = idMedicamento;
		this.nome = nome;
		this.isControlado = isControlado;
		this.listaReceitas = listaReceitas;
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
