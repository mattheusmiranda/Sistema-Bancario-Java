package Banco;

public class Conta {
	private double saldo;
	private double nConta;
	private String donoDaConta;

	public double getnConta() {
		return nConta;
	}

	public void setnConta(double nConta) {
		this.nConta = nConta;
	}

	public String getDonoDaConta() {
		return donoDaConta;
	}

	public void setDonoDaConta(String donoDaConta) {
		this.donoDaConta = donoDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valorDeposito) {
		this.saldo = this.saldo + valorDeposito;
	}

	public void sacar(double valorSaque) {
		this.saldo = this.saldo - valorSaque;
	}

}
