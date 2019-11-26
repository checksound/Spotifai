package com.spotyfi.app;

import java.nio.file.Path;
import java.util.List;

import com.spotyfi.parser.FileSystemParser;

public class Appl {

	public static void main(String[] args) {
				
		String pathName = "C:\\Users\\PC610\\Dropbox";
		
		FileSystemParser fsp = new FileSystemParser();
		
		List<Path> listPathSubdirectories = fsp.getSubdirectory(pathName);
		
		
	}

}
