package basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id_pessoa")
	private Integer idPessoa;
	
	@Column(name="nome", nullable=false, length=50)
	private String nome;
	
	@Column(name="cpf", nullable=false, length=11)
	private String cpf;
	
	@Column(name="rg", nullable=false, length=15)
	private Long rg;
	
	public Integer getId() {
		return idPessoa;
	}

	public void setId(Integer id) {
		this.idPessoa = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Pessoa(){
		
	}
	
	public Pessoa(Integer id, String nome, String cpf, Long rg){
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setRg(rg);		
	}
}
