package org.quarkus;

import org.hibernate.annotations.Target;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/person")
    @Transactional
    public void addPerson(Person person){
        Person.persist(person);
    }

    @GetMapping("/persons")
    public List<Person> getPeople(){
       return Person.listAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") long id){
        return Person.findById(id);
    }

    /*@DeleteMapping("/person/{id}")
    @Transactional
    public void deletePerson(@PathVariable("id") long id){
        Person.deleteById(id);
    }*/

    @DeleteMapping("/person/{id}")
    @Transactional
    public void deletePerson(@PathVariable("id") long id){
        Person.delete("id",id);
    }

    //getPersonByFirstName

    @GetMapping("/person/name/{firstName}")
    public List<Person> getPersonByFirstName(@PathVariable("firstName") String firstName){
        return Person.getPersonByFirstName(firstName);
    }

    @GetMapping("/person/name/{firstName}/{lastName}")
    public List<Person> getPersonByFirstNameAndLastName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        return Person.getPersonByFirstNameAndLastName(firstName,lastName);
    }




}
