package com.example.dit;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Employee;

	public class CustomerDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("mydb");

		public CustomerDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(Customer customer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeCustomer(Customer customer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(employee));
			em.getTransaction().commit();
			em.close();
		}
		
		public Customer merge(Customer customer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee updatedCustomer = em.merge(employee);
			em.getTransaction().commit();
			em.close();
			return updatedCustomer;
		}
		
		
		public List<Customer> getAllCustomers() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Employee> customers = new ArrayList<Customer>();
			employees = em.createQuery("from Customers").getResultList();
			em.getTransaction().commit();
			em.close();
			return customers;
		}

		public Customer getCustomerByName(String customerName) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee e = em.createQuery("SELECT p FROM Customer p WHERE p.customerName = :customerName", Customer.class)
	                .setParameter("customerName", customerName)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return e;
		}
		


	}
