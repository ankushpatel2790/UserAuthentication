package com.transamerica.user.auth.serviceImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transamerica.user.auth.service.ICommonWordFinderService;
import com.transamerica.user.exe.framework.CompareFilesData;
import com.transamerica.user.file.readerwriter.IFileReaderWrite;

@Service
public class CommonWordFinderServiceImpl implements ICommonWordFinderService {

	@Autowired
	private IFileReaderWrite fileReaderWriter;

	private CompareFilesData compareRun = null;

	ExecutorService executor = Executors.newFixedThreadPool(5);

	@Override
	public List<String> findCommandWord(String filesPath) {
		ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
		String[] splitPath = filesPath.split(" ");
		List<String> primaryData = fileReaderWriter.read(splitPath[0], null);

		primaryData.forEach(s -> {
			map.put(s, true);
		});

		for (String s : splitPath) {
			try {
			Future<Boolean> future = executor.submit(new CompareFilesData(null,s,map));
			
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<String> result = map.keySet().stream().collect(Collectors.toList());
		return result;
	}

}
