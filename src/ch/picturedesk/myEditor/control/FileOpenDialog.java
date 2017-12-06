package ch.picturedesk.myEditor.control;

import javax.swing.JFileChooser;

import ch.picturedesk.myEditor.view.EditorFrame;

public class FileOpenDialog implements FileDialog {

	@Override
	public String FileDialog(String title, EditorFrame editorFrame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(title);
		int userSelection = fileChooser.showOpenDialog(editorFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    return fileChooser.getSelectedFile().getAbsolutePath();
		}
		return "";
	}

}
