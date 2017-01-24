
package com.individualsRegister.convert;

/**
 * Converter interface
 * 
 * @author Raman Skaskevich
 * */
public interface IConverter<S, T>
{
	public T convert(S source);
}
