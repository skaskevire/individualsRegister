package com.individualsRegister.dao.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User dao layer entity
 * 
 * @author Raman Skaskevich
 * */
@Entity
public class UserDO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "inn")
	private String inn;
	@Column(name = "birthDate")
	private Date birthDate;
	@Column(name = "innRequestId")
	private BigInteger innRequestId;
	public BigInteger getInnRequestId()
	{
		return innRequestId;
	}
	public void setInnRequestId(BigInteger innRequestId)
	{
		this.innRequestId = innRequestId;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
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
	
	
}
