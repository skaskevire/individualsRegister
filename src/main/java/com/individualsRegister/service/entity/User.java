package com.individualsRegister.service.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.individualsRegister.util.DateDeserializer;
import com.individualsRegister.util.DateSerializer;

/**
 * User entity
 * 
 * @author Raman Skaskevich
 * */
public class User
{
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String inn;
	private String innRequestId;
	@JsonSerialize(using = DateSerializer.class)
	 @JsonDeserialize(using = DateDeserializer.class)
	private Date birthDate;

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getInn()
	{
		return inn;
	}

	public void setInn(String inn)
	{
		this.inn = inn;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	 public String getInnRequestId()
	{
		return innRequestId;
	}

	public void setInnRequestId(String innRequestId)
	{
		this.innRequestId = innRequestId;
	}
}
