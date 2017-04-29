package basicas;

import java.time.LocalDate;

public class Paciente {

	private Integer id;
	//este campo possue 15 caracteres --> xxx xxxx xxxx xxxx
	private Integer idSUS;
	private String nome;
	private Character sexo;
	private LocalDate dataNasc;
	private Endereco endereco;
	
	public Paciente(){}
	
	public Paciente(Integer id, Integer idSUS, String nome, Character sexo, LocalDate dataNasc, Endereco endereco) {
		super();
		this.id = id;
		this.idSUS = idSUS;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdSUS() {
		return idSUS;
	}
	public void setIdSUS(Integer idSUS) {
		this.idSUS = idSUS;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSUS == null) ? 0 : idSUS.hashCode());
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
		if (idSUS == null) {
			if (other.idSUS != null)
				return false;
		} else if (!idSUS.equals(other.idSUS))
			return false;
		return true;
	}
	
}
