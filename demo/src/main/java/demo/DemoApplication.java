package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	ScannerCalculatorArgumentResolver scannerCalculatorArgumentResolver;

	@Autowired
	AddCalculator addCalculator;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		System.out.print("Enter 2 number like 'a b' : ");
		CalculatorArgument argument = scannerCalculatorArgumentResolver.resolve(System.in);
		int result = addCalculator.calculate(argument.getA(), argument.getB());
		System.out.println("result = " + result);

	}
}
