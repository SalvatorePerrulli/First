package com.example.first.repositories;

import com.example.first.domain.Peoples;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<Peoples,Long> {


}
