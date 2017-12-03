package ch.picturedesk.myEditor.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import ch.picturedesk.myEditor.view.EditorFrame;

public class FileHandler {
	
	private static final String DIALOG_SAVE = "Datei speichern";
	private static final String DIALOG_OPEN = "Datei laden";
	
	public void saveFile(EditorFrame editorFrame, String path) {
		String choosedFile = path;
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
		    			oos.writeObject(readContent(editorFrame));
		    			JOptionPane.showMessageDialog(editorFrame,
		                        "Text gespeichert",
		                        "Speichern",
		                        JOptionPane.INFORMATION_MESSAGE);
		    			editorFrame.getWorkArea().grabFocus();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}
	
	public void saveFile(EditorFrame editorFrame) {
		String choosedFile = FileDialog(DIALOG_SAVE, editorFrame);
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
		    			oos.writeObject(null);
		    			if(!choosedFile.isEmpty() ) {
		    				editorFrame.setWorkArea(choosedFile,null);
		    			}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}
	
	public void openFile(EditorFrame editorFrame) {
		String file = FileDialog(DIALOG_OPEN, editorFrame);
		if (!file.isEmpty()) {
		    try (
		    		InputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				) {
		    			editorFrame.setWorkArea(file, ois.readObject().toString());
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}
	
	private String FileDialog(String title, EditorFrame editorFrame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(title);
		int userSelection = fileChooser.showSaveDialog(editorFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    return fileChooser.getSelectedFile().getAbsolutePath();
		}
		return "";
	}

	private String readContent(EditorFrame editorFrame) {
		return editorFrame.getWorkArea().getText();	
	}
}
