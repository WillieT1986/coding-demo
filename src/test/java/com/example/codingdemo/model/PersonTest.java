package com.example.codingdemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {

    private final static String NAME = "William";
    private final static int AGE = 35;
    private final static String START_DATE = "yyyy/MM/dd";
    private final static String END_DATE = "yyyy/MM/dd";
    private final static Long QUOTATION_ID = 3L;
    private final static String CURRENCY_ID = "USD";
    private final static double TOTAL = 22.50;

    Person underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Person(NAME, AGE, START_DATE, END_DATE, QUOTATION_ID, CURRENCY_ID, TOTAL);
    }

//  This shows us the Person Class has been created.
    @Test
    public void shouldInstantiatePersonClass() {
        assertNotNull(underTest);
    }

//  This test shows that a Constructor has been created, and returns a String value for Name.
    @Test
    public void shouldConstructAPersonAndReturnAName() {
        String nameCheck = underTest.getName();
        assertEquals(nameCheck, NAME);
    }

//  This test returns an int value for Age.
    @Test
    public void shouldReturnAnAgeOfPerson() {
        int ageCheck = underTest.getAge();
        assertEquals(ageCheck, AGE);
    }

//  This test returns an ID of a created Person named Richard, age 27 with an ID of 2.
//  This is tested after the creation of the constructor, name & age variables since ID didn't exist yet.
    @Test
    public void shouldReturnAGeneratedIdForPerson() {
        underTest.setId(2L);
        underTest.setName("Richard");
        underTest.setAge(27);
        long idCheck = underTest.getId();
        assertEquals(idCheck, 2L);
    }

//    //  This test the String value for start_date & end_date.
    @Test
    public void shouldAddToConstructorAndReturnStartDateAndEndDate() {
        String start_date = underTest.getStart_date();
        String end_date =  underTest.getEnd_date();
        assertEquals(start_date, START_DATE);
        assertEquals(end_date, END_DATE);
    }

    @Test
    public void shouldAddToConstructorAndReturnQuotationIdAndCurrencyIdAndTotal() {
        Long quotation_id = underTest.getQuotation_Id();
        String currency_id = underTest.getCurrency_Id();
        double total = underTest.getTotal();
        assertEquals(quotation_id, QUOTATION_ID);
        assertEquals(currency_id, CURRENCY_ID);
        assertEquals(total, TOTAL);
    }

//    @Test
//    public void shouldPossiblyDoSomething() {
//
//    }

}
