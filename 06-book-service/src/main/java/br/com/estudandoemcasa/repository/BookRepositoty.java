package br.com.estudandoemcasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudandoemcasa.model.Book;

public interface BookRepositoty extends JpaRepository<Book, Long> {

}
