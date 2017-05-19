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
	
	@Column(name="gravidade")
	private EnumGravidade gravidade;
	
	//Um código que toda doença tem
	@Column(name="cnd", unique=true,nullable=false)
	private Long cnd;
	
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

	public EnumGravidade getGravidade() {
		return gravidade;
	}

	public void setGravidade(EnumGravidade gravidade) {
		this.gravidade = gravidade;
	}

	public Long getCnd() {
		return cnd;
	}

	public void setCnd(Long cnd) {
		this.cnd = cnd;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public Doenca(Integer idDoenca, String nome, EnumGravidade gravidade, Long cnd, List<Receita> listaReceitas) {
		super();
		this.idDoenca = idDoenca;
		this.nome = nome;
		this.gravidade = gravidade;
		this.cnd = cnd;
		this.listaReceitas = listaReceitas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnd == null) ? 0 : cnd.hashCode());
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
		if (cnd == null) {
			if (other.cnd != null)
				return false;
		} else if (!cnd.equals(other.cnd))
			return false;
		return true;
	}	
	
}
