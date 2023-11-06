package com.example.dit;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Customer;

	public class LoanDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("mydb");

		public LoanDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeLoan(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(loan));
			em.getTransaction().commit();
			em.close();
		}
		
		public Loan merge(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Loan updatedLoan = em.merge(loan);
			em.getTransaction().commit();
			em.close();
			return updatedLoan;
		}
		
		
		public List<Loan> getAllLoans() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Loan> loan = new ArrayList<Loan>();
			loan = em.createQuery("from Loans").getResultList();
			em.getTransaction().commit();
			em.close();
			return Loans;
		}

		public Loan getLoanByName(String loanName) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee e = em.createQuery("SELECT p FROM Loan p WHERE p.loanName = :loanName", Loan.class)
	                .setParameter("loanName", loanName)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return e;
		}
		


	}
