
package com.individualsRegister.exception;

/**
 * Exception class for Individual Register application
 * 
 * @author Raman Skaskevich
 * */
public class IndividualRegisterException extends RuntimeException
{
	private static final long serialVersionUID = -8560921680822814349L;

	protected final String statusCode;

	protected final String description;

	IndividualRegisterException()
	{
		super();
		this.statusCode = null;
		this.description = null;
	}

	IndividualRegisterException(String statusCode, String description)
	{
		this.statusCode = statusCode;
		this.description = description;
	}

	IndividualRegisterException(String statusCode, String description, Throwable cause)
	{
		super(cause);
		this.statusCode = statusCode;
		this.description = description;
	}

	public String getStatusCode()
	{
		return statusCode;
	}

	public String getDescription()
	{
		return description;
	}
}
