package com.dot.scheduling.dto;


public class PersonDTO{

    private String name;
    private int age;
    private String phone;
    private String address;
    private String email;

    public PersonDTO() {}

    public PersonDTO(String name, int age, String phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }







}
