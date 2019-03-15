package hu.wordplay;

import java.util.Scanner;

import hu.wordplay.controller.WordPlay;
import hu.wordplay.domain.service.AbstractDataReader;
import hu.wordplay.domain.service.Console;
import hu.wordplay.domain.service.DataWriter;
import hu.wordplay.domain.service.FiveLetterWordReader;
import hu.wordplay.domain.service.SpecialWordReader;
import hu.wordplay.domain.service.WordService;

public class App {

	private final WordPlay wordPlay;
	private final Console console;
	private final DataWriter writer;
	
	public App() {
		console = new Console(new Scanner(System.in));
		WordService wordService = new WordService();
		AbstractDataReader specialWordReader = new SpecialWordReader(wordService);
		AbstractDataReader fiveLetterWordReader = new FiveLetterWordReader();
		wordPlay = new WordPlay(wordService, specialWordReader.read("szoveg.txt"), 
				fiveLetterWordReader.read("szoveg.txt"));
		writer = new DataWriter("letra.txt");
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		String word = console.read("1. feladat: K�rem adjon meg egy sz�t: ");
		System.out.println(wordPlay.hasVowel(word));
		System.out.println("2. feladat: " + wordPlay.getLongestWord());
		System.out.println("3. feladat: Speci�lis szavak: " + wordPlay.getWordStatistic());
		word = console.read("4. feladat: K�rem adja meg a l�tra fok�t: ");
		System.out.println(wordPlay.getLadderWords(word));
		writer.printAll(wordPlay.getAllLadderWords());
	}

}
