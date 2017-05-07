package basicas;

import java.util.Calendar;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Receita")
public class Receita {
	@Id
	@GeneratedValue
	@Column(name="id_receita")
	private Integer idReceita;
	
	@Column(name="data_geracao")
	private Calendar dataGeracao;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receita_medicamento",
				joinColumns=@JoinColumn(name="id_receita"),
				inverseJoinColumns=@JoinColumn(name="id_medicamento"))
	private List<Medicamento> listaMedicamentos;
	
	@ManyToOne
	@JoinColumn(name="id_Medico")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_Paciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="id_Doenca")
	private Doenca doenca;
	
	@ManyToOne
	@JoinColumn(name="id_status_receita")
	private StatusReceita statusReceita;
	
	@ManyToOne
	@JoinColumn(name="id_Atendente")
	private Atendente atendente;

	public Integer getId() {
		return idReceita;
	}

	public void setId(Integer id) {
		this.idReceita = id;
	}

	public Calendar getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
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

	public StatusReceita getStatusReceita() {
		return statusReceita;
	}

	public void setStatusReceita(StatusReceita statusReceita) {
		this.statusReceita = statusReceita;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	
	public Receita(){}
	
	public Receita(Atendente atendente, Calendar dataGeracao, Doenca doenca, List<Medicamento> listaMedicamentos, Medico medico, Paciente paciente, StatusReceita statusReceita){
		setAtendente(atendente);
		setDataGeracao(dataGeracao);
		setDoenca(doenca);		
		setListaMedicamentos(listaMedicamentos);
		setMedico(medico);
		setPaciente(paciente);
		setStatusReceita(statusReceita);		
	}
	
}
