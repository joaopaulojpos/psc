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
//@Entity
//@Table(name="farmaceutico")
public class Farmaceutico extends Usuario{
	
	@Column(name="crf",unique=true)
	private Long crf;
	
	
public Long getCrf() {
		return crf;
	}


	public void setCrf(Long crf) {
		this.crf = crf;
	}


	//	@OneToMany(mappedBy="farmaceutico",fetch=FetchType.LAZY)
//	@Cascade(CascadeType.ALL)
//	private List<Receituario> receituarios;
//	
	public Farmaceutico(){}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crf == null) ? 0 : crf.hashCode());
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
		if (crf == null) {
			if (other.crf != null)
				return false;
		} else if (!crf.equals(other.crf))
			return false;
		return true;
	}

	
}
