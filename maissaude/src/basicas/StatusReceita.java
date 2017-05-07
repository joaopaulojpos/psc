package basicas;

import java.util.Calendar;
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

//Pra auditoria
@Entity
@Table(name="StatusReceita")
public class StatusReceita {
	@Id
	@GeneratedValue
	@Column(name="id_status_receita")
	private Integer idStatusReceita;
	
	@OneToMany(mappedBy="statusReceita")	
	private List<Usuario> listaUsuarioAlteracoes;
	
	@Column(name="data_alteracao")
	private Calendar dataAlteracao;
	
	@Column(name="status")
	private Enum status;	
	
	@OneToMany(mappedBy="statusReceita", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<Receita> listaReceitas;	
	
	public Integer getId() {
		return idStatusReceita;
	}

	public void setId(Integer id) {
		this.idStatusReceita = id;
	}

	public List<Usuario> getListaUsuarioAlteracoes() {
		return listaUsuarioAlteracoes;
	}

	public void setListaUsuarioAlteracoes(List<Usuario> listaUsuarioAlteracoes) {
		this.listaUsuarioAlteracoes = listaUsuarioAlteracoes;
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

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public StatusReceita(){}
	
	public StatusReceita(Integer id, List<Usuario> listaUsuarioAlteracoes, Calendar dataAlteracao, Enum status){
		this.idStatusReceita = id;
		this.listaUsuarioAlteracoes = listaUsuarioAlteracoes;
		this.dataAlteracao = dataAlteracao;
		this.status = status;
	}
}
