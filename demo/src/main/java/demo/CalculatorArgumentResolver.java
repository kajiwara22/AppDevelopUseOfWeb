package demo;

import java.io.InputStream;

public interface CalculatorArgumentResolver {
	CalculatorArgument resolve(InputStream stream);
}
