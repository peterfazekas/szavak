package hu.wordplay.domain.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataReader {

	public List<String> read(String fileName) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			lines = process(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public abstract List<String> process(BufferedReader br) throws IOException;
}
