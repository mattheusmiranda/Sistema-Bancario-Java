package Banco;

import java.util.ArrayList;
import java.util.Scanner;
import peixoto.domain.Conta;

public class Projeto {
	static int[] contasJaCriadas = new int[2];
	static double[] saldos = new double[2];
	public static void main(String[] args) {

		contasJaCriadas[0] = 258;
		contasJaCriadas[1] = 874;

		saldos[0] = 25000.0;
		saldos[1] = 58000.0;

		Scanner sc = new Scanner(System.in);

		Conta usuario = new Conta();

		System.out.println("qual o nome do usuario? ");
		usuario.setDonoDaConta(sc.next());

		System.out.println("qual o numero da conta? ");
		usuario.setnConta(sc.nextDouble());

		if (contasJaCriadas[0] != usuario.getnConta() && contasJaCriadas[1] != usuario.getnConta()) {
			System.out.println("conta invalida");
			System.exit(0);
		} else if (usuario.getnConta() == contasJaCriadas[0]) {
			usuario.setSaldo(saldos[0]);
			System.out.println(usuario.getDonoDaConta() + " seu saldo é: " + usuario.getSaldo());
		} else if (usuario.getnConta() == contasJaCriadas[1]) {
			usuario.setSaldo(saldos[1]);
			System.out.println(usuario.getDonoDaConta() + " seu saldo é: " + usuario.getSaldo());
		} else {
			System.out.println("usuario nao encontrado");
		}
		
		// segunda parte do codigo

		System.out.println("deseja efetuar alguma operacao? (s) (n) ");
		String continuarOuSairDaConta = sc.next();

		while (continuarOuSairDaConta.equalsIgnoreCase("s")) {

			if ("s".equalsIgnoreCase(continuarOuSairDaConta)) {
				System.out.println("deseja depositar(d), saquar(s) ou transferir(t): ");
				String segundaResposta = sc.next();

				if ("d".equalsIgnoreCase(segundaResposta)) { // deposito
					System.out.println("valor do deposito: ");
					double deposito = sc.nextDouble();				
					if (usuario.getnConta() == contasJaCriadas[0]) {
						// double saldoComDeposito = usuario.getSaldo() + deposito; <- foi substituido por usuario.getSaldo();
						usuario.depositar(deposito);
						System.out.println("novo saldo: " + usuario.getSaldo());
					} else if (usuario.getnConta() == contasJaCriadas[1]) {
						usuario.depositar(deposito);
						double saldoComDeposito = usuario.getSaldo() + deposito;
						System.out.println("novo saldo: " + saldoComDeposito);
						break;
						
					} else if (segundaResposta != "d") {
						System.out.println("conta nao encontrada");
					}
					
				} else if ("s".equalsIgnoreCase(segundaResposta)) { // saque 
					System.out.println("valor do saque: ");
					double saque = sc.nextDouble();
					if (usuario.getnConta() == contasJaCriadas[0]) {
						double saldoComSaque = usuario.getSaldo() - saque;
						usuario.sacar(saque);
						System.out.println("novo saldo: " + saldoComSaque);
					} else if (usuario.getnConta() == contasJaCriadas[1]) {
						double saldoComSaque = usuario.getSaldo() - saque;
						usuario.sacar(saque);
						System.out.println("novo saldo: " + saldoComSaque);
						
					} else {
						System.out.println("conta nao encontrada");
						}
					
					// transferir 
					} else if ("t".equalsIgnoreCase(segundaResposta)) {
						System.out.println("qual o numero da conta? ");
						int numeroContaParaTransferir = sc.nextInt();
						
						if(numeroContaParaTransferir == contasJaCriadas[1]) { // para ligar a transferencia a conta certa
							System.out.println("qual o valor da transferencia? ");
							double valorParaTransferir = sc.nextDouble();
							
							double saldoMaisValTranferencia =  usuario.getSaldo() + valorParaTransferir; // saldo do usuario[1]
							usuario.receberTransferencia(valorParaTransferir);
							
							double novoSaldoMenosTransferencia = usuario.getSaldo() - valorParaTransferir; 
							usuario.saldoAposTransferencia(valorParaTransferir);
							System.out.println("seu saldo agora é: " + novoSaldoMenosTransferencia);
							// System.out.println(usuario.getSaldo());
						 }
						
					} else if (segundaResposta != "s") {
					System.out.println("erro");
				}
			}
				System.out.println("deseja fazer mais alguma operacao? (s) (n)");
				continuarOuSairDaConta = sc.next();
		}
			System.out.println("até mais ;)");
	}
}

	