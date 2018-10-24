package com.demo.landlordpractise.models;

import java.io.Serializable;

public class Landlord implements Serializable{
    public int id;
    public String name;
    public String secretIdentity;

    public Landlord() {
    }

    public Landlord(String name, String secretIdentity) {
        this.name = name;
        this.secretIdentity = secretIdentity;
    }

    public String getName() {
        return name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public int getId(){
        return id;
    }
}
