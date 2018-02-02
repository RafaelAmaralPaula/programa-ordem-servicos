package ordem_servico_lovelacetecnolgia.service;

import java.util.List;

import ordem_servico_lovelacetecnolgia.servico.Servico;

public interface Service {

	public void incluir(Servico servico);

	public void alterar(Servico serv);

	public Servico buscar(Integer id);

	public List<Servico> listarTodos();

	public String remover(Integer id);

}
