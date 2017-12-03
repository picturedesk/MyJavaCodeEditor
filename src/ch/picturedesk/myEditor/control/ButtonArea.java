package ch.picturedesk.myEditor.control;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.picturedesk.myEditor.view.EditorFrame;


public class ButtonArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2245946514107325745L;

	private JButton newB;
	private JButton save;
	private JButton close;
	private JButton open;
	
	public ButtonArea(EditorFrame editorFrame) {
		this.setLayout(new FlowLayout());

		newB = new JButton("New");
		open = new JButton("Open");
		save = new JButton("Save");
		close = new JButton("Close");

		this.add(newB);
		this.add(open);
		this.add(save);
		this.add(close);
		
		//Action Listeners
		
		newB.addActionListener(e-> {
			editorFrame.getFileHandler().saveFile(editorFrame);
		});
		
		open.addActionListener(e-> {
			editorFrame.getFileHandler().openFile(editorFrame);
		});
		
		save.addActionListener(e-> {
			editorFrame.getFileHandler().saveFile(editorFrame, editorFrame.getWorkArea().getPath());
		});
		
		close.addActionListener(e-> {
			editorFrame.closeWorkArea();
		});
	}

	public void toggleNew(boolean visibilty) {
		this.newB.setEnabled(visibilty);	
		
	}	

	public void toggleSave(Boolean visibilty) {
		this.save.setEnabled(visibilty);
	}	

	public void toggleClose(Boolean visibilty) {
		this.close.setEnabled(visibilty);	
	}
}
