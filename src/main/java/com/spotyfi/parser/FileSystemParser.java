package com.spotyfi.parser;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemParser {
	
	private String pathFile;
	
	public FileSystemParser(String pathFile) {
		this.pathFile = pathFile;
	}
	
	public List<Path> getSubdirectory() {
		
		File file = new File(this.pathFile);
		
		File[] directories = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory())
					return true;
				
				return false;
			}
			
		});
		
		List<File> listSubdirectory = Arrays.asList(directories);
		
		List<Path> listPath = listSubdirectory.stream()
				.map(File::toPath).collect(Collectors.toList());
		
		return listPath;
	}

}
