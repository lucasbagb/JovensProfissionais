package com.indracompany.carshopapp.Testes;

import java.io.IOException;

import com.indracompany.carshopapp.DAO.ManipuladorVendas;
import com.indracompany.carshopapp.Entidades.Carro;
import com.indracompany.carshopapp.Entidades.Cliente;
import com.indracompany.carshopapp.Entidades.Vendas;

public class TestaJulio {

	public static void main(String[] args) {

//		 TelaBoasVindas tbv = new TelaBoasVindas();
//		 tbv.JTPBoasVindas();

//		 TelaCadFuncionarios tf = new TelaCadFuncionarios();
//		 tf.JTPFuncionarios();

		Cliente c = new Cliente("Albatroz", "36939241800", "1158462251", "jbull", 123);
		Carro car = new Carro("Fiat", "Uno", "JVM-1234", 1);

		Vendas venda = new Vendas(car, c, 2);
//		System.out.println(venda.toStringVendas());
		ManipuladorVendas mv = new ManipuladorVendas(venda);
		mv.escreveVenda(venda);
		try {
//			mv.lerVenda();
			mv.fechaManipulador();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}