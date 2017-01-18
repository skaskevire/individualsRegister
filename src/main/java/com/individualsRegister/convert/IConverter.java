
package com.individualsRegister.convert;

public interface IConverter<S, T>
{
	public T convert(S source);
}
