package br.com.estudandoemcasa.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudandoemcasa.model.Cambio;
import br.com.estudandoemcasa.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio endpoint")
@RestController
@RequestMapping("/cambio-service")
public class CambioController {
	
	@Autowired
	private Environment enviroment;
	
	@Autowired
	private CambioRepository cambioRepository;

	@Operation(description = "Get Cambio for currency.")
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, 
			@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		var cambio = cambioRepository.findByFromAndTo(from, to);
		
		if(cambio == null) {
			throw new RuntimeException("Corrency unsuported");
		}

		var port = enviroment.getProperty("local.server.port");
		BigDecimal conversionFactor = cambio.getConversionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(amount);
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		cambio.setEnviroment(port);
		
		return cambio;
	}
}
