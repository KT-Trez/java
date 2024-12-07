package org.was.controllers;

import org.springframework.web.bind.annotation.*;
import org.was.models.Shape;
import org.was.services.ShapeService;

import java.util.List;

@RestController
@RequestMapping("/v1/shapes")
public class ShapeController {
    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @PostMapping
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.saveShape(shape);
    }

    @GetMapping
    public List<Shape> getAllShapes() {
        return shapeService.getAllShapes();
    }
}
