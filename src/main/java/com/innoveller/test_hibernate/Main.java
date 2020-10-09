package com.innoveller.test_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentInfo info = new StudentInfo();
        info.addStudent("Hein","2","09338833","aaa@gmail.com");
        info.deleteStudent(1);
        info.updateStudent(2,"loung","2","0983993004","abc@gmail.com");
        info.listStudents();
    }
}
