package JTextField.Cadastros;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ManipuladorCarros;
import Entidades.Carro;
import JTextField.HintTextField;
import JTextField.HintTextFieldPersist;
import Validadores.ValidaCadastro;

public class TelaCadCarros {

	public void JTPCarros() {

		JTextField marca = new HintTextField("Ex: Ford, Chevrolet, Nissan, etc.");
		JTextField modelo = new HintTextField("Ex: Celta, Corsa, Ka, etc.");
		JTextField placa = new HintTextField("Ex: AAA-9999");
		JTextField preco = new HintTextFieldPersist("R$ 99999,99", "R$ ");

		Double precoFinal;

		Object[] messages = { "Digite a marca:", marca, "Digite o modelo:", modelo, "Digite a placa:", placa,
				"Digite o preço de aquisição: R$", preco };

		int option = JOptionPane.showConfirmDialog(null, messages, "Cadastro de veículos - IndraCarShopApp",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			ValidaCadastro vc = new ValidaCadastro();

			if (vc.ValidadorCamposCarros(marca, modelo, placa, preco)) {

				precoFinal = Double.parseDouble(preco.getText().replace("R$", "").trim().replace(",", "."));

				Carro carro = new Carro(marca.getText(), modelo.getText(), placa.getText(), precoFinal);
				ManipuladorCarros mv = new ManipuladorCarros();
				try {
					mv.escreveCadastros(carro.toString());
					mv.fechaManipulador();
				} catch (IOException ioe) {
					System.out.println(ioe.getStackTrace());
				}
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", "Cadastro de veículos - IndraCarShopApp",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de veículos - IndraCarShopApp",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
