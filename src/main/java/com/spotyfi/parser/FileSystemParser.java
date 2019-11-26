package com.spotyfi.parser;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class FileSystemParser {
	
	public List<Path> getSubdirectory(String pathFile) {
		
		File file = new File(pathFile);
		
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
	
	// fake implementation
	/*
	public List<Path> getFilesInDirectory(Path pathDir, String extension) {
		return new ArrayList<Path>();
	}
	*/
	
	public List<Path> getFilesInDirectory(Path pathDir, String extension) {
		
		File file = pathDir.toFile();
		
		File[] directories = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory())
					return false;
				
				if (extension != null)
				  return FilenameUtils.isExtension(pathDir.getFileName().toString(), extension);
				
				return true;
			}
			
		});
		
		List<File> listSubdirectory = Arrays.asList(directories);
		
		List<Path> listPath = listSubdirectory.stream()
				.map(File::toPath).collect(Collectors.toList());
		
		return listPath;
	}
	
}
