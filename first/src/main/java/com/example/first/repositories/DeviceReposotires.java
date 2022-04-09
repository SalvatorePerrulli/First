package com.example.first.repositories;

import com.example.first.domain.Devices;
import org.springframework.data.repository.CrudRepository;

public interface DeviceReposotires extends CrudRepository<Devices,Long> {


}
