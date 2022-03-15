package com.example.codingdemo.controller;

import com.example.codingdemo.data.PersonRepository;
import com.example.codingdemo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonRestController.class)
public class PersonMvcTest {

    @Resource
    MockMvc mvc;

    @MockBean
    private PersonRepository personRepo;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shouldRetrievePersons() throws Exception {
        /*
         * Normally, how I would test did not work originally I had planned.
         *
         * First time I used the MockMvcResultHandler but glad it is there because:
         * Print MvcResult details to the "standard" output stream.
         *
         * The way I usually test this is by simply writing out mvc.perform(get("/persons")).andExpect(status().isOk());
         *
         * However, this time around a Http 204 would be thrown. After spending a few hours today 3/11/2022 - I got it!
         *
         * */

        Person william = new Person("William", 35, "", "", null, "", 0.00);
        Person richard = new Person("Richard", 27, "", "", null, "", 0.00);
        when(personRepo.findAll()).thenReturn(Arrays.asList(william, richard));
        mvc.perform(get("/persons")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    @Test
    public void shouldGetAnIndividualPerson() throws Exception {
        Person william = new Person("William", 35, "", "", null, "", 0.00);
        when(personRepo.findById(1L)).thenReturn(Optional.of(william));
        mvc.perform(get("/persons/1")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    @Test
    public void shouldNotFindPersonId() throws Exception {
        mvc.perform(get("/persons/6")).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
    }

}
