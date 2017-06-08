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
import javax.persistence.Table;

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
	private Calendar dataGeracao;
	
	@Column(name="prazo", nullable=false)
	private Calendar prazo;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receita_medicamento",
				joinColumns=@JoinColumn(name="id_receita"),
				inverseJoinColumns=@JoinColumn(name="id_medicamento"))
	private List<Medicamento> listaMedicamentos;
	
	@ManyToOne
	@JoinColumn(name="id_Medico", nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_Paciente", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="id_Doenca", nullable=false)
	private Doenca doenca;
	
	@OneToMany(mappedBy="receita", fetch=FetchType.LAZY)	
	@Cascade(CascadeType.ALL)
	private List<StatusReceita> listaStatusReceita;
	
	@ManyToOne
	@JoinColumn(name="id_Atendente", nullable=false)
	private Atendente atendente;

	public Integer getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}

	public Calendar getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Calendar getPrazo() {
		return prazo;
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
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Receita() {
		super();
	}

	public Receita(Integer idReceita, Calendar dataGeracao, Calendar prazo, List<Medicamento> listaMedicamentos,
			Medico medico, Paciente paciente, Doenca doenca, List<StatusReceita> listaStatusReceita,
			Atendente atendente) {
		super();
		this.idReceita = idReceita;
		this.dataGeracao = dataGeracao;
		this.prazo = prazo;
		this.listaMedicamentos = listaMedicamentos;
		this.medico = medico;
		this.paciente = paciente;
		this.doenca = doenca;
		this.listaStatusReceita = listaStatusReceita;
		this.atendente = atendente;
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
}
