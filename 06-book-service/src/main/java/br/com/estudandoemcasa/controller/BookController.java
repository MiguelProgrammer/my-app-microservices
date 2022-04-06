package br.com.estudandoemcasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudandoemcasa.model.Book;
import br.com.estudandoemcasa.proxy.CambioProxy;
import br.com.estudandoemcasa.repository.BookRepositoty;

@RestController
@RequestMapping("/book-service")
public class BookController {

	@Autowired
	private Environment enviroment;
	
	@Autowired
	private BookRepositoty bookRepository;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var book = bookRepository.getById(id); 
		
		if (book == null) {
			throw new RuntimeException("Corrency unsuported");
		} 
		
		var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = enviroment.getProperty("local.server.port");
		book.setEnviroment("Book port " + port + " Cambio port" + cambio.getEnviroment());
		book.setPrice(cambio.getConvertedValue());
		
		return book;
	}

}
