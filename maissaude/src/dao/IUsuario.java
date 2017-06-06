package dao;

import basicas.Usuario;

public interface IUsuario {
	public Usuario efetuarLogin(String login, String senha);
}
