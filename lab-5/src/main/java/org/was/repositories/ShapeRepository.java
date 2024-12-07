package org.was.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.was.models.Shape;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {

}