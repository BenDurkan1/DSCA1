package com.example.dit;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Customer;

	public class DepositDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("mydb");

		public LoanDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(Deposit deposit) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeDeposit(Deposit deposit) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(loan));
			em.getTransaction().commit();
			em.close();
		}
		
		public Loan merge(Deposit deposit) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Deposit updatedDeposit = em.merge(deposit);
			em.getTransaction().commit();
			em.close();
			return updatedDeposit;
		}
		
		
		public List<Deposit> getAllDeposits() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Deposit> deposit = new ArrayList<deposit>();
			loan = em.createQuery("from Deposit").getResultList();
			em.getTransaction().commit();
			em.close();
			return Deposits;
		}

		public Loan getDepositByName(String depositName) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Deposit e = em.createQuery("SELECT p FROM Deposi p WHERE p.depositName = :depositName", Deposit.class)
	                .setParameter("depositName", depositName)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return e;
		}
		


	}
