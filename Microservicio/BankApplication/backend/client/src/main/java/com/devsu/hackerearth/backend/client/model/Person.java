package com.devsu.hackerearth.backend.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Clase base para representar información personal genérica.
 * Esta clase no genera una tabla por sí misma,
 * pero sus campos se heredan en las entidades hijas (como Client).
 */
@MappedSuperclass
public abstract class Person extends Base {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20, unique = true, nullable = false)
    private String dni;

    @Column(length = 10)
    private String gender;

    private int age;

    @Column(length = 200)
    private String address;

    @Column(length = 20)
    private String phone;

    // --- Getters y Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
}
