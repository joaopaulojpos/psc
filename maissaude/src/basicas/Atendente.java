package basicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Atendente")
public class Atendente extends Pessoa{
	@Column(name="crf",unique=true, nullable=true)
	private String crf;
	
	@Column(name="isFarmaceutico", nullable=false)
	private boolean isFarmaceutico;	
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy="atendente", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;

	public String getCrf() {
		return crf;
	}

	public void setCrf(String crf) {
		this.crf = crf;
	}

	public boolean isFarmaceutico() {
		return isFarmaceutico;
	}

	public void setFarmaceutico(boolean isFarmaceutico) {
		this.isFarmaceutico = isFarmaceutico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public Atendente() {
		super();
	}

	public Atendente(String crf, boolean isFarmaceutico, List<Receita> listaReceitas, Usuario usuario) {
		super();
		this.crf = crf;
		this.isFarmaceutico = isFarmaceutico;
		this.listaReceitas = listaReceitas;
		this.usuario = usuario;
	}

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
		Atendente other = (Atendente) obj;
		if (crf == null) {
			if (other.crf != null)
				return false;
		} else if (!crf.equals(other.crf))
			return false;
		return true;
	}		
}
