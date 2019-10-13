package com.transamerica.user.auth.serviceImpl;

import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
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
	CountDownLatch countDown=new CountDownLatch(2);

	@Override
	public List<String> findCommandWord(String filesPath) {
		ConcurrentSkipListMap <String, Boolean> map = new ConcurrentSkipListMap <>(String.CASE_INSENSITIVE_ORDER);
		String[] splitPath = filesPath.split(" ");
		List<String> primaryData = fileReaderWriter.read(splitPath[0], null);

		primaryData.forEach(s -> {
			map.put(s, true);
		});

		for (int i=1;i<splitPath.length;i++) {
			try {
		   Future<Boolean> submit = executor.submit(new CompareFilesData(null,splitPath[i],map,fileReaderWriter));
		   submit.get();
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<String> result = map.keySet().stream()
				.collect(Collectors.toList());
		return result;
	}

}
