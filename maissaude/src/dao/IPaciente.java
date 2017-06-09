package dao;

import java.util.List;

import basicas.Medico;
import basicas.Paciente;

/**
 * 
 * @author rndantas
 *
 */
public interface IPaciente {
	
	public Paciente pesquisarCPF(String cpf);
	public Paciente pesquisarCNS(String cns);
}
