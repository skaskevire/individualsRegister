package com.individualsRegister.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date>
{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException
	{
		String formattedDate = dateFormat.format(date);
		jsonGenerator.writeString(formattedDate);		
	}

}
