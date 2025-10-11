package com.devsu.hackerearth.backend.client.model.dto;

public class ClientDto {
    private Long id;
    private String dni;
    private String name;
    private String password;
    private String gender;
    private int age;
    private String address;
    private String phone;
    private boolean isActive;

    // Constructor vacío
    public ClientDto() {
    }

    // Constructor con todos los atributos
    public ClientDto(Long id, String dni, String name, String password, String gender,
                     int age, String address, String phone, boolean isActive) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
