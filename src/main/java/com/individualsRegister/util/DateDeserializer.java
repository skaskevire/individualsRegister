package com.individualsRegister.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.individualsRegister.exception.IndividualRegisterExceptionEnum;

public class DateDeserializer extends JsonDeserializer<Date>
{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private static final Logger LOGGER = LoggerFactory.getLogger(DateDeserializer.class);


	@Override
	public Date deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException
	{		
		try
		{
			return dateFormat.parse(arg0.getValueAsString());
		}
		catch (ParseException e)
		{
			LOGGER.error(e.getMessage(),e);
			IndividualRegisterExceptionEnum.INVALID_DATE_FORMAT.raise(e);
		}
		
		return null;
	}
}