package br.com.estudandoemcasa.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.estudandoemcasa.model.Book;
import br.com.estudandoemcasa.repository.BookRepositoty;
import br.com.estudandoemcasa.response.Cambio;

@RestController
@RequestMapping("/book-service")
public class BookController {

	@Autowired
	private Environment enviroment;
	
	@Autowired
	private BookRepositoty bookRepository;

	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var book = bookRepository.getById(id); 
		
		if (book == null) {
			throw new RuntimeException("Corrency unsuported");
		}
		
		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		
		var response = new RestTemplate().
			getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
					Cambio.class, params);
		
		var cambio = response.getBody();
		
		var port = enviroment.getProperty("local.server.port");
		book.setEnviroment(port);
		book.setPrice(cambio.getConvertedValue());
		
		return book;
	}
}
