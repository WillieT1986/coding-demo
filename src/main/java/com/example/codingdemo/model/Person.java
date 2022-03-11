package com.example.codingdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "start_date")
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "quotation_id")
    private Long quotation_id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "currency_id")
    private String currency_id;

    @Column(name = "total")
    private double total;

    /* Constructors */

    public Person() {
        /*
        * This constructor remains empty due to applying @Entity to Person.
        * Otherwise, without a default public, protected no-arg constructor the program will throw an error.
        * However, the program can still run without it but the IDE will show you red error marks.
        */
    }

    public Person(String name, int age, String start_date, String end_date, Long quotation_id, String currency_id, double total) {
        this.name = name;
        this.age = age;
        this.start_date = start_date;
        this.end_date = end_date;
        this.quotation_id = quotation_id;
        this.currency_id = currency_id;
        this.total = total;
    }

    /* Getters */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public Long getQuotation_Id() {
        return quotation_id;
    }

    public String getCurrency_Id() {
        return currency_id;
    }

    public double getTotal() {
        return total;
    }

    /* Setters */

    public void setQuotation_Id(Long quotation_id) {
        this.quotation_id = quotation_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrency_Id(String currency_id) {
        this.currency_id = currency_id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//  Returns a String object representing this Long's value.
//  The value is converted to signed decimal representation and returned as a string,
//  exactly as if the long value were given as an argument to the toString(long) method.
//  Returns: a string representation of the value of this object in base 10.
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", start_date=" + start_date +
                ", end_date=" + end_date + ", quotation_id=" + id + ", getCurrency_Id=" + currency_id + ", total=" + total + "]";
    }

//  Returns a hash code for this Long.
//  The result is the exclusive OR of the two halves of the primitive long value held by this Long object.
//  That is, the hashcode is the value of the expression:
    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }

//  Compares this object to the specified object.
//  The result is true if and only if the argument is not null and is a Long object that contains the same long value as this object.
//  Params: obj – the object to compare with.
//  Returns: true if the objects are the same; false otherwise.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Person) obj).id;
    }

}
