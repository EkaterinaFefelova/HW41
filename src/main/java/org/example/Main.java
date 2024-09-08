package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        //Car car = session.get (Car.class, 2);
        List<Car> cars = session.createQuery("select c from Car as c").getResultList();
        List<Instructor> instructors = session.createQuery("select i from Instructor as i").getResultList();
        List<Student> students = session.createQuery("select s from Student as s").getResultList();
        System.out.println("---Список машин---");
        cars.forEach(System.out::println);
        System.out.println("---Список инструкторов---");
        instructors.forEach(System.out::println);
        System.out.println("---Список учеников---");
        students.forEach(System.out::println);
        session.close();
    }
}
