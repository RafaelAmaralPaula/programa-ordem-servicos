package ordem_servico_lovelacetecnolgia.servico;

public class Servico {
	
	private Integer id;
	private String status;
	private String descicao;
	private String nome;
	private Float  preço;

	
	
	public Float getPreço() {
		return preço;
	}

	public void setPreço(Float preço) {
		this.preço = preço;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
