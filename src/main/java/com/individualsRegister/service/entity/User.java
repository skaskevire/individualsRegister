package com.individualsRegister.service.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.individualsRegister.util.DateDeserializer;
import com.individualsRegister.util.DateSerializer;



public class User
{
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fnsId;
	private String fnsidRequestId;


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
	
	 public String getFnsidRequestId()
	{
		return fnsidRequestId;
	}

	public void setFnsidRequestId(String fnsidRequestId)
	{
		this.fnsidRequestId = fnsidRequestId;
	}
}
