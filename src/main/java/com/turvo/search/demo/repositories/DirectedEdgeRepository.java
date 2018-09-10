package com.turvo.search.demo.repositories;

import com.turvo.search.demo.model.entities.DirectedEdgeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectedEdgeRepository extends CrudRepository<DirectedEdgeEntity, Long> {
}
