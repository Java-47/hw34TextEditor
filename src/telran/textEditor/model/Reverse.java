package telran.textEditor.model;

import java.util.Collections;
import java.util.List;

import telran.textEditor.Infra.Operation;

public class Reverse implements Operation {

	@Override
	public List<String> action(List<String> lines) {
		Collections.reverse(lines);
		return lines;
		
	}

}
