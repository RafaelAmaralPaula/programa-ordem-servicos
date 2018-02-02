package ordem_servico_lovelacetecnolgia.pessoa;

public class ContratadorServico extends Pessoa {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void print() {
		System.out.println("Sou ContratadorServico");
	}

}
