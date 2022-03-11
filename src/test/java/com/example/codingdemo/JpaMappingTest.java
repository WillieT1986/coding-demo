package com.example.codingdemo;

import com.example.codingdemo.data.PersonRepository;
import com.example.codingdemo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private PersonRepository personRepo;

    private final static String NAME = "William";
    private final static int AGE = 35;
    private final static String START_DATE = "yyyy/MM/dd";
    private final static String END_DATE = "yyyy/MM/dd";
    private final static Long QUOTATION_ID = 3L;
    private final static String CURRENCY_ID = "USD";
    private final static double TOTAL = 22.50;

    Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(NAME, AGE, START_DATE, END_DATE, QUOTATION_ID, CURRENCY_ID, TOTAL);
    }

    @Test
    public void shouldSaveAndLoadPerson() {
        person = personRepo.save(person);
        long personId = person.getId();

        entityManager.flush();
        entityManager.clear();

        person = personRepo.getById(personId);
        assertThat(person.getName(), is(NAME));
    }

     /*
       * These types of tests are usually done mapping multiple relations together.
       * For example,  One to One, Many to One, One to Many, Many to Many.
     */

}
