package br.com.caelum.financas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteContasRemove {
	public static void main(String[] args) {
		Conta conta = new Conta();
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//neste momento a conta está detached, pois é apenas uma nova instancia da conta, porém não foi persistida no banco.
		
		conta = em.find(Conta.class, 9);
		
		//neste momento a conta passa a ser managed e é possível remove-la.
		
		em.remove(conta);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}
