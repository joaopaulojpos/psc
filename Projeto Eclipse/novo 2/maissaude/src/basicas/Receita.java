package basicas;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Receita")
public class Receita {
	@Id
	@GeneratedValue
	@Column(name="id_receita")
	private Integer idReceita;
	
	@Column(name="data_geracao", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataGeracao;
	
	@Column(name="prazo", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar prazo;
	
	@ManyToOne
	@JoinColumn(name="id_medico", nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="id_doenca", nullable=false)
	private Doenca doenca;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receita_medicamento",
				joinColumns=@JoinColumn(name="id_receita"),
				inverseJoinColumns=@JoinColumn(name="id_medicamento"))
	private List<Medicamento> listaMedicamentos;
	
	@Column(name="isControlada", nullable=false)	
	private boolean isControlada;
	
	@OneToMany(mappedBy="receita", fetch=FetchType.EAGER)	
	@Cascade(CascadeType.ALL)
	private List<StatusReceita> listaStatusReceita;
		
	//Transient = não irá ser persistido no Hibernate
	@Transient
	private StatusReceita ultimoStatus;

	//Atendente fica só no status, n tem pra q a receita guardar o atendente(e tá dando erro)
//	@ManyToOne
//	@JoinColumn(name="id_atendente", nullable=true)
//	private Atendente atendente;

	public Integer getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}

	public Date getDataGeracao() {
		Date dataFormatada = prazo.getTime();
		return dataFormatada;
	}

	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Date getPrazo() {				
		Date dataFormatada = prazo.getTime();
		return dataFormatada;
	}
	
	/**
	 * Ajudar na validação de Receita expirada
	 * @return
	 */
	public Calendar getPrazoCalendar(){
		return this.prazo;
	}

	public void setPrazo(Calendar prazo) {
		this.prazo = prazo;
	}

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	public List<StatusReceita> getListaStatusReceita() {
		return listaStatusReceita;
	}

	public void setListaStatusReceita(List<StatusReceita> listaStatusReceita) {
		this.listaStatusReceita = listaStatusReceita;
		setUltimoStatus(listaStatusReceita.get(listaStatusReceita.size() - 1));
	}

//	public Atendente getAtendente() {
//		return atendente;
//	}
//
//	public void setAtendente(Atendente atendente) {
//		this.atendente = atendente;
//	}

	public Receita() {
		super();		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReceita == null) ? 0 : idReceita.hashCode());
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
		Receita other = (Receita) obj;
		if (idReceita == null) {
			if (other.idReceita != null)
				return false;
		} else if (!idReceita.equals(other.idReceita))
			return false;
		return true;
	}

	public StatusReceita getUltimoStatus() {
		return ultimoStatus;
	}

	public void setUltimoStatus(StatusReceita ultimoStatus) {
		this.ultimoStatus = ultimoStatus;
	}

	public boolean getIsControlada() {
		return isControlada;
	}

	public void setControlada(boolean isControlada) {
		this.isControlada = isControlada;
	}

	public Receita(Integer idReceita, Calendar dataGeracao, Calendar prazo, List<Medicamento> listaMedicamentos,
			Medico medico, Paciente paciente, Doenca doenca, List<StatusReceita> listaStatusReceita,
			boolean isControlada, StatusReceita ultimoStatus) {
		super();
		this.idReceita = idReceita;
		this.dataGeracao = dataGeracao;
		this.prazo = prazo;
		this.listaMedicamentos = listaMedicamentos;
		this.medico = medico;
		this.paciente = paciente;
		this.doenca = doenca;
		this.listaStatusReceita = listaStatusReceita;
		this.isControlada = isControlada;
		this.ultimoStatus = ultimoStatus;
	}




}
