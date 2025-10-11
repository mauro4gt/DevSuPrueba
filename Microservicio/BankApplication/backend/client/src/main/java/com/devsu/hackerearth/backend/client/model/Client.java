package com.devsu.hackerearth.backend.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Person {
    @Column(length = 50, nullable = false, unique = true)
    private String clientKey;

    @Column(nullable = false)
    private boolean isActive;

    // Getters y Setters
    public String getClientKey() { return clientKey; }
    public void setClientKey(String clientKey) { this.clientKey = clientKey; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }
}
