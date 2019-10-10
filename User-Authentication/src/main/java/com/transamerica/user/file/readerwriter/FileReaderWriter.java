package com.transamerica.user.file.readerwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public  class FileReaderWriter implements IFileReaderWrite{

	@Override
	public List<String> read(String filePath, String fileName) {
		List<String> hs = new ArrayList<>();
		// This will reference one line at a time
		String line = null;
		if(null!=fileName && !fileName.isEmpty())
			filePath+=fileName;
			

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filePath);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String[] splitLine = null;
			while ((line = bufferedReader.readLine()) != null) {

				splitLine = line.split(" ");
				for (String word : splitLine)
					hs.add(word);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		return hs;
	}

	@Override
	public void write(String filePath, String fileName) {
		// TODO Auto-generated method stub

	}

}
