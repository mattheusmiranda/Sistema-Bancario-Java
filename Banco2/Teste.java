package ContaBanco;

import Banco.Conta;

public class Teste {
	
	
	public static void main(String[] args) {
		
		Conta[] contas = new Conta[2];
		
		Conta contaJoao = new Conta();
		contaJoao.setDonoDaConta("João");
		contaJoao.setSaldo(1000);
		
		Conta contaPedro = new Conta ();
		contaPedro.setDonoDaConta("Pedro");
		contaPedro.setSaldo(2000);
		
		
		contas[0] = contaPedro;
		contas[1] = contaJoao;
		
		
		
		/*
		 *    [ 5 , 8 ]
		 *    
		 *    
		 *    [ contaJoao, contaPedro ]
		 * 
		 */
		
		
		for (int i = 0; i < contas.length; i++) {
			Conta banana = contas[i];
			
			System.out.println(banana.getDonoDaConta());
			System.out.println(banana.getSaldo());
			System.out.println("após o saque");
			banana.sacar(100);
			System.out.println(banana.getSaldo());
		} 
		
		
		/*for (Conta banana : contas) {
			System.out.println(banana.getDonoDaConta());
			System.out.println(banana.getSaldo());
			System.out.println("após o saque");
			banana.sacar(100);
			System.out.println(banana.getSaldo());
		}*/
	}
	
}