package basicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Receita {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="dataGeracao")
	private Calendar dataGeracao;
	
	//FAZER RELACIONAMENTO HIBERNATE
	private Medicamento medicamento;
	private Medico medico;
	private Paciente paciente;
	private Doenca doenca;
	private StatusReceita statusReceita;
	private Farmaceutico farmaceutico;
	private Atendente atendente;
}
