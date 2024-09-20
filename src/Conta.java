public abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado: R$ " + valor);
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}
