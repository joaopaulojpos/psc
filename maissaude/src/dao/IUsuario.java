package dao;

import basicas.Medico;
import basicas.Usuario;

public interface IUsuario {
	
	public Usuario pesquisarLogin(String login);
	public Usuario efetuarLogin(String login, String senha);
}
