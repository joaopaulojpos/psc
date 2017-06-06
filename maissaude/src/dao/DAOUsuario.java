package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import basicas.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario>  implements IUsuario{

	public DAOUsuario(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario efetuarLogin(String login, String senha) {
		
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String consulta = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha= :senha";
		Query q = em.createQuery(consulta, Usuario.class);
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		Usuario usuario = (Usuario) q.getSingleResult();
		return usuario;
	}
}
