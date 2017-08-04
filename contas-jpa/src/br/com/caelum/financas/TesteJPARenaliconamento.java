package br.com.caelum.financas;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARenaliconamento {
	public static void main(String[] args) {
		Conta conta  = new Conta();
		conta.setAgencia("12300");
		conta.setBanco("itau");
		conta.setNumero("0077");
		conta.setTitular("eduardo cunha");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.00"));
		movimentacao.setConta(conta);
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();

		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
