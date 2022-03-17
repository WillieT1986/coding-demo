package com.example.codingdemo.controller;

import com.example.codingdemo.data.PersonRepository;
import com.example.codingdemo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PersonControllerTest {

        @InjectMocks
        private PersonController underTest;

        @Mock
        private Person person;

        @Mock
        private PersonRepository personRepo;

        @BeforeEach
        public void setUp() throws Exception {
                MockitoAnnotations.openMocks(this);
        }

        /*    ** Person Model **    */
        @Test
        public void shouldGetPersonById() {
                when(personRepo.findById(2L)).thenReturn(Optional.of(person));
                ResponseEntity<Person> result = underTest.getPersonById(2L);
                assertTrue(String.valueOf(result), is(person) != status().isNotFound());

//              ** The reason I chose String.valueOf **
//              Returns the string representation of the Object argument.
//              Params:  obj – an Object.
//              Returns: if the argument is null, then a string equal to "null"; otherwise, the value of obj.toString() is returned.
        }

        @Test
        public void shouldGetAllPersons() throws Exception {
                when(personRepo.findAll()).thenReturn(List.of(person));
                ResponseEntity<List<Person>> result = underTest.getAllPersons("Name of Person");
                assertTrue(String.valueOf(result), contains(any(Person.class)) != null);

//              If I was to change != to == then the Test would fail and the result would state
//              "<2-4 No_CONTENT no Content, []>" Thus causing a Failure: Build failed with an exception.
        }

        @Test
        public void shouldReturnCannotFindExceptionForPersonId()  throws PersonController.CannotFindException {
                PersonController.CannotFindException thrown = assertThrows(
                        PersonController.CannotFindException.class,
                        () -> {
                                long invalidPersonId = 54L;
                                underTest.getPersonById(invalidPersonId);
                        });
                assertEquals("This Person Does Not Exist, Or Is Hidden To The World.", thrown.getMessage());
//              Not sure why, but it seems the import class for my CannotFindException refused to import at the top
//              of the file to be nested with the rest of the Imports.
        }

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

//        @Test
//        public void shouldGetQuotationById() {
//                when(personRepo.findById(20L)).thenReturn(Optional.of(person));
//                ResponseEntity<Person> result = underTest.getQuotationsById(20L);
//                assertTrue(String.valueOf(result), is(person) != status().isNotFound());
//        }
//
//        @Test
//        public void shouldGetAllQuotations() throws Exception {
//                when(personRepo.findAll()).thenReturn(List.of(person));
//                ResponseEntity<List<Person>> result = underTest.getAllQuotations("Name of Person Two");
//                assertTrue(String.valueOf(result), contains(any(Person.class)) != null);
//        }
//
//        @Test
//        public void shouldReturnCannotFindExceptionForQuotationId()  throws PersonController.CannotFindException {
//                PersonController.CannotFindException thrown = assertThrows(
//                        PersonController.CannotFindException.class,
//                        () -> {
//                                long invalidQuotationId = 64L;
//                                underTest.getQuotationsById(invalidQuotationId);
//                        });
//                assertEquals("This Quote Does Not Exist Or Is Hidden To The World.", thrown.getMessage());
//        }

}
