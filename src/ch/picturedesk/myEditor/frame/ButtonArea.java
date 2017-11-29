package ch.picturedesk.myEditor.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
			String path = fileHandler.saveFile(editorFrame);
			if(!path.isEmpty() ) {
				editorFrame.setWorkArea(path,null);
			}
		});
		
		open.addActionListener(e-> {
			String content = fileHandler.openFile(editorFrame);
			editorFrame.setWorkArea(path, content);
		});
		
		save.addActionListener(e-> {
			fileHandler.saveFile(editorFrame, readContent(editorFrame), editorFrame.getWorkArea().getPath());
			JOptionPane.showMessageDialog(editorFrame,
                    "Text gespeichert",
                    "Speichern",
                    JOptionPane.INFORMATION_MESSAGE);
			editorFrame.getWorkArea().grabFocus();
		});
		
		close.addActionListener(e-> {
			editorFrame.closeWorkArea();
		});
	}

	private String readContent(EditorFrame editorFrame) {
		return editorFrame.getWorkArea().getText();	
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
