package br.com.caelum.financas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteContasEstadosEntityManager {
	public static void main(String[] args) {
		Conta conta = new Conta();
        conta.setTitular("kaka");
        conta.setBanco("HSBC");
        conta.setNumero("1237778");
        conta.setAgencia("4444");
        
        
        //Acabei de criar a conta - Transient
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		//o médodo persist transformou a conta em Managed
		
		em.getTransaction().commit();
		
		em.close();
		
		//conta passou para o estado deteched, pois o entityManager foi fechado.
		
		EntityManager em2 = emf.createEntityManager();
		
		em2.getTransaction().begin();
		
		conta.setTitular("claudio");
		
		/*Não posso persistir, pois a conta está em estado deteched, preciso fazer um merge.
		 * em2.persist(conta);
		 */
		
		em2.merge(conta);
		
		//o médodo merge transformou a conta em Managed novamente
		
		em2.getTransaction().commit();
		
		em2.close();
		emf.close();
	}
}
