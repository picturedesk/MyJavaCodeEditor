package ch.picturedesk.myEditor.control;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

import ch.picturedesk.myEditor.view.EditorFrame;

public class FileHandler {
	
	private static final String DIALOG_SAVE = "Datei speichern";
	private static final String DIALOG_OPEN = "Datei laden";
	private FileOpenDialog openDialog = new FileOpenDialog();
	private FileSaveDialog saveDialog = new FileSaveDialog();
	
	public void saveFile(EditorFrame editorFrame, String path) {
		String choosedFile = path;
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
		    		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
				) {
		    			oos.write(readContent(editorFrame));
		    			oos.close();
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
		String choosedFile = saveDialog.FileDialog(DIALOG_SAVE, editorFrame);
		if (!choosedFile.isEmpty()) {
		    try (
				OutputStream fos = new FileOutputStream(choosedFile);
		    		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
				) {
		    			oos.write("");
		    			oos.close();
		    			if(!choosedFile.isEmpty() ) {
		    				editorFrame.setWorkArea(choosedFile,null);
		    			}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}
	
	public void openFile(EditorFrame editorFrame) {
		String file = openDialog.FileDialog(DIALOG_OPEN, editorFrame);
		if (!file.isEmpty()) {
		    try (
		    		FileReader fis = new FileReader(file);
		    		BufferedReader ois = new BufferedReader(fis);
				) {
		    			String sCurrentLine;
		    			StringBuilder buffer = new StringBuilder();
					while ((sCurrentLine = ois.readLine()) != null) {
						buffer.append(sCurrentLine);
						buffer.append('\n');
					}
		    			editorFrame.setWorkArea(file, buffer.toString());
		    			ois.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}

	private String readContent(EditorFrame editorFrame) {
		return editorFrame.getWorkArea().getText();	
	}
}
