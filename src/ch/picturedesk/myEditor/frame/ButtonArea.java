package ch.picturedesk.myEditor.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2245946514107325745L;
	
	private FileHandler fileHandler = new FileHandler();

	private JButton newB;
	private JButton save;
	private JButton close;
	
	public ButtonArea(EditorFrame editorFrame) {
		this.setLayout(new FlowLayout());

		newB = new JButton("New");
		save = new JButton("Save");
		close = new JButton("Close");

		this.add(newB);
		this.add(save);
		this.add(close);
		
		//Action Listeners
		save.addActionListener(e-> {
			fileHandler.saveFile(editorFrame, readContent(editorFrame));
		});
		
		newB.addActionListener(e-> {
			editorFrame.setWorkArea();
		});
		
		close.addActionListener(e-> {
			editorFrame.closeWorkArea();
		});
	}

	private String readContent(EditorFrame editorFrame) {
		return editorFrame.getWorkArea().getText();	
	}

	public void toggleSaveClose(Boolean visibilty) {
		this.save.setEnabled(visibilty);	
		this.close.setEnabled(visibilty);	
	}	
}
