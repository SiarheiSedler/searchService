package com.turvo.search.demo.repositories;

import com.turvo.search.demo.model.entities.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {
}
