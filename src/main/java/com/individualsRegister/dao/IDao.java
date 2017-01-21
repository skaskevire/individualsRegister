package com.individualsRegister.dao;

import java.util.List;


import com.individualsRegister.dao.entity.UserDO;

/**
 * Dao interface
 * 
 * @author Raman_Skaskevich@epam.com	
 * */

public interface IDao<T, K> {
	/**
	 * 
	 * creates entity
	 * 
	 * @param T entity
	 * 
	 * */
	void create(T entity);
	
	/**
	 * 
	 * updates entity
	 * 
	 * @param T entity
	 * 
	 * */
	void update(T entity);

	/**
	 * 
	 * removes entity
	 * 
	 * @param T entity
	 * 
	 * */
	void delete(T entity);

	/**
	 * 
	 * reads entity
	 * 
	 * @return T entity
	 * 
	 * */
	T read(K id);
	
	/**
	 * 
	 * reads all entities
	 * 
	 * @return T entity
	 * 
	 * */
	List<T> readAll();
	
	
	Integer tableSize();
	
	List<UserDO> getAllUsersIterable(int length, int offset);
}
