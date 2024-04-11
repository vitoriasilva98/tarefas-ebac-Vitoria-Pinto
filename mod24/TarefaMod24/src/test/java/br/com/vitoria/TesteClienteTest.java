package br.com.vitoria;

import org.junit.Assert;
import org.junit.Test;


public class TesteClienteTest {

	@Test
	public void testeClasseCliente() {
		TesteCliente cli = new TesteCliente();
		cli.adicionarNome("Vitória");
		cli.adicionarNome1("Vitória");

		Assert.assertEquals("Vitória", cli.getNome());
	}
}
