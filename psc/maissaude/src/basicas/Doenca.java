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
	
	@Column
	private Gravidade gravidade;
	
	//Um código que toda doença tem
	@Column(name="cnd", unique=true,nullable=false)
	private Long cnd;
	
	@OneToMany(mappedBy="doenca", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;	
	
	public Integer getId() {
		return idDoenca;
	}

	public void setId(Integer id) {
		this.idDoenca = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gravidade getGravidade() {
		return gravidade;
	}

	public void setGravidade(Gravidade gravidade) {
		this.gravidade = gravidade;
	}

	public Long getCnd() {
		return cnd;
	}

	public void setCnd(Long cnd) {
		this.cnd = cnd;
	}

	public Doenca(){}

	public Doenca(Integer id, String nome, Long cnd) {		
		this.idDoenca = id;
		this.nome = nome;
		this.cnd = cnd;
	}
}
