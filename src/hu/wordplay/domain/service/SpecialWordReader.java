package hu.wordplay.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecialWordReader extends AbstractDataReader {

	private final WordService wordService;

	public SpecialWordReader(WordService wordService) {
		this.wordService = wordService;
	}

	@Override
	public List<String> process(BufferedReader br) throws IOException {
		List<String> lines = new ArrayList<>();
		String word;
		while ((word = br.readLine()) != null) {
			wordService.setLongetsWord(word);
			wordService.doStatistic(word);
			if (wordService.isSpecialWord(word)) {
				lines.add(word);
			}
		}
		return lines;
	}

}
