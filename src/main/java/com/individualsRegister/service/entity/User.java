package com.individualsRegister.service.entity;

import java.util.Date;

public class User
{
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fnsId;
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

	public String getFnsId()
	{
		return fnsId;
	}

	public void setFnsId(String fnsId)
	{
		this.fnsId = fnsId;
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
}
