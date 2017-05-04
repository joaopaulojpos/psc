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
@Table(name="medicamento")
public class Medicamento {

	@Id
	@GeneratedValue
	@Column(name="id_medicamento")
	private Integer id;
	
	//essa é a numeracao do medicamento no Ministerio da Saude
	private Integer registroMS;
	
	@Column(length=200)
	private String descricao;
	
	private String tipo;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receituario_medicamento",
				joinColumns=@JoinColumn(name="id_medicamento"),
				inverseJoinColumns=@JoinColumn(name="id_receituario"))
	private List<Receituario> receituarios;
	
	public Medicamento(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegistroMS() {
		return registroMS;
	}

	public void setRegistroMS(Integer registroMS) {
		this.registroMS = registroMS;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		result = prime * result + ((registroMS == null) ? 0 : registroMS.hashCode());
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
		if (registroMS == null) {
			if (other.registroMS != null)
				return false;
		} else if (!registroMS.equals(other.registroMS))
			return false;
		return true;
	}
	
}
