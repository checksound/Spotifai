package com.spotyfi.app;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.spotyfi.model.Album;
import com.spotyfi.model.Author;

class DataLoaderTest {

	@Test
	void testLoad() {
		
		DataLoader aB = new DataLoader();
		Map<Author, List<Album>> map = aB.load("./tests/case_1");
		System.out.println(map);
	}

}
