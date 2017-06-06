package rn;

import basicas.Usuario;
import dao.DAOFactory;
import util.Validacao;

public class RNUsuario {	
	private final Validacao VALIDA;
	private DAOFactory dao;
	
	public RNUsuario(){
		
		VALIDA = new Validacao();
	}
	
	public Usuario efetuarLogin(String login, String senha){
		return dao.getDAOUsuario().efetuarLogin(login, senha);
	}
}
