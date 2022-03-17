package com.example.codingdemo.controller;

import com.example.codingdemo.data.PersonRepository;
import com.example.codingdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
 * A list of origins for which cross-origin requests are allowed.
 * Values may be a specific domain, e.g. "https://domain1.com", or the CORS defined special value "*" for all origins.
 * For matched pre-flight and actual requests the Access-Control-Allow-Origin response header is set either to the matched domain value or to "*".
 * Keep in mind however that the CORS spec does not allow "*" when allowCredentials is set to true and as of 5.3 that combination is rejected in favor of using allowedOriginPatterns instead.
 * By default, this is not set which means that no origins are allowed. However, an instance of this class is often initialized further, e.g. for @CrossOrigin, via applyPermitDefaultValues().
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PersonRestController {

    @Autowired
    PersonRepository personRepo;

    /*    ** Person Model **    */

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person _person = personRepo.save(new Person(person.getName(), person.getAge(), person.getStart_date(),
                    person.getEnd_date(), person.getQuotation_Id(), person.getCurrency_Id(), person.getTotal()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String name) {
        try {
            List<Person> persons = new ArrayList<>();
            if (name == null)
                personRepo.findAll().forEach(persons::add);
            else
                personRepo.findPersonByName(name).forEach(persons::add);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        Optional<Person> personalData = personRepo.findById(id);
        if (personalData.isPresent()) {
            return new ResponseEntity<>(personalData.get(), HttpStatus.OK);
        } else {
            throw new CannotFindException("This Person Does Not Exist, Or Is Hidden To The World.");
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        Optional<Person> personalData = personRepo.findById(id);
        if (personalData.isPresent()) {
            Person _person = personalData.get();
            _person.setName(person.getName());
            _person.setAge(person.getAge());
            _person.setStart_date(person.getStart_date());
            _person.setEnd_date(person.getEnd_date());
            _person.setQuotation_Id((person.getQuotation_Id()));
            _person.setCurrency_Id((person.getCurrency_Id()));
            _person.setTotal(person.getTotal());
            return new ResponseEntity<>(personRepo.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
        try {
            personRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        try {
            personRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @RequestMapping("/persons")
//    public List<Person> findPersons() {
//        return personRepo.findAll();
//    }



    /*    ** Quotation Model **    */
    /*
     *
     * The tests for the Quotations most likely will not be needed. Leaving here for now since I was
     * playing around with trying to call upon specific, or all quotations by their quotation_id but...
     * Seems the program utilizes the auto generated Person ID to track them.
     *
     * One route I tried was creating a separate Quotation Class to store the quotation_id, currency_id,
     * as well as the total and oh, let's not forget the fixed rate and loads that have not been started
     * on yet either.
     *
     * However, when I tried to go that route I kept getting a 500 error for the /api/quotations but when I merged
     * them over into the Person Class it seems to work alright under Person. Not sure if this is the correct
     * way of doing things but one step at a time...
     *
     */

    /*
    @GetMapping("/quotations/{id}")
    public ResponseEntity<Person> getQuotationsById(@PathVariable("id") long quotation_id) {
        Optional<Person> personalData = personRepo.findById(quotation_id);
        if (personalData.isPresent()) {
            return new ResponseEntity<>(personalData.get(), HttpStatus.OK);
        } else {
            throw new CannotFindException("This Quote Does Not Exist Or Is Hidden To The World.");
        }
    }
    */

    /*
    @GetMapping("/quotations")
    public ResponseEntity<List<Person>> getAllQuotations(@RequestParam(required = false) String name) {
        try {
            List<Person> persons = new ArrayList<>();
            if (name == null)
                personRepo.findAll().forEach(persons::add);
            else
                personRepo.findPersonByName(name).forEach(persons::add);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/


    /*    ** Custom CannotFindException **    */

    @SuppressWarnings("serial")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class CannotFindException extends RuntimeException {
        private String message;

        public String getMessage() {
            return message;
        }

        CannotFindException(String errorMessage) {
            this.message = errorMessage;
        }
    }

}
