package ch.picturedesk.myEditor.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
	
	public EditorFrame() {
	    buildGui();
	  }

	private void buildGui() {
		frame = new JFrame("MyEditor");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    noFile = new JLabel("No file loaded",SwingConstants.CENTER);

	    infoArea = new InfoArea();
	    buttonArea = new ButtonArea(this);
	    
	    frame.getContentPane().add(infoArea, "North");
		closeWorkArea();
	    frame.getContentPane().add(buttonArea, "South");
	    
	    frame.setVisible(true);

	    frame.setSize(800, 600);
	    frame.setVisible(true);
	}
	
	public WorkArea getWorkArea() {
		return workArea;
	}
	
	public void setWorkArea() {
	    workArea = new WorkArea();
	    scrollPane = new JScrollPane(workArea);
	    frame.remove(noFile);
	    frame.getContentPane().add(scrollPane, "Center");
	    buttonArea.toggleSaveClose(true);
	    frame.setVisible(true);
	}
	
	public void closeWorkArea() {
		if(scrollPane != null) {
			frame.remove(scrollPane);
		}
	    frame.getContentPane().add(noFile, "Center");
	    buttonArea.toggleSaveClose(false);
	    frame.repaint();
	}
}
