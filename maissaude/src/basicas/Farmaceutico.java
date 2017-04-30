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

/**
 * 
 * @author Rhuan
 *
 */
@Entity
@Table(name="farmaceutico")
public class Farmaceutico {

	@Id
	@GeneratedValue
	@Column(name="id_farmaceutico")
	private Integer idFarmaceutico;
	
	@Column(name="registro_MS")
	//numero que está registrado no Ministerio da saude.
	private String registroMS;
	
	@Column(length=200)
	private String nome;
	
	@OneToMany(mappedBy="farmaceutico",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<Receituario> receituarios;
	
	public Farmaceutico(){}

	public Integer getIdFarmaceutico() {
		return idFarmaceutico;
	}

	public void setIdFarmaceutico(Integer idFarmaceutico) {
		this.idFarmaceutico = idFarmaceutico;
	}

	public String getRegistroMS() {
		return registroMS;
	}

	public void setRegistroMS(String registroMS) {
		this.registroMS = registroMS;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Farmaceutico other = (Farmaceutico) obj;
		if (registroMS == null) {
			if (other.registroMS != null)
				return false;
		} else if (!registroMS.equals(other.registroMS))
			return false;
		return true;
	}

	
}
