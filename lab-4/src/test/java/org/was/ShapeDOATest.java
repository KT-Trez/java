package org.was;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDOATest {
    private Session session;
    private SessionFactory sessionFactory;
    private ShapeDAO shapeDAO;

    @AfterEach
    public void afterEach() {
        session.close();
        sessionFactory.close();
    }

    @BeforeEach
    public void beforeEach() {
        sessionFactory = new Configuration()
                .configure("hibernate.test.cfg.xml")
                .buildSessionFactory();
        session = sessionFactory.openSession();

        shapeDAO = new ShapeDAO(session);
    }

    @Test
    public void itShouldDeleteShape() {
        Rectangle shape = new Rectangle();
        session.persist(shape);

        // when
        shapeDAO.delete(shape);

        // then
        assertNull(session.find(Rectangle.class, shape.id));
    }

    @Test
    public void itShouldFindShapeById() {
        Rectangle shape = new Rectangle();
        session.persist(shape);

        // when
        Shape foundShape = shapeDAO.findById(shape.id, Rectangle.class);

        // then
        assertEquals(shape, foundShape);
    }

    @Test
    public void itShouldReturnNullWhenIdIsInvalid() {
        // when
        Shape foundShape = shapeDAO.findById(2137L, Rectangle.class);

        // then
        assertNull(foundShape);
    }

    @Test
    public void itShouldSaveShape() {
        Rectangle shape = new Rectangle();

        // when
        shapeDAO.save(shape);

        // then
        assertNotNull(shapeDAO.findById(shape.id, Rectangle.class));
    }

    @Test
    public void itShouldUpdateShape() {
        Shape shape = new Rectangle();
        session.persist(shape);

        // when
        shape.setColor(new Color(1, 2, 3));
        shapeDAO.update(shape);

        // then
        assertEquals(session.get(Rectangle.class, shape.id), shape);
    }
}