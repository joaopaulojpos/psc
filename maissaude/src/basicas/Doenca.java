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
@Table(name="Doenca")
public class Doenca {

	@Id
	@GeneratedValue
	@Column(name="id_doenca")
	private Integer idDoenca;
	
	@Column(length=200,unique=true,nullable=false)
	private String nome;
	
	//Um código que toda doença tem
	@Column(name="cnd", unique=true,nullable=false)
	private String cnd;
	
	@OneToMany(mappedBy="doenca", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;

	public Integer getIdDoenca() {
		return idDoenca;
	}

	public void setIdDoenca(Integer idDoenca) {
		this.idDoenca = idDoenca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnd() {
		return cnd;
	}

	public void setCnd(String cnd) {
		this.cnd = cnd;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public Doenca() {
		super();
	}

	public Doenca(Integer idDoenca, String nome, String cnd, List<Receita> listaReceitas) {
		super();
		this.idDoenca = idDoenca;
		this.nome = nome;		
		this.cnd = cnd;
		this.listaReceitas = listaReceitas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDoenca == null) ? 0 : idDoenca.hashCode());
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
		Doenca other = (Doenca) obj;
		if (idDoenca == null) {
			if (other.idDoenca != null)
				return false;
		} else if (!idDoenca.equals(other.idDoenca))
			return false;
		return true;
	}
}
