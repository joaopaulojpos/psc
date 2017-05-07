package basicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Pra auditoria
public class StatusReceita {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	//FAZER RELACIONAMENTO HIBERNATE
	@Column
	private Usuario usuarioAlteracao;
	
	@Column(name="dataAlteracao")
	private Calendar dataAlteracao;
	
	@Column(name="status")
	private Enum status;	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Enum getStatus() {
		return status;
	}

	public void setStatus(Enum status) {
		this.status = status;
	}

	public StatusReceita(){}
	
	public StatusReceita(Integer id, Usuario usuarioAlteracao, Calendar dataAlteracao, Enum status){
		this.id = id;
		this.usuarioAlteracao = usuarioAlteracao;
		this.dataAlteracao = dataAlteracao;
		this.status = status;
	}
}
