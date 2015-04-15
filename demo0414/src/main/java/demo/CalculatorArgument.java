package demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CalculatorArgument {
	private final int a;
	private final int b;
}
