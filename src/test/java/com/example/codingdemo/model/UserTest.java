package com.example.codingdemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    User underTest;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void shouldInstantiateUser() {
        assertNotNull(underTest);
    }

}
