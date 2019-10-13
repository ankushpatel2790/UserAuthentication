package com.transamerica.user.exe.framework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListMap;

import com.transamerica.user.file.readerwriter.IFileReaderWrite;

public class CompareFilesData implements Callable<Boolean> {
	private ConcurrentSkipListMap <String, Boolean> wordSet;
	private String filePath;
	private String fileName;

	public CompareFilesData() {
		super();
	}

	private IFileReaderWrite fileReaderWriter;

	public CompareFilesData(String fileName, String filePath, ConcurrentSkipListMap <String, Boolean> wordSet,
			IFileReaderWrite fileReaderWriter) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.wordSet = wordSet;
		this.fileReaderWriter = fileReaderWriter;
	}

	@Override
	public Boolean call() throws Exception {
		List<String> tempWords = fileReaderWriter.read(filePath, fileName);
		wordSet.forEach((K, V) -> {
			if (!tempWords.contains(K)) {
				wordSet.remove(K);
			}
		});
		return true;
	}

}
