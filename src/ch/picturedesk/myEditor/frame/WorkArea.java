package ch.picturedesk.myEditor.frame;

import javax.swing.JEditorPane;

public class WorkArea extends JEditorPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2900323073511528818L;
	private String path;
	
	public WorkArea(String path, String content) {
		super();
		this.path = path;
		this.setText(content);
	    this.setEditable(true);
	}
	
	public String getPath() {
		return path;
	}
}
