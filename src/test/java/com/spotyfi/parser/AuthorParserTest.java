package com.spotyfi.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class AuthorParserTest {

	@Test
	void testGetAuthorName() {
		AuthorParser aP = new AuthorParser();
		
		Path pathAut1 = Paths.get("./tests/test_subdirectories", "Vasco_Rossi");
		String authorName = aP.getAuthorName(pathAut1);
		
		assertEquals("Vasco Rossi", authorName);
		
		pathAut1 = Paths.get("./tests/test_subdirectories", "Giovanni_Lindo_Ferretti");
		authorName = aP.getAuthorName(pathAut1);
		
		assertEquals("Giovanni Lindo Ferretti", authorName);
		
		
	}

}
