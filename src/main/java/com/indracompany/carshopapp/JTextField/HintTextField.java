package com.indracompany.carshopapp.JTextField;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HintTextField extends JTextField implements FocusListener {

	private final String hint;
	private boolean showingHint;
	

	public HintTextField(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		super.setForeground(Color.GRAY);
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
		} else if (!this.getText().isEmpty()){
			super.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			showingHint = true;
		} else if (!this.getText().isEmpty()){
			super.setForeground(Color.BLACK);
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}

}