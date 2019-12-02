package com.spotyfi.parser;

public class AlbumParserException extends Exception {
	
	public AlbumParserException(String message) {
		super(message);
	}
	
	public AlbumParserException(String message, Exception ex) {
		super(message, ex);
	}
	
}
