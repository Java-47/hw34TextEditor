package telran.textEditor.model;

import java.util.Collections;
import java.util.List;

import telran.textEditor.Infra.Operation;

public class Shuffle implements Operation {

	@Override
	public List<String> action(List<String> lines) {
		Collections.shuffle(lines);
		return lines;
	}

}
