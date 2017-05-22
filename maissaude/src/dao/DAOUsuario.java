package dao;

import javax.persistence.EntityManagerFactory;

import basicas.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario>{

	public DAOUsuario(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
}
