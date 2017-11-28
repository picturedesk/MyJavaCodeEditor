package ch.picturedesk.myEditor.frame;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4240858088727872932L;

	public InfoArea() {
		super();

		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel label = new JLabel("Pfad: ");
		
		this.add(label);
	}
	
}
