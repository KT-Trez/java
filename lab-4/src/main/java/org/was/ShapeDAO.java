package org.was;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShapeDAO {
    Session session;

    ShapeDAO(Session session) {
        this.session = session;
    }

    public void delete(Shape shape) {
        Transaction transaction = session.beginTransaction();
        session.remove(shape);
        transaction.commit();
    }

    public Shape findById(Long id, Class<? extends Shape> shape) {
        return session.find(shape, id);
    }

    public void save(Shape shape) {
        Transaction transaction = session.beginTransaction();
        session.persist(shape);
        transaction.commit();
    }

    public void update(Shape shape) {
        Transaction transaction = session.beginTransaction();
        session.merge(shape);
        transaction.commit();
    }
}
