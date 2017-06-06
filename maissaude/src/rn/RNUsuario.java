package rn;

import java.util.List;

import basicas.Usuario;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNUsuario {	
	
	private final Validacao VALIDA;
	private DAOFactory dao;
	
	public RNUsuario(){		
		VALIDA = new Validacao();
	}
	
	public void inserir(Usuario usuario) throws ValidacaoException{		
		inserirUsuario(usuario);
	}
	
	public void editar(Usuario usuario){
		editarUsuario(usuario);
	}
	
	public List<Usuario> listar(){
		return listarUsuarios();
	}
	
	public Usuario listarUsuarioLogin(String login){
		return listarLogin(login);
	}
	
	public void remover(Usuario usuario){
		removerUsuario(usuario);
	}
	
	//--------------Métodos auxiliares---------------\\
	
		private void inserirUsuario(Usuario usuario){
			dao.getDAOUsuario().inserir(usuario);
		}				
		
		private void editarUsuario(Usuario usuario){
			dao.getDAOUsuario().editar(usuario);
		}
		
		private void removerUsuario(Usuario usuario){
			dao.getDAOUsuario().remover(usuario);
		}
		
		private List<Usuario> listarUsuarios(){
			return dao.getDAOUsuario().listar();
		}
		
		private Usuario listarLogin(String login){
			return dao.getDAOUsuario().pesquisarLogin(login);
		}	
		
		
	public Usuario efetuarLogin(String login, String senha){
		return dao.getDAOUsuario().efetuarLogin(login, senha);
	}
}
