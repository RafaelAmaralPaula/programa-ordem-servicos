package ordem_servico_lovelacetecnolgia.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorEmail {

	private String mensagem;
	private String assunto;
	private String para;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	
	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	
	public void eviarEmail(String mensagem, String assunto, String para) throws EmailException {
		

		Email email = new SimpleEmail();

		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(" rafaelpachecoipda@gmail.com ", "mapa12345"));
		email.setSSLOnConnect(true);
		email.setFrom("rafael@lovelacetecnologia.com");
		email.setSubject(assunto);
		email.setMsg(mensagem);
		email.addTo(para);
		email.send();

		
		
	}

}
