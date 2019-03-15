package hu.wordplay.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiveLetterWordReader extends AbstractDataReader {

	@Override
	public List<String> process(BufferedReader br) throws IOException {
		List<String> lines = new ArrayList<>();
		String word;
		while ((word = br.readLine()) != null) {
			if (word.length() == 5) {
				lines.add(word);
			}
		}
		return lines;
	}

}
