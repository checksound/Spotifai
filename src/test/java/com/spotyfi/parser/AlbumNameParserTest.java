package com.spotyfi.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlbumNameParserTest {

	@Test
	void testGetAlbumInfo() {
		// fail("Not yet implemented");
		
		AlbumNameParser albumNameParser = new AlbumNameParser();
		
		AlbumNameParser.AlbumInfo albumInfo = 
				albumNameParser.getAlbumInfo("Bollicine_1983");
		
		assertEquals("Bollicine", albumInfo.albunName);
		assertEquals(1983, albumInfo.albumYear);
		
		albumInfo = 
				albumNameParser.getAlbumInfo("Bollicine");
		
		assertEquals("Bollicine", albumInfo.albunName);
		assertEquals(0, albumInfo.albumYear);
		
		albumInfo = 
				albumNameParser.getAlbumInfo("Cosa_succede_in_citta_1985");
		
		assertEquals("Cosa succede in citta", albumInfo.albunName);
		assertEquals(1985, albumInfo.albumYear);
		
		albumInfo = 
				albumNameParser.getAlbumInfo("Cosa_succede_in_citta");
		
		assertEquals("Cosa succede in citta", albumInfo.albunName);
		assertEquals(0, albumInfo.albumYear);
		
	}

}
