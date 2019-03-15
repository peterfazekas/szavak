package hu.wordplay.domain.service;

import java.util.Arrays;
import java.util.List;

import hu.wordplay.domain.model.WordStatistic;

public class WordService {

	private static final List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u"); 
	
	private final WordStatistic wordStatistic;

	public WordService() {
		this.wordStatistic = new WordStatistic();
	}
	
	public void setLongetsWord(String word) {
		if (word.length() > wordStatistic.getLongestWord().length()) {
			wordStatistic.setLongestWord(word);
		}
	}
	
	public String getLongestWord() {
		return wordStatistic.getLongestWord();
	}

	public boolean hasVowel(String word) {
		return countVowels(word) > 0;
	}
	
	public String getWordStatistic() {
		int counter = wordStatistic.getWordCounter();
		int specialCounter = wordStatistic.getSpecialWordCounter();
		double percent = specialCounter * 100.0 / counter;
		return String.format("%d/%d : %4.2f%%", specialCounter, counter, percent);
	}
	
	public void doStatistic(String word) {
		wordStatistic.incWordCounter();
		if (isSpecialWord(word)) {
			wordStatistic.incSpecialWordCounter();
		}
	}
	
	public boolean isSpecialWord(String word) {
		return countVowels(word) * 2 > word.length();
	}
	
	private long countVowels(String word) {
		return VOWELS.stream().filter(word::contains).count();
	}
}
