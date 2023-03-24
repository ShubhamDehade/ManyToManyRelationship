package org.example;

import bean.Laptop;
import bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save2 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Laptop.class);
        SessionFactory factory= cfg.buildSessionFactory();
        Session ses= factory.openSession();
        Transaction tx=ses.beginTransaction();

        Laptop l1=new Laptop();
        l1.setlName("DELL");

        Laptop l2=new Laptop();
        l2.setlName("ASUS");

        Student s1=new Student();
        s1.setsName("samrat");
        s1.setsMarks(90);
        s1.addLaptops(l1);
        s1.addLaptops(l2);

        Student s2=new Student();
        s2.setsName("aditya");
        s2.setsMarks(92);
        s2.addLaptops(l1);
        s2.addLaptops(l2);

        Student s3=new Student();
        s3.setsName("viki");
        s3.setsMarks(89);
        s3.addLaptops(l1);
        s3.addLaptops(l2);


        ses.save(l1);
        ses.save(l2);
        ses.save(s1);
        ses.save(s2);
        ses.save(s3);
        tx.commit();
    }
}
