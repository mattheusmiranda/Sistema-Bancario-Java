package ContaBanco;

import java.util.Scanner;

import Banco.Conta;

public class Projeto {
	//static int[] contasJaCriadas = new int[2];
	//static double[] saldos = new double[2];

	public static void main(String[] args) {

		//int[] notasDaSala = new int[4];
		//Conta[] contasCadastradasNoBanco = new Conta[10];

		Scanner sc = new Scanner(System.in);

		Conta usuarioJoao = new Conta();
		Conta usuarioPedro = new Conta(); 

		usuarioJoao.setnConta(258);
		usuarioJoao.setSaldo(25000);
		usuarioJoao.setDonoDaConta("Joao");

		usuarioPedro.setnConta(874);
		usuarioPedro.setSaldo(50000);
		usuarioPedro.setDonoDaConta("Pedro");

		while (true) {
			System.out.println("qual o numero da conta? ");
			int numeroParaAcessarConta = sc.nextInt();

			if (numeroParaAcessarConta == usuarioPedro.getnConta()) {
				System.out.println("bem vindo a sua conta " + usuarioPedro.getDonoDaConta());
			} else if (numeroParaAcessarConta == usuarioJoao.getnConta()) {
				System.out.println("bem vindo a sua conta " + usuarioPedro.getDonoDaConta());
			}

			if (numeroParaAcessarConta != usuarioPedro.getnConta() && numeroParaAcessarConta != usuarioJoao.getnConta()) {
				System.out.println("conta invalida");
				System.exit(0);
			} else if (numeroParaAcessarConta == usuarioPedro.getnConta()) {
				usuarioPedro.getSaldo();
				System.out.println(usuarioPedro.getDonoDaConta() + " seu saldo é: " + usuarioPedro.getSaldo());
			} else if (numeroParaAcessarConta == usuarioJoao.getnConta()) {
				usuarioJoao.getSaldo();
				System.out.println(usuarioJoao.getDonoDaConta() + " seu saldo é: " + usuarioJoao.getSaldo());
			} else {
				System.out.println("usuario nao encontrado");
			}

			System.out.println("deseja efetuar alguma operacao? (s) (n) ");
			String continuarOuSairDaConta = sc.next();

			while (continuarOuSairDaConta.equalsIgnoreCase("s")) {

				if ("s".equalsIgnoreCase(continuarOuSairDaConta)) {
					System.out.println("deseja depositar(d), saquar(s) ou transferir(t): ");
					String segundaResposta = sc.next();

					if ("d".equalsIgnoreCase(segundaResposta)) { // deposito
						System.out.println("valor do deposito: ");
						double deposito = sc.nextDouble();
						if (numeroParaAcessarConta == usuarioPedro.getnConta()) {
							usuarioPedro.depositar(deposito);
							System.out.println("novo saldo: " + usuarioPedro.getSaldo());
						} else if (numeroParaAcessarConta == usuarioJoao.getnConta()) {
							usuarioJoao.depositar(deposito);
							System.out.println("novo saldo: " + usuarioJoao.getSaldo());
							break;

						} else if (segundaResposta != "d") {
							System.out.println("conta nao encontrada");
						}

					} else if ("s".equalsIgnoreCase(segundaResposta)) { // saque
						System.out.println("valor do saque: ");
						double saque = sc.nextDouble();
						if (numeroParaAcessarConta == usuarioPedro.getnConta()) {
							usuarioPedro.sacar(saque);
							System.out.println("novo saldo: " + usuarioPedro.getSaldo());
						} else if (numeroParaAcessarConta == usuarioJoao.getnConta()) {											
							usuarioJoao.sacar(saque);
							System.out.println("novo saldo: " + usuarioJoao.getSaldo());
						} else {
							System.out.println("conta nao encontrada");
						}

					} else if ("t".equalsIgnoreCase(segundaResposta)) { // transferir
						System.out.println("qual o numero da conta para a transferencia? ");
						int numeroContaParaTransferir = sc.nextInt();

						// Escolheu transferir para a conta do Pedro...
						if (numeroContaParaTransferir == usuarioPedro.getnConta()) {
							System.out.println("qual o valor da transferencia? ");
							double valorParaTransferir = sc.nextDouble();

							usuarioJoao.sacar(valorParaTransferir);
							usuarioPedro.depositar(valorParaTransferir);

							System.out.println("Pedro, seu saldo agora é: " + usuarioPedro.getSaldo());

							// Escolheu transferir para a conta do Joao...
						} else if (numeroContaParaTransferir == usuarioJoao.getnConta()) {
							System.out.println("qual o valor da transferencia? ");
							double valorParaTransferir = sc.nextDouble();

							usuarioPedro.sacar(valorParaTransferir);
							usuarioJoao.depositar(valorParaTransferir);

							System.out.println("João, seu saldo agora é: " + usuarioJoao.getSaldo());
						}
					} else if (segundaResposta != "s") {
						System.out.println("erro");
					}
				}
				System.out.println("deseja fazer mais alguma operacao? (s) (n)");
				continuarOuSairDaConta = sc.next();
				if (continuarOuSairDaConta == "n") {
					System.out.println("até mais ;)");
				}
			}
		}
	}
}