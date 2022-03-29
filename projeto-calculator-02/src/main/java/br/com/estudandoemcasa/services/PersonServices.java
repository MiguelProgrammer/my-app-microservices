package br.com.estudandoemcasa.services;

import br.com.estudandoemcasa.entity.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    /**
     * Simula ids do banco
     */
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Miguel");
        person.setFirstName("Pereira da Silva");
        person.setAdress("Taboão da Serra - SP");
        person.setGender("Male");

        return person;
    }
}
