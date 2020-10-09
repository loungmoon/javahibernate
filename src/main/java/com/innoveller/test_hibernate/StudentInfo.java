package com.innoveller.test_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class StudentInfo {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addStudent(String name,String rollno,String phoneno,String email){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student person = new Student(name,rollno,phoneno,email);
            session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void listStudents( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.println("ID :"+ student.getId());
                System.out.print("Name: " + student.getName());
                System.out.print(" RollNo: " + student.getRollNo());
                System.out.println("  PhoneNo: " + student.getPhoneNo());
                System.out.println("Email"+student.getEmail());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateStudent(Integer StudentID,String name,String rollNo,String phoneNo, String email ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, StudentID);
            student.setName(name);
            student.setRollNo(rollNo);
            student.setPhoneNo(phoneNo);
            student.setEmail(email);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void deleteStudent(Integer StudentID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, StudentID);
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
