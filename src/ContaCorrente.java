public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(String titular, double chequeEspecial) {
        super(titular);
        this.chequeEspecial = chequeEspecial;
    }

    public void sacar(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Saque realizado: R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
        }
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= chequeEspecial) {
            chequeEspecial -= valor;
            System.out.println("Cheque especial utilizado: R$ " + valor);
        } else {
            System.out.println("Cheque especial insuficiente.");
        }
    }
}
