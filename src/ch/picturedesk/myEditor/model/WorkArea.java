package ch.picturedesk.myEditor.model;

import org.fife.ui.rsyntaxtextarea.*;

public class WorkArea extends RSyntaxTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2900323073511528818L;
	private String path;
	
	public WorkArea(String path, String content) {
		super(20, 60);

		this.path = path;
		this.setSyntaxEditingStyle(getSyntax(getExtension(this.path)));
		this.setCodeFoldingEnabled(true);
		
		this.setText(content);
	    this.setEditable(true);
	}

	public String getPath() {
		return path;
	}
	
	public String getExtension(String path) {
		String extension = "";
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
	
	private String getSyntax(String ext) {
		String filetype = "";
	    switch (ext) {
		     case "css":
		    	 	filetype = SyntaxConstants.SYNTAX_STYLE_CSS;
		         break;
	         case "html":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_HTML;
	        	 	break;
	         case "htm":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_HTML;
	        	 	break;
	         case "json":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_JSON;
	        	 	break;
	         case "java":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_JAVA;
	        	 	break;
	         case "js":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT;
	        	 	break;
	         case "php":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_PHP;
	             break;
	         case "xml":
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_XML;
	             break;
	         default:
	        	 	filetype = SyntaxConstants.SYNTAX_STYLE_NONE;
	     }
		return filetype;
	}
}
