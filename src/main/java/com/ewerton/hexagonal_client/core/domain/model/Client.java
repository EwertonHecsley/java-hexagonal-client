package com.ewerton.hexagonal_client.core.domain.model;

public class Client {
    private String id;
    private String name;
    private String email;

    public Client(String name, String email, String id) {
        this.updateName(name);
        this.updateEmail(email);
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void updateName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank or empty");
        }

        this.name = name;
    }

    public void updateEmail(String email) {
        if (email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be blank or empty");
        }

        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }
}
