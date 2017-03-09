package JTextField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HintTextFieldPersist extends JTextField implements FocusListener {

	private final String firstHint;
	private final String secondHint;
	private boolean showingHint;

	public HintTextFieldPersist(final String firstHint, final String secondHint) {
		super(firstHint);
		this.firstHint = firstHint;
		this.secondHint = secondHint;
		this.showingHint = true;
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(secondHint);
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(firstHint);
			showingHint = true;
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}

}