package com.cs544.labs.lab02.ex032;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cs544.labs.lab02.ex032.oneToManyBi.Department;
import com.cs544.labs.lab02.ex032.oneToManyBi.Employee;

public class App {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		org.hibernate.Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();

			// create two departments
			Department dep1 = new Department("Compro");
			Department dep2 = new Department("MBA");

			// add employees to the department
			dep1.addEmployee("Gideon Akomeng");
			dep2.addEmployee("Phil Jones");

			session.persist(dep1);
			session.persist(dep2);
			// commit save to write to disk
			trans.commit();

		} catch (Exception e) {
			if (trans.isActive()) {
				System.out.println("Error occured, Rolling back");
				System.out.println(e.getMessage());
				trans.rollback();
			}
		} finally {
			if (session.isOpen())
				session.close();
		}

		//print all employees
		printAllEmployees();
	}

	static void printAllEmployees() {
		/**
		 * Retrieve all saved Books from the database and display to the console
		 */
		Session session = null;
		Transaction trans = null;
		try {
			// open new session and begin transation
			session = sessionFactory.openSession();
			trans = session.beginTransaction();

			// query to retrieve books from db
			@SuppressWarnings("unchecked")
			List<Employee> emps = session.createQuery("from Employee").list();

			emps.forEach(emp -> System.out.println(emp));

		} catch (Exception e) {
			if (trans.isActive()) {
				System.out.println("Rolling back\n" + e.getMessage());
				trans.rollback();
			}
		} finally {
			if (session.isOpen())
				session.close();
		}
	}
}