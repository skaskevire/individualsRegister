package com.individualsRegister.service.entity;

import java.util.Date;

public class User
{
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String INNFLFIODR;
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

	public String getINNFLFIODR()
	{
		return INNFLFIODR;
	}

	public void setINNFLFIODR(String iNNFLFIODR)
	{
		INNFLFIODR = iNNFLFIODR;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
