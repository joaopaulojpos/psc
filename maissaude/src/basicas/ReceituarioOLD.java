package basicas;

import java.sql.Date;
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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author Rhuan
 *
 */
@Entity
@Table(name="receituario")
public class ReceituarioOLD {

	@Id
	@GeneratedValue
	@Column(name="id_receituario")
	private Integer idReceituario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_medico",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Medico medico;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_paciente",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Paciente paciente;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receituario_medicamento",
				joinColumns=@JoinColumn(name="id_receituario"),
				inverseJoinColumns=@JoinColumn(name="id_medicamento"))
	private List<Medicamento> medicamentos;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="receituario_doenca",
				joinColumns=@JoinColumn(name="id_receituario"),
				inverseJoinColumns=@JoinColumn(name="id_doenca"))
	private List<Doenca> doencas;
	
	private String observacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_farmaceutico",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Farmaceutico farmaceutico;

	private Situacao situacao;
	
	private Date data;
	
	public ReceituarioOLD(){}

	public ReceituarioOLD(Integer idReceituario, Medico medico, Paciente paciente, List<Medicamento> medicamentos,
			List<Doenca> doencas, String observacao, Farmaceutico farmaceutico, Situacao situacao,
			Date data) {
		super();
		this.idReceituario = idReceituario;
		this.medico = medico;
		this.paciente = paciente;
		this.medicamentos = medicamentos;
		this.doencas = doencas;
		this.observacao = observacao;
		this.farmaceutico = farmaceutico;
		this.situacao = situacao;
		this.data = data;
	}

	public Integer getIdReceituario() {
		return idReceituario;
	}

	public void setIdReceituario(Integer idReceituario) {
		this.idReceituario = idReceituario;
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

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}

	public void setFarmaceutico(Farmaceutico farmaceutico) {
		this.farmaceutico = farmaceutico;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Receituario [idReceituario=" + idReceituario + ", medico=" + medico + ", paciente=" + paciente
				+ ", medicamentos=" + medicamentos + ", doencas=" + doencas + ", observacao=" + observacao
				+ ", farmaceutico=" + farmaceutico + ", situacao=" + situacao + ", data=" + data + "]";
	}
	
}
