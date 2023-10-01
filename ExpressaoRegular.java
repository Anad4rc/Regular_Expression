import java.util.Scanner;

public class ExpressaoRegular {

	//metodo para verificar se o numero digitado tem o padrão de um CPF - ddd.ddd.ddd-dd
	public static boolean validar_CPF(String CPF) {
		String ER_cpf = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
		return CPF.matches(ER_cpf);
	}

	//metodo que verifica se a entrada é uma numeração de placa valida
	//placa antiga (AAA-####), placa novo (AAA#A##)
	public static boolean validar_placa_carro(String placa) {
		String ER_placa_carro = "[A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2}";
		return placa.matches(ER_placa_carro);
	}

	//metodo que verifica se o numero digitado segue o padrão de um numero de telefone fixo ou movel
	//fixo: (DD) DDDD-DDDD ou movel: (DD) DDDDDDDDD
	public static boolean validar_telefone(String telefone) {
		String ER_telefone = "\\(\\d{2}\\) \\d{4}-\\d{4}|\\(\\d{2}\\) \\d{9}";
		return telefone.matches(ER_telefone);
	}

	//metodo para verificar se o email digitado pelo usuario é valido
	//alunoufpb@gmail.com
	public static boolean validar_email(String email) {
		String ER_email = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		return email.matches(ER_email);
	}

	//metodo utilizado para verificar se a url do site é valida
	//https://www.w3.org/Addressing/URL/url-spec.html
	public static boolean validar_URL(String url) {
		String ER_url = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(/\\S*)?$";
		return url.matches(ER_url);
	}

	//metodo verifica se a data digitada segue o padrao dd/mm/aaaa
	public static boolean validar_data(String data) {
		String ER_data = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		return data.matches(ER_data);
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		//usuario pode escolher qual padrão ele quer validar
		while (true) {
			System.out.println("""
            Escolha uma opcao:
            1. Validar CPF
            2. Validar Placa de Carro
            3. Validar Numero de Telefone
            4. Validar Endereco de Email
            5. Validar URL
            6. Validar Data
            7. Sair
            """);

			String escolha = entrada.nextLine();

			switch (escolha) {
				case "1" -> {
					System.out.print("Digite o CPF: ");
					String cpf = entrada.nextLine();
					if (validar_CPF(cpf)) {
						System.out.println("CPF valido.");
					} else {
						System.out.println("CPF invalido.");
					}
				}
				case "2" -> {
					System.out.print("Digite a Placa de Carro: ");
					String placa = entrada.nextLine();
					if (validar_placa_carro(placa)) {
						System.out.println("Placa de Carro valida.");
					} else {
						System.out.println("Placa de Carro invalida.");
					}
				}
				case "3" -> {
					System.out.print("Digite o Número de Telefone: ");
					String telefone = entrada.nextLine();
					if (validar_telefone(telefone)) {
						System.out.println("Numero de Telefone valido.");
					} else {
						System.out.println("Numero de Telefone invalido.");
					}
				}
				case "4" -> {
					System.out.print("Digite o Endereço de Email: ");
					String email = entrada.nextLine();
					if (validar_email(email)) {
						System.out.println("Endereco de Email valido.");
					} else {
						System.out.println("Endereco de Email invalido.");
					}
				}
				case "5" -> {
					System.out.print("Digite a URL: ");
					String url = entrada.nextLine();
					if (validar_URL(url)) {
						System.out.println("URL valida.");
					} else {
						System.out.println("URL invalida.");
					}
				}
				case "6" -> {
					System.out.print("Digite a Data (dd/mm/aaaa): ");
					String data = entrada.nextLine();
					if (validar_data(data)) {
						System.out.println("Data valida.");
					} else {
						System.out.println("Data invalida.");
					}
				}
				case "7" -> {
					entrada.close(); //fechar o scanner
					System.exit(0); // Terminar o programa
				}
				default -> System.out.println("Opção invalida. Tente novamente.");
			}
		}
	}
}