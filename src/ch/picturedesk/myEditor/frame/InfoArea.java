package ch.picturedesk.myEditor.frame;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4240858088727872932L;
	private static final String LABEL_NOFILE = "File: <No File>";
	private JLabel label;

	public InfoArea() {
		super();

		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		label = new JLabel(LABEL_NOFILE);
		this.add(label);
	}
	
	public void setLabel(String path) {
		label.setText("File: " + path);
	}
	
	public void setLabel() {
		label.setText(LABEL_NOFILE);
	}
	
	public String getLabel() {
		return label.getText();
	}
}
