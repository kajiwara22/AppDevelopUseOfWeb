package demo;

import org.springframework.stereotype.Component;

@Component
public class AddCalculator implements Calculator {

	@Override
	public int calculate(int a, int b) {
		return a + b;
	}

}
