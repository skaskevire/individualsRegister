
package com.individualsRegister.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.individualsRegister.dao.IDao;
import com.individualsRegister.dao.entity.UserDO;

/**
 * Implementation of {@IDao}
 * 
 * @author Raman_Skaskevich
 */
@Transactional
public class UserDao implements IDao<UserDO, Integer>
{
	private EntityManager entityManager;

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public void create(UserDO entity)
	{
		entityManager.persist(entity);
		
	}

	@Override
	public void update(UserDO entity)
	{
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(UserDO entity)
	{
		entityManager.remove(entityManager.contains(entity) ? entity
				: entityManager.merge(entity));
		
	}

	@Override
	public UserDO read(Integer id)
	{
		return entityManager.find(UserDO.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> readAll()
	{
		 Query query = entityManager.createQuery("SELECT e FROM " + "UserDO" + " e");
		    return (List<UserDO>) query.getResultList();
	}

	@Override
	public Integer tableSize()
	{
		
		Query query = entityManager.createQuery ("SELECT count(udo) FROM UserDO udo");
		
		return (Integer) query.getSingleResult ();
	}
	
	@Override
	public List<UserDO> getAllUsersIterable(int length, int offset)
	{		
		 return entityManager.createQuery("from UserDO m", UserDO.class).setFirstResult(offset).setMaxResults(length).getResultList();
	}	
}
