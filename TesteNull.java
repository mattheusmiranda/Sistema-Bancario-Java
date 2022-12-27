package Banco;

import peixoto.domain.Conta;

public class TesteNull {

	public static void main(String[] args) {
		Conta usuario = new Conta();
		usuario.setTitular("matheus");
		usuario.setnConta(258.0);
		System.out.println("Saldo " + usuario.getSaldo());
		
	}

}
