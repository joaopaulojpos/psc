package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import util.PersistenciaException;


public abstract class DAOGenerico<Entity> {

	
	private EntityManagerFactory entityManagerFactory;
	private Class<Entity> persistentClass;

	@SuppressWarnings("unchecked")	
	public DAOGenerico(EntityManagerFactory emf){
		this.setEntityManagerFactory(emf);
		this.entityManagerFactory = emf;
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
	    persistentClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[0];  
	}
	
	/**
	 * Executa o merge do objeto que se encontra em mem�ria.
	 * 
	 * @param objeto
	 *            a ser realizado o merge
	 * @return objeto que foi executado o merge
	 */
	public void editar(Entity objeto) throws PersistenciaException{
		
		EntityManager em = this.entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		try{
		tx.begin();
		
		objeto = em.merge(objeto);
		
		tx.commit();
		
		} catch (RuntimeException e) {
		tx.rollback();      
		throw new PersistenciaException();
		}

		em.close();
		
	}
	@SuppressWarnings("unchecked")
	public final List<Entity> listar() throws PersistenciaException{
		List<Entity> instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = ((List<Entity>) em.createQuery(
					"from " + getPersistentClass().getName()).getResultList());
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new PersistenciaException();
		}
		em.close();
		return instance;
	}
	

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto a ser salvo
	 */
	public void inserir(Entity objeto) throws PersistenciaException{
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();		
		try {
			tx.begin();
			em.persist(objeto);
			tx.commit();
			
		} catch (RuntimeException re) {
			tx.rollback();
			throw new PersistenciaException();
		}
		em.close();
	}

	/**
	 * Remove o objeto da base de dados.
	 * 
	 * @param objeto
	 *            a ser removido
	 */
	public final void remover(Entity objeto) throws PersistenciaException{
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
		tx.begin();

		// Este merge foi incluido para permitir a exclusao de objetos no estado Detached
		objeto = em.merge(objeto);
		
		em.remove(objeto);
		
		tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			throw new PersistenciaException();
		}
		em.close();
	}

	
	
	/**
	 * Busca o objeto uma vez passado sua chave como par�metro.
	 * 
	 * @param chave
	 *            identificador
	 * @return Objeto do tipo T
	 */
	public final Entity searchByKey(Serializable chave) throws PersistenciaException{
		Entity instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = (Entity) em.find(getPersistentClass(), chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new PersistenciaException();
		}
		em.close();
		return instance;
	}
	
	/**
	 * Utilizado para se injetar o Entity manager no DAO.
	 * 
	 * @param entityManager
	 *            entity manager
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManagerFactory getEntityManagerFactory() {		
		return entityManagerFactory;
	}

	
	/**
	 * Busca a classe persistente do objeto utilizado na classe.
	 * 
	 * @return classe persistente
	 */
	protected final Class<Entity> getPersistentClass() {
		return persistentClass;
	}
	
}

