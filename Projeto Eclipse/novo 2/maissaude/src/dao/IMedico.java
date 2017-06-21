package dao;


import basicas.Medico;

/**
 * 
 * @author rndantas
 *
 */
public interface IMedico {
	
	public Medico pesquisarCRM(String crm);
	public Medico pesquisarUserId(Integer id);
}
