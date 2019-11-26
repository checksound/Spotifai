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
		
		FileSystemParser fsp = new FileSystemParser();
		
		List<Path> listPathSubdirectories = fsp.getSubdirectory(pathName);
		
		assertEquals(2, listPathSubdirectories.size());
		
		Path pathLigabue = Paths.get("./tests/test_subdirectories", "Ligabue");
		Path pathVasco = Paths.get("./tests/test_subdirectories", "Vasco_Rossi");
		Path pathJannacci = Paths.get("./tests/test_subdirectories", "Jannacci_Enzo");
		
		assertTrue(listPathSubdirectories.contains(pathLigabue));
		assertTrue(listPathSubdirectories.contains(pathVasco));
		assertFalse(listPathSubdirectories.contains(pathJannacci));
				
	}
	
	@Test
	void testGetFilesInDirectory() {
		
        String pathDir = "./tests/test_files_in_directory";
		
        Path pDir = Paths.get(pathDir);
        FileSystemParser fsp = new FileSystemParser();
		
		List<Path> filesInDirectory = fsp.getFilesInDirectory(pDir, "txt");
		
		Path pathFileBollicine = Paths.get(pathDir, "Bollicine.txt");
		Path pathFileCosaSuccede = Paths.get(pathDir, "Cosa_succede_in_citta.txt");
		Path pathFileVadoInMessico = Paths.get(pathDir, "Vado_in_messico.txt");
		
		assertEquals(2, filesInDirectory.size());
		assertTrue(filesInDirectory.contains(pathFileBollicine));
		assertFalse(filesInDirectory.contains(pathFileCosaSuccede));
		assertTrue(filesInDirectory.contains(pathFileVadoInMessico));
	}

}
