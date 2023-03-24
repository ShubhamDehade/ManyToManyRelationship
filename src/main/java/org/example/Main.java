package org.example;

import bean.Laptop;
import bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Laptop.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();
        Transaction tx=ses.beginTransaction();

        Student s1=new Student();
        s1.setsName("shubham");
        s1.setsMarks(87);
        Student s2=new Student();
        s2.setsName("lokesh");
        s2.setsMarks(89);


        Laptop l1=new Laptop();
        l1.setlName("lenovo");
        l1.addStudents(s1);
        l1.addStudents(s2);



       ses.save(s1);
       ses.save(s2);
        ses.save(l1);

       tx.commit();
    }
}