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
	@Column(name="id_doenca")
	private Integer idDoenca;
	
	@Column(length=200,nullable=false)
	private String descricao;
	
	@Column(length=100,nullable=true)
	private String causa;
	
	private Gravidade gravidade;
	
	public Doenca(){}

	public Doenca(Integer idDoenca, String descricao, String causa, Gravidade gravidade) {
		super();
		this.idDoenca = idDoenca;
		this.descricao = descricao;
		this.causa = causa;
		this.gravidade = gravidade;
	}

	public Integer getIdDoenca() {
		return idDoenca;
	}

	public void setIdDoenca(Integer idDoenca) {
		this.idDoenca = idDoenca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Gravidade getGravidade() {
		return gravidade;
	}

	public void setGravidade(Gravidade gravidade) {
		this.gravidade = gravidade;
	}
	
}
