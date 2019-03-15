package hu.wordplay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import hu.wordplay.domain.service.WordService;

public class WordPlay {

	private final WordService wordService;
	private final List<String> specialWords;
	private final List<String> fiveLetterWords;
	
	public WordPlay(WordService wordService, List<String> specialWords, List<String> fiveLetterWords) {
		this.wordService = wordService;
		this.specialWords = specialWords;
		this.fiveLetterWords = fiveLetterWords;
	}

	public String hasVowel(String word) {
		return wordService.hasVowel(word) ?  "Van benne magánhangzó." :  "Nincs benne magánhangzó.";
	}
	
	public String getLongestWord() {
		String longestWord = wordService.getLongestWord();
		return String.format("A leghosszabb szó az állományban a(z) '%s', ami %d karakter hosszú.", 
				longestWord, longestWord.length()); 
	}
	
	public String getWordStatistic() {
		return String.format("%s%n%s", getSpecialWords(), wordService.getWordStatistic());
	}
	
	public String getLadderWords(String word) {
		return fiveLetterWords.stream().filter(i -> i.indexOf(word) == 1).collect(Collectors.joining(" "));
	}
	
	private String getSpecialWords() {
		return specialWords.stream().collect(Collectors.joining(" "));
	}
	
	public List<String> getAllLadderWords() {
		return createWordMap().entrySet().stream()
				.filter(i -> i.getValue().size() > 2)
				.map(Entry::getValue)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	private Map<String, List<String>> createWordMap() {
		Map<String, List<String>> wordMap = new HashMap<>();
		fiveLetterWords.forEach(word -> {
			String key = word.substring(1, 4);
			List<String> words = wordMap.containsKey(key) ? wordMap.get(key) : createWordList();
			words.add(word);
			wordMap.put(key, words);
		});
		return wordMap;
	}
	
	private List<String> createWordList() {
		List<String> words = new ArrayList<>();
		words.add("");
		return words;
	}
	
}
