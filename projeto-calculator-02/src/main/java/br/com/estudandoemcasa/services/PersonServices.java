package br.com.estudandoemcasa.services;

import br.com.estudandoemcasa.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Orange " + i);
        person.setLastName("Last Name " + i);
        person.setAdress("Adress " + i);
        person.setGender("Gender " + i);

        return person;
    }
}
