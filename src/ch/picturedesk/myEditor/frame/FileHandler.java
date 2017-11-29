package ch.picturedesk.myEditor.frame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileHandler {
	
	private static final String DIALOG_SAVE = "Datei speichern";
	private static final String DIALOG_OPEN = "Datei laden";
	
	protected void saveFile(JFrame topFrame, String content, String path) {
		String choosedFile = path;
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
		    			oos.writeObject(content);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}
	
	protected String saveFile(JFrame topFrame) {
		String choosedFile = FileDialog(DIALOG_SAVE, topFrame);
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
		    			oos.writeObject(null);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		return choosedFile;
	}
	
	protected String openFile(JFrame topFrame) {
		String file = FileDialog(DIALOG_OPEN, topFrame);
		if (!file.isEmpty()) {
		    try (
		    		InputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				) {
		    			return ois.readObject().toString();
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	private String FileDialog(String title, JFrame caller) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(title);
		int userSelection = fileChooser.showSaveDialog(caller);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    return fileChooser.getSelectedFile().getAbsolutePath();
		}
		return "";
	}
}
