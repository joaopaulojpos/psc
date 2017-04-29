package basicas;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="receituario")
public class Receituario {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Medico medico;
	
	private Paciente paciente;
	
	private ArrayList<Medicamento> medicamento;
	
	private Doenca doenca;
	
	private String observacao;
	
	private Farmaceutico farmaceutico;
	
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime data;
	
	public Receituario(){}
	
	public Receituario(Integer id, Medico medico, Paciente paciente, ArrayList<Medicamento> medicamento, Doenca doenca,
			LocalDateTime data, String observacao,String status,Farmaceutico farmaceutico) {
		super();
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.medicamento = medicamento;
		this.doenca = doenca;
		this.observacao = observacao;
		this.farmaceutico = farmaceutico;
		this.status = status;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ArrayList<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(ArrayList<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}
