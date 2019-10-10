package com.transamerica.user.file.readerwriter;

import java.util.List;

public interface IFileReaderWrite {
public List<String> read(String filePath,String fileName);
public void write(String filePath,String fileName);
}
