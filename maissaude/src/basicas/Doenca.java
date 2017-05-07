package basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Rhuan
 *
 */
@Entity
@Table(name="doenca")
public class Doenca {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(length=200,nullable=false)
	private String nome;	
	
	//Um código que toda doença tem
	@Column
	private Long cnd;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnd() {
		return cnd;
	}

	public void setCnd(Long cnd) {
		this.cnd = cnd;
	}

	public Doenca(){}

	public Doenca(Integer id, String nome, Long cnd) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnd = cnd;
	}
}
