package com.example.first.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Devices {

    @Id @GeneratedValue(generator="system-uuid")
    private String id;

    private String name;
    private String ip;

    @ManyToMany
    @JoinTable(name = "people_device", joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    private Set<Peoples> listpeople = new HashSet<>();

    public Devices() {
    }

    public Devices(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }
    /*
    public Devices(String id, String name, String ip, Set<Peoples> listpeople) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.listpeople = listpeople;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Set<Peoples> getListpeople() {
        return listpeople;
    }

    public void setListpeople(Set<Peoples> listpeople) {
        this.listpeople = listpeople;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", listpeople=" + listpeople +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Devices devices = (Devices) o;

        return id != null ? id.equals(devices.id) : devices.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
