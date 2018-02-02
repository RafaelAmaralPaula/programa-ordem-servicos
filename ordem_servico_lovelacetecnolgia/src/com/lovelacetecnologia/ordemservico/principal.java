package com.lovelacetecnologia.ordemservico;

import ordem_servico_lovelacetecnolgia.pessoa.ContratadorServico;
import ordem_servico_lovelacetecnolgia.pessoa.Pessoa;
import ordem_servico_lovelacetecnolgia.pessoa.ResponsavelPeloServico;

public class principal {

	public static void main(String[] args) {
		
		Pessoa p1 = new ContratadorServico();
		Pessoa p2 = new ResponsavelPeloServico();
		
		print(p2);
		
	}
	
	private static void print(Pessoa pessoa) {
		pessoa.print();
	}

}
