package basicas;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Pessoa {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome", length=50)
	private String nome;
	
	@Column(name="cpf", length=11)
	private Long cpf;
	
	@Column(name="rg", length=15)
	private Long rg;
}
