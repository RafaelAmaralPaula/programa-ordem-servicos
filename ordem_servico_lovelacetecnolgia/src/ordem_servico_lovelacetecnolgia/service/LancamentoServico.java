package ordem_servico_lovelacetecnolgia.service;

import java.util.List;

import ordem_servico_lovelacetecnolgia.database.BancosDeDados;

import ordem_servico_lovelacetecnolgia.servico.Servico;

public class LancamentoServico implements Service {

	BancosDeDados bd = new BancosDeDados();
	String mensagem;

	@Override
	public void incluir(Servico servico) {
		bd.lista.add(servico);
	}

	@Override
	public void alterar(Servico serv) {

		for (Servico service : listarTodos()) {

			if (service.getId().equals(serv.getId())) {

				service.setNome(serv.getNome());
				service.setDescicao(serv.getDescicao());
				service.setStatus(service.getStatus());

				break;
			}

		}

	}

	@Override
	public Servico buscar(Integer id) {

		for (Servico servico : listarTodos()) {

			if (servico.getId().equals(id)) {

				return servico;
			}

		}

		System.out.println("Serviço Não Encontrado !");
		return null;
	}

	@Override
	public List<Servico> listarTodos() {
		return bd.lista;
	}

	@Override
	public String remover(Integer id) {

		Servico serv = buscar(id);

		if (serv != null) {
			bd.lista.remove(serv);

			if (!bd.lista.contains(serv)) {

				mensagem = "LIBERADO COM SUCESSO !";
				return mensagem;
			} else {
				mensagem = "FALHA NA LIBERAÇÃO DO SERVIÇO !";
				return mensagem;
			}

		}

		return null;
	}

}
