package net.d80harri.capoeira;

import net.d80harri.capoeira.entities.Exercise;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by d80harri on 31.08.16.
 */
public class Main {

    private static void withinSession(SessionFactory factory, Consumer<Session> consumer) {
        Session session = factory.openSession();
        try {
            consumer.accept(session);
        } finally {
            session.close();
        }
    }

    private static void withinTransaction(Session session, Runnable consumer) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            consumer.run();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SessionFactory sessionFactory = Utils.createSessionFactory();

        try {
            withinSession(sessionFactory, s -> {
                DataSetup setup = new DataSetup(new SimpleDao(s));
                withinTransaction(s, setup::setup);
            });
        } finally {
            sessionFactory.close();
        }
        long stop = System.currentTimeMillis();

        System.out.println(start - stop);
    }
}
