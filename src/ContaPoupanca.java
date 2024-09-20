public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado: R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
        }
    }

    public void calcularRendimento() {
        double rendimento = saldo * taxaRendimento / 100;
        saldo += rendimento;
        System.out.println("Rendimento calculado: R$ " + rendimento);
    }
}
