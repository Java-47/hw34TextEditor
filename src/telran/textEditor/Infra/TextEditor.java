package telran.textEditor.Infra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextEditor {
	private static final String PACKAGE = "telran.textEditor.model.";

	public static void execute(String FileInName, String FileOutName, String operation) {

		List<String> textLines = new ArrayList<>();

		File inFile = new File(FileInName);

		if (inFile.exists() && inFile.isFile()) {
			try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
				textLines = br.lines().collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File not found. Please enter correct file name");
			return;
		}

		System.out.println("File: " + inFile.getPath() + " opened...");

		try {
			Class<?> clazz = Class.forName(PACKAGE + operation);
			Operation oper = (Operation) clazz.getDeclaredConstructor().newInstance();
			oper.action(textLines);

		} catch (Exception e) {
			System.out.println("Wrong operation name");
			throw new RuntimeException();
		}
		File outFile = new File(FileOutName);
		if (!outFile.exists() && !outFile.isDirectory()) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
				textLines.forEach(line -> {
					try {
						bw.write(line);
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				System.out.println("File: " + outFile.getPath() + " has been created...");

			} catch (IOException e) {
				e.printStackTrace();

			}
		} else {
			System.out.println("The file has already been created, please enter a different file name.");
			return;
		}
		System.out.println();
		System.out.println("The program has been successfully completed");
		


	}
}
