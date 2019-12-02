package com.spotyfi.parser;

import java.nio.file.Path;

public class AuthorParser {
	
	public String getAuthorName(Path dirAuthor) {
		
		Path fileName = dirAuthor.getFileName();
		String fileNameStr =fileName.toString();
		fileNameStr = fileNameStr.replace("_", " ");
		return fileNameStr;
	}

}
