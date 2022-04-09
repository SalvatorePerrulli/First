package com.example.first.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Peoples {

    @Id @GeneratedValue(generator="system-uuid")
    private String id;

    private String name;
    private String lastname;

    @ManyToMany
    @JoinTable(name = "people_device", joinColumns = @JoinColumn(name = "people_id"),
                inverseJoinColumns = @JoinColumn(name = "device_id"))
    private Set<Devices> listDevices = new HashSet<>();

    public Peoples() {
    }

    public Peoples(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    /*
    public Peoples(String id, String name, String lastname, Set<Devices> listDevices) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.listDevices = listDevices;
    }
    */
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Devices> getListDevices() {
        return listDevices;
    }

    public void setListDevices(Set<Devices> listDevices) {
        this.listDevices = listDevices;
    }

    @Override
    public String toString() {
        return "Peoples{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", listDevices=" + listDevices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peoples peoples = (Peoples) o;

        return id != null ? id.equals(peoples.id) : peoples.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
