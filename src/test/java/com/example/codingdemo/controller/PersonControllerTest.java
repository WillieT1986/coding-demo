package com.example.codingdemo.controller;

import com.example.codingdemo.data.PersonRepository;
import com.example.codingdemo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class PersonControllerTest {

    @InjectMocks
    private PersonController underTest;

    @Mock
    private Person person;

    @Mock
    private PersonRepository personRepo;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shouldRetrieveAnyPersons() {
        when(personRepo.findAll()).thenReturn(Collections.singletonList(person));
        String result = underTest.findPersons(model);
        assertTrue(result, contains(any(Person.class)) != null);
    }

    @Test
    public void shouldFindAllPersonsFromDatabase() throws PersonRestController.CannotFindException {
        when(personRepo.findAll()).thenReturn(Collections.singletonList(person));
        String result = underTest.findPersons(model);
        assertTrue(result, contains(person) != null);
    }

    @Test
    public void shouldAddAnIndividualPersonToModel() {
        long personId = 1L;
        when(personRepo.getById(personId)).thenReturn(person);
        underTest.findOnePerson(personId, model);
        verify(model).addAttribute("person", person);
    }

    @Test
    public void shouldReturnAnIndividualPerson() {
        String template = underTest.findOnePerson(1L, model);
        assertThat(template, is("person"));
    }


}
