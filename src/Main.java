import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem-vindo(a) ao Banco DIO");
		System.out.println("Por favor, primeiro insira o seu nome: ");
        String nomeCliente = scanner.nextLine();
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		System.out.println("Conta criada com sucesso!");
        System.out.println("Agência: " + cc.getAgencia());
        System.out.println("Número da conta: " + cc.getNumero());

		boolean exit = false;

		while (!exit) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Imprimir Extrato Conta Corrente");
            System.out.println("5. Imprimir Extrato Conta Poupança");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Escolha a conta para depósito (1: Corrente, 2: Poupança): ");
                    int contaDeposito = scanner.nextInt();
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    if (contaDeposito == 1) {
                        cc.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso na Conta Corrente.");
                    } else if (contaDeposito == 2) {
                        poupanca.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso na Conta Poupança.");
                    } else {
                        System.out.println("Opção de conta inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Escolha a conta para saque (1: Corrente, 2: Poupança): ");
                    int contaSaque = scanner.nextInt();
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (contaSaque == 1) {
                        cc.sacar(valorSaque);
                    } else if (contaSaque == 2) {
                        poupanca.sacar(valorSaque);
                    } else {
                        System.out.println("Opção de conta inválida.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para transferir da Conta Corrente para a Conta Poupança: ");
                    double valorTransferencia = scanner.nextDouble();
                    cc.transferir(valorTransferencia, poupanca);
                    break;
                case 4:
                    cc.imprimirExtrato();
                    break;
                case 5:
                    poupanca.imprimirExtrato();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saindo do aplicativo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}