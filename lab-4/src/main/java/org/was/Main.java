package org.was;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        ShapeDAO shapeDAO = new ShapeDAO(session);

        Logger logger = LoggerFactory.getLogger(Main.class);
        ShapeDescriber describer = new ShapeDescriber(logger);

        Rectangle rectangle = new Rectangle(new Color(255, 239, 0), 21, 37);
        Triangle triangle = new Triangle(new Color(21, 37, 21, 0.37), 4, 5, 6);

        describer.describe(rectangle);
        describer.describe(triangle);

        shapeDAO.save(rectangle);
        shapeDAO.save(triangle);

        shapeDAO.delete(rectangle);

        Shape dbTriangle = shapeDAO.findById(152L, Triangle.class);
        describer.describe(dbTriangle);
        dbTriangle.setColor(new Color(1, 2, 3));
        shapeDAO.update(triangle);
        describer.describe(shapeDAO.findById(152L, Triangle.class));
    }
}