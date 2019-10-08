package com.transamerica.user.auth.configuration;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDaoConfig<T extends Serializable> {
	Class<T> clazz;

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager entityManager() {
		return entityManager;
	}

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * Save the Entity in the database.
	 */
	public void create(T entity) {
		entityManager.persist(entity);
	
		return;
	}

	/**
	 * Delete the Entity from the database.
	 */
	public void delete(T entity) {
		if (entityManager.contains(entity))
			entityManager.remove(entity);
		else
			entityManager.remove(entityManager.merge(entity));
		return;
	}

	/**
	 * Return all the Entity stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return entityManager.createQuery("from " + clazz).getResultList();
	}

	/**
	 * Return the Entity having the passed id.
	 */
	public T findById(long id) {
		return  entityManager.find(clazz, id);
	}

	/**
	 * Update the passed Entity in the database.
	 */
	public void update(T entity) {
		entityManager.merge(entity);
		return;
	}
	
	 public void deleteById( long entityId ){
	      T entity =(T) findById(entityId);
	      delete( entity );
	   }
	

}
