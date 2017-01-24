package com.individualsRegister.exception;

/**
 * Enum with individual register exceptions
 * 
 * @author Raman Skaskevich
 * */
public enum IndividualRegisterExceptionEnum
{
	UNEXPECTED_ERROR("0", "Unexpected error"),
	INVALID_DATE_FORMAT("2", "Invalid date format"),
	INNFLFIODR_REQUEST_FAILED("1", "INNFLFIODR request failed with code %s");
	private String descriptionPattern;
	private String errorCode;
	private IndividualRegisterExceptionEnum(String errorCode, String desc)
	{
		this.descriptionPattern = desc;
		this.errorCode = errorCode;

	}
	public String getDescriptionPattern()
	{
		return this.descriptionPattern;
	}
	public String getErrorCode()
	{
		return this.errorCode;
	}
	

	public void raise(Object... descriptionPatternArgs)
	{
		throw new IndividualRegisterException(errorCode, String.format(descriptionPattern, descriptionPatternArgs));
	}


	public void raise(Throwable cause)
	{
		throw new IndividualRegisterException(errorCode, descriptionPattern, cause);
	}
	
}
