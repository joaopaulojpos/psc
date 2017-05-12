package dao;

import java.util.List;

import basicas.Medico;

public interface IMedicoDAO {

	public List<Medico> medicoPorCrm(Integer crm);
}
