package edu.infnet.patrimonio.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.infnet.patrimonio.negocio.JpaConnection;

public class JpaDAO<T, ID> {

	protected EntityManager em;
	protected Class<T> clazz;

	public JpaDAO(Class<T> clazz) {
		this.em = JpaConnection.getEmf().createEntityManager();
		this.clazz = clazz;
	}

	public Boolean save(T objeto) {
		this.em.getTransaction().begin();
		this.em.persist(objeto);
		this.em.getTransaction().commit();				
		return true;
	}

	public Boolean edit(T objeto) {
		this.em.getTransaction().begin();
		this.em.merge(objeto);
		this.em.getTransaction().commit();				
		return true;
	}

	public Boolean delete(T objeto) {
		this.em.getTransaction().begin();
		this.em.remove(objeto);
		this.em.getTransaction().commit();				
		return true;
	}

	public T find(ID id) {
		return (T) this.em.find(clazz, id);
	}

	public List<T> findAll() {
		return this.em.createQuery("from "+ clazz.getName() ,clazz).getResultList();
	}

}