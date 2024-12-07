package org.was.services;

import org.springframework.stereotype.Service;
import org.was.models.Shape;
import org.was.repositories.ShapeRepository;

import java.util.List;

@Service
public class ShapeService {
    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }

    public Shape saveShape(Shape shape) {
        return shapeRepository.save(shape);
    }
}
