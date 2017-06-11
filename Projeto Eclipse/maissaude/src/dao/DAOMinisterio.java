package dao;

import javax.persistence.EntityManagerFactory;

import basicas.Ministerio;

public class DAOMinisterio extends DAOGenerico<Ministerio> implements IMinisterio{
	
	public DAOMinisterio(EntityManagerFactory emf) {
		super(emf); 
	}
}
