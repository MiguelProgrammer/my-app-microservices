package br.com.estudandoemcasa;

import br.com.estudandoemcasa.entity.Calculator;
import br.com.estudandoemcasa.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	Calculator calculator = new Calculator();

	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result sum
	 */
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.sum(calculator.getNumberOne(), calculator.getNumberTwo());
	}

	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result times
	 */
	@RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double times(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.times(calculator.getNumberOne(), calculator.getNumberTwo());
	}

	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result subtraction
	 */
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.substraction(calculator.getNumberOne(), calculator.getNumberTwo());
	}

	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result division
	 */
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.division(calculator.getNumberOne(), calculator.getNumberTwo());
	}


	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result media
	 */
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.media(calculator.getNumberOne(), calculator.getNumberTwo());
	}

	/**
	 *
	 * @param numberOne
	 * @param numberTwo
	 * @return result squareRoot
	 */
	@RequestMapping(value = "/square/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public String squareRoot(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

		calculator.setNumberOne(numberOne);
		calculator.setNumberTwo(numberTwo);
		return calculator.squareRoot(calculator.getNumberOne(), calculator.getNumberTwo());
	}

}
