package ch.picturedesk.myEditor.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ch.picturedesk.myEditor.control.ButtonArea;
import ch.picturedesk.myEditor.control.FileHandler;
import ch.picturedesk.myEditor.model.WorkArea;

public class EditorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2812702285568616060L;
	private JFrame frame;
	private InfoArea infoArea;
	private ButtonArea buttonArea;
	private WorkArea workArea;
	private JLabel noFile;
	private JScrollPane scrollPane;
	private MenuArea menuArea;
    private FileHandler fileHandler;
	
	public EditorFrame() {
	    buildGui();
	  }

	private void buildGui() {
		frame = new JFrame("MyEditor");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    noFile = new JLabel("No file loaded", SwingConstants.CENTER);
	    setFileHandler();

	    infoArea = new InfoArea();
	    buttonArea = new ButtonArea(this);
	    menuArea = new MenuArea(this);
	    
	    frame.getContentPane().add(infoArea, "North");
		closeWorkArea();
	    frame.getContentPane().add(buttonArea, "South");
	    frame.setJMenuBar(menuArea);
	    
	    frame.setVisible(true);

	    frame.setSize(800, 600);
	    frame.setVisible(true);
	}
	
	public void setWorkArea(String path, String content) {
	    workArea = new WorkArea(path,content);
	    scrollPane = new JScrollPane(workArea);
	    frame.remove(noFile);
	    frame.getContentPane().add(scrollPane, "Center");
	    infoArea.setLabel(path);
	    buttonArea.toggleClose(true);
	    buttonArea.toggleSave(true);
	    buttonArea.toggleNew(false);
	    workArea.grabFocus();
	    frame.setVisible(true);
	}
	
	public void closeWorkArea() {
		if(scrollPane != null) {
			frame.remove(scrollPane);
		}
	    frame.getContentPane().add(noFile, "Center");
	    infoArea.setLabel();
	    buttonArea.toggleClose(false);
	    buttonArea.toggleSave(false);
	    buttonArea.toggleNew(true);
	    frame.repaint();
	}
	
	public FileHandler getFileHandler() {
		return fileHandler;
	}

	public void setFileHandler() {
		fileHandler = new FileHandler();
	}

	public WorkArea getWorkArea() {
		return workArea;
	}
	
	public InfoArea getInfoArea() {
		return infoArea;
	}
}
