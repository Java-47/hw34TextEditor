package telran.textEditor.model;
import java.util.Collections;
import java.util.List;

import telran.textEditor.Infra.Operation;

public class Sort implements Operation {

	@Override
	public List<String> action(List<String> lines) {

		Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
		return lines;

	}

}
