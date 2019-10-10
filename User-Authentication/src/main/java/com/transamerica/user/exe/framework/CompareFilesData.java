package com.transamerica.user.exe.framework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.transamerica.user.file.readerwriter.IFileReaderWrite;

public class CompareFilesData implements Callable<Boolean> {
	private ConcurrentHashMap<String, Boolean> wordSet;
	private String filePath;
	private String fileName;
	@Autowired
	private IFileReaderWrite fileReaderWriter;

	public CompareFilesData(String fileName,String filePath, ConcurrentHashMap<String, Boolean> wordSet) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.wordSet = wordSet;
	}

	@Override
	public Boolean call() throws Exception {
		List<String> tempWords = fileReaderWriter.read(filePath, fileName);
		wordSet.forEach((K, V) -> {
			if (!tempWords.contains(K)) {
				wordSet.put(K, false);
			}
		});
		return true;
	}

}
