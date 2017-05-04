package basicas;

import java.sql.Date;
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
@Table(name="paciente")
public class Paciente {

	@Id
	@GeneratedValue
	@Column(name="id_paciente")
	private Integer idPaciente;
	
	//este campo possue 15 caracteres --> xxx xxxx xxxx xxxx
	@Column(name="id_sus", unique=true)
	private Integer idSUS;
	
	private String nome;
	
	private Character sexo;
	
	@Column(name="data_nasc")
	private Date dataNasc;
	
	private Endereco endereco;
	
	@OneToMany(mappedBy="paciente",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<Receituario> receituarios;
	
	public Paciente(){}
	
	public Paciente(Integer id, Integer idSUS, String nome, Character sexo, Date dataNasc, Endereco endereco) {
		super();
		this.idPaciente = id;
		this.idSUS = idSUS;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Receituario> getReceituarios() {
		return receituarios;
	}

	public void setReceituarios(List<Receituario> receituarios) {
		this.receituarios = receituarios;
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
