package br.com.estudandoemcasa;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController { 

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}

		Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
		return sum;

	}

	private Double convertDouble(String strNumber) { 
		String number = strNumber.replace(",", ".");
		if (isNumeric(number) && strNumber != null) {
			return Double.parseDouble(strNumber);
		}
		return 1D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); 
	}
}
