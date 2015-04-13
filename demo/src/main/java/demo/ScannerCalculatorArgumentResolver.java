package demo;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerCalculatorArgumentResolver implements
		CalculatorArgumentResolver {

	@Override
	public CalculatorArgument resolve(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		return new CalculatorArgument(a,b);
	}

}
