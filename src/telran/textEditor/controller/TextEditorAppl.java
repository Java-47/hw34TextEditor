package telran.textEditor.controller;


import telran.textEditor.Infra.TextEditor;

public class TextEditorAppl {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Wrong number of arguments");
			return;
		}
		try {		
			TextEditor.execute(args[0], args[1], args[2]);
			 
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
