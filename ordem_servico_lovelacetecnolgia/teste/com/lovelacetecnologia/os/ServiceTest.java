package com.lovelacetecnologia.os;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ordem_servico_lovelacetecnolgia.service.LancamentoServico;
import ordem_servico_lovelacetecnolgia.servico.Servico;

public class ServiceTest {

	@Test
	public void testIncluir() {

		LancamentoServico lancamentoServico = new LancamentoServico();

		Servico servico = new Servico();
		
		int antes = lancamentoServico.listarTodos().size();
		lancamentoServico.incluir(servico);
		int depois = lancamentoServico.listarTodos().size();
	
		assertEquals(antes + 1, depois);
	}

	@Test
	public void testAlterar() {
	}

	@Test
	public void testBuscar() {
	
	
	}

	@Test
	public void testListarTodos() {
	}

	@Test
	public void testRemover() {
	}

}
