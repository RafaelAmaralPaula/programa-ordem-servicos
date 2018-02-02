package com.lovelacetecnologia.ordemservico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.mail.EmailException;

import ordem_servico_lovelacetecnolgia.email.EnviadorEmail;
import ordem_servico_lovelacetecnolgia.login.Login;
import ordem_servico_lovelacetecnolgia.pessoa.ContratadorServico;
import ordem_servico_lovelacetecnolgia.pessoa.ResponsavelPeloServico;
import ordem_servico_lovelacetecnolgia.service.Service;
import ordem_servico_lovelacetecnolgia.service.LancamentoServico;
import ordem_servico_lovelacetecnolgia.servico.Servico;

/**
 * Programa que tem como objetivo fazer gerenciamento de tarefas
 * @author Rafael Amaral De Paula
 */
public class Main {
	
	/**
	 * 
	 * @param args - É onde é passado email para metódo realizar envio
	 * @throws EmailException - Email não é informado
	 * @deprecated Não use metodo pois ele não atende
	 * @return 
	 */
	public static void main(String[] args) throws EmailException {

		Scanner teclado = new Scanner(System.in);
		Random random = new Random();
		Date data = new Date();
		Login login = new Login();
		EnviadorEmail email = new EnviadorEmail();
		Service servicos = new LancamentoServico();
		ResponsavelPeloServico responsavelPeloServico = new ResponsavelPeloServico();
		ContratadorServico coontratadorServico = new ContratadorServico();
		
		boolean continua = true;

		System.out.println("                       Seja Bem-vindo");
		System.out.println("               SISTEMA  GERENCIADOR DE ORDENS DE SERVIÇO ");
		System.out.println("");

		System.out.println("");

		System.out.println("====================================================================");
		System.out.println("                               LOGIN ");
		System.out.println("====================================================================");
		System.out.println("");
		System.out.print("                             NOME USUARIO :");
		login.setNomeUsuario(teclado.next());
		System.out.print("");
		System.out.print("                                SENHA:");
		login.setSenha(teclado.next());
		System.out.println("");

		boolean loginaAutorizado = (login.getNomeUsuario().equals("user") && login.getSenha().equals("12345"));

		if (loginaAutorizado) {

			while (continua) {

				System.out.println("Deseja :");
				System.out.println("[1] -> Incluir um Novo Serviço");
				System.out.println("[2] -> Alterar um Serviço");
				System.out.println("[3] -> Buscar um Serviço");
				System.out.println("[4] -> Liberar um Serviço");
				System.out.println("[5] -> Listar Serviço");
		
				Integer escolha = teclado.nextInt();

				Servico servico = new Servico();

				switch (escolha) {
				case 1:

					System.out.println("        INCLUIR -  UM -  NOVO - SERVIÇO     ");
					System.out.println("");

					System.out.println("=======================================");
					System.out.println("       INFORMOÇÕES SOBRE SERVIÇO ");
					System.out.println("=======================================");

					System.out.println("");

					System.out.print("Categoria do Serviço :");
					servico.setId(random.nextInt(20));
					servico.setNome(teclado.next());

					System.out.println("");

					System.out.print("Descrição do Serviço :");
					servico.setDescicao(teclado.next());

					System.out.println("");

					System.out.print("Nome profissional que vai realizar serviço : ");
					responsavelPeloServico.setNome(teclado.next());

					System.out.println("");

					System.out.print("Status do Serviço :");
					servico.setStatus(teclado.next());

					System.out.println("");

					servicos.incluir(servico);
					System.out.println("Serviço Adicionado com Sucesso !");

					break;

				case 2:

					System.out.println("         ALTERAR - UM -  SERVIÇO - ADICIONADO ");
					System.out.println("");

					System.out.println("Qual ID do Serviço há ser Alterado ?");
					Servico encontrado = servicos.buscar(teclado.nextInt());

					if (encontrado != null) {

						System.out.println("Nome do Serviço :");
						encontrado.setNome(teclado.next());

						System.out.println("Descrição do Serviço :");
						encontrado.setDescicao(teclado.next());

						System.out.println("Status do Serviço :");
						encontrado.setStatus(teclado.next());

						servicos.alterar(encontrado);

						System.out.println("");
						System.out.println("Serviço Alterado com Sucesso !");
					}
					break;

				case 3:

					System.out.println("           BUSCAR UM SERVIÇO");
					System.out.println("");

					System.out.println("Qual ID do Serviço Deseja Buscar ?");
					Servico encont = servicos.buscar(teclado.nextInt());

					if (encont != null) {

						System.out.println("ID -> " + encont.getId() + " | " + " NOME -> " + encont.getNome() + " | "
								+ " DESCRIÇÃO -> " + encont.getDescicao() + " | " + " STATUS -> " + encont.getStatus());

						System.out.println("");
					}

					break;

				case 4:

					System.out.println("          LIBERAR - UM - SERVIÇO");
					System.out.println("");

					System.out.println("Qual ID do Serviço Deseja Liberar ?");
					String mensagem = servicos.remover(teclado.nextInt());

					DateFormat formatadorDataEHora = new SimpleDateFormat(" HH:mm:ss");

					if (mensagem != null) {

						System.out.println("");

						System.out.println("=======================================");
						System.out.println("    DADOS DO CONTRATADOR DO SERVIÇO");
						System.out.println("=======================================");

						System.out.println("");

						System.out.print("Nome Cliente :");
						coontratadorServico.setNome(teclado.next());

						System.out.println("");

						System.out.print("Email do Cliente :");
						coontratadorServico.setEmail(teclado.next());

						System.out.println("");

						email.setMensagem("     Olá Tudo Bem  " + coontratadorServico.getNome() + " ? " + "\n\n"
								+ "  - Lovelace Tecnologia vêm informar através desse Email ao Senhor(a) "
								+ coontratadorServico.getNome()
								+ " , que já acabamos de realizar o serviço pedido. \n\n"
								+ "    Hora do Término da Tarefa:" + formatadorDataEHora.format(data) + "\n\n\n"
								+ "     Um Abraço.\n" + "     Lovelace Tecnologia");

						email.setPara(coontratadorServico.getEmail());
						email.setAssunto("Serviço Pedido ");
						email.eviarEmail(email.getMensagem(), email.getAssunto(), email.getPara());

						System.out.println("Email Enviado com Sucesso !");

					} else {

						System.out.println("");

						System.out.println("ID informado não existi !");

					}

					break;

				case 5:

					System.out.println("          LISTAR - SERVIÇOS");

					System.out.println("");

					for (Servico serv : servicos.listarTodos()) {

						System.out.println("ID -> " + serv.getId() + " | " + " NOME -> " + serv.getNome() + " | "
								+ " DESCRIÇÃO -> " + serv.getDescicao() + " | " + " STATUS -> " + serv.getStatus());

					}

					break;

				default:

					System.out.println("OPÇÃO ESCLHIDA INVÁLIDA !");
					System.out.println("   Muito Obrigado !");

					break;
				}

				System.out.println("Deseja continuar no sistema ? [S/N]");
				continua = teclado.next().equalsIgnoreCase("sim");

			}

		} else {
			System.out.println("Nome Usuario ou Senhas estão Incorretas !");
		}

		teclado.close();

	}

}
