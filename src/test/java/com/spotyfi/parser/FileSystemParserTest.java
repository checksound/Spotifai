package com.spotyfi.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileSystemParserTest {

	@Test
	void testGetSubdirectory() {
		// fail("Not yet implemented");
		String pathName = "./tests/test_subdirectories";
		
		FileSystemParser fsp = new FileSystemParser(pathName);
		
		List<Path> listPathSubdirectories = fsp.getSubdirectory();
		
		assertEquals(2, listPathSubdirectories.size());
		
		Path pathLigabue = Paths.get("./tests/test_subdirectories", "Ligabue");
		Path pathVasco = Paths.get("./tests/test_subdirectories", "Vasco_Rossi");
		Path pathJannacci = Paths.get("./tests/test_subdirectories", "Jannacci_Enzo");
		
		assertTrue(listPathSubdirectories.contains(pathLigabue));
		assertTrue(listPathSubdirectories.contains(pathVasco));
		assertFalse(listPathSubdirectories.contains(pathJannacci));
				
	}

}
