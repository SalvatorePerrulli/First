package com.example.first.bootstrap;

import com.example.first.domain.Devices;
import com.example.first.domain.Peoples;
import com.example.first.repositories.DeviceReposotires;
import com.example.first.repositories.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PeopleRepository peopleRepository;
    private final DeviceReposotires deviceReposotires;

    public BootStrapData(PeopleRepository peopleRepository, DeviceReposotires deviceReposotires) {
        this.peopleRepository = peopleRepository;
        this.deviceReposotires = deviceReposotires;
    }

    @Override
    public void run(String... args) throws Exception {

        Peoples peoples1 = new Peoples("Salvo","Perrulli");
        Devices devices1 = new Devices("Telefono","192.168.1.2");
        peoples1.getListDevices().add(devices1);
        devices1.getListpeople().add(peoples1);

        peopleRepository.save(peoples1);
        deviceReposotires.save(devices1);

        Peoples peoples2 = new Peoples("Salvo","Perrulli");
        Devices devices2 = new Devices("Telefono","192.168.1.3");
        peoples2.getListDevices().add(devices2);
        devices2.getListpeople().add(peoples2);

        peopleRepository.save(peoples2);
        deviceReposotires.save(devices2);

        System.out.println("Started");
        System.out.println("number of device: "+deviceReposotires.count());
    }
}
