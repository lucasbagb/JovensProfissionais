package Testes;

import javax.swing.*;

/**
 * JOptionPane showInputDialog example #3. Using a combo box in an input dialog
 * (showInputDialog).
 * 
 * @author alvin alexander, http://alvinalexander.com
 */
public class JOptionPaneComboBox {

	public static final String[] pizzas = { "Cheese", "Pepperoni", "Sausage", "Veggie" };

	public static void main(String[] args) {
		JFrame frame = new JFrame("Input Dialog Example 3");
		String favoritePizza = (String) JOptionPane.showInputDialog(frame, "What is your favorite pizza?",
				"Favorite Pizza", JOptionPane.QUESTION_MESSAGE, null, pizzas, pizzas[0]);

		// favoritePizza will be null if the user clicks Cancel
		System.out.printf("Favorite pizza is %s.\n", favoritePizza);
		System.exit(0);
	}

}