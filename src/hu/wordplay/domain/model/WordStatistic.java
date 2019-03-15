package hu.wordplay.domain.model;

public class WordStatistic {

	private String longestWord;
	private int wordCounter;
	private int specialWordCounter;
	
	public WordStatistic() {
		longestWord = "";
		wordCounter = 0;
		specialWordCounter = 0;
	}

	public String getLongestWord() {
		return longestWord;
	}

	public void setLongestWord(String longestWord) {
		this.longestWord = longestWord;
	}

	public int getWordCounter() {
		return wordCounter;
	}

	public void incWordCounter() {
		wordCounter++;
	}

	public int getSpecialWordCounter() {
		return specialWordCounter;
	}

	public void incSpecialWordCounter() {
		specialWordCounter++;
	}

	
	
	
}
