package com.devsu.hackerearth.backend.client.model.dto;

public class PartialClientDto {
    private String dni;
    private String name;
    private String password;
    private String gender;
    private Integer age;       // Permite null
    private String address;
    private String phone;
    private Boolean isActive;  // Permite null

    // Constructor vacío
    public PartialClientDto() {
    }

    // Constructor con todos los atributos
    public PartialClientDto(String dni, String name, String password, String gender,
                            Integer age, String address, String phone, Boolean isActive) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
