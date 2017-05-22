package basicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="Paciente")
public class Paciente extends Pessoa{

	//este campo possue 15 caracteres --> xxx xxxx xxxx xxxx
	//Cartão Nacional de Saúde
	@Column(name="cns", unique=true, nullable=false)
	private String cns;
	
	@OneToMany(mappedBy="paciente", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public Paciente() {
		super();
	}

	public Paciente(String cns, List<Receita> listaReceitas) {
		super();
		this.cns = cns;
		this.listaReceitas = listaReceitas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cns == null) ? 0 : cns.hashCode());
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
		Paciente other = (Paciente) obj;
		if (cns == null) {
			if (other.cns != null)
				return false;
		} else if (!cns.equals(other.cns))
			return false;
		return true;
	}
}
