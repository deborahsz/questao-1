import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        Conta conta = null;
        if (tipoConta == 1) {
            System.out.print("Digite o valor do cheque especial: ");
            double chequeEspecial = scanner.nextDouble();
            conta = new ContaCorrente(titular, chequeEspecial);
        } else if (tipoConta == 2) {
            System.out.print("Digite a taxa de rendimento (%): ");
            double taxaRendimento = scanner.nextDouble();
            conta = new ContaPoupanca(titular, taxaRendimento);
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            if (conta instanceof ContaCorrente) {
                System.out.println("3. Usar Cheque Especial");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("3. Calcular Rendimento");
            }
            System.out.println("4. Exibir Dados da Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta instanceof ContaCorrente) {
                        ((ContaCorrente) conta).sacar(valorSaque);
                    } else {
                        ((ContaPoupanca) conta).sacar(valorSaque);
                    }
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.print("Digite o valor a ser utilizado do cheque especial: ");
                        double valorCheque = scanner.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorCheque);
                    } else {
                        ((ContaPoupanca) conta).calcularRendimento();
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
