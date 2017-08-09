package br.com.caelum.financas;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;

public class TesteContaCliente {
	public static void main() {
		Cliente cliente = new Cliente();
		cliente.setEndereco("Rua jose, 123");
		cliente.setNome("Marcos antonio");
		cliente.setProfissao("Analista");
		
		Conta conta = new Conta();
		conta.setId(2);
		
	}
}
