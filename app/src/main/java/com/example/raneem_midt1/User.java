package com.example.raneem_midt1;

public class User {
    String id,name,surname,nid;

    public User(String id, String name, String surname, String nid) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nid = nid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}
