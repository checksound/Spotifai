package com.spotyfi.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.spotyfi.model.Song;

class AlbumParserTest {
	
	@Test
	void testGetDuration() {
		AlbumParser fAp = new AlbumParser();
		int duration = -1;
		try {
			duration = fAp.calculateDuration("07:23");
		} catch (AlbumParserException e) {
			e.printStackTrace();
			
			fail("Exception: " + e.getMessage());
		}
		assertEquals(443, duration);
	}

	@Test
	void testDoGetSongFromLine() 
			throws AlbumParserException {
		// fail("Not yet implemented");
		
		AlbumParser fAp = new AlbumParser();
		Song song = fAp.doGetSongFromLine("Bollicine;07:23");
		
		assertEquals("Bollicine", song.getTitle());
		assertEquals(443, song.getLength());
	}
	
	@Test
	void testDoGetListOfSongsFromContentAlbum() 
			throws AlbumParserException {
		
		AlbumParser fAp = new AlbumParser();
		List<String> listSongs = Arrays.asList(new String[] {
				"Bollicine;07:23", "Una canzone per te;06:19"
		});
		
		List<Song> listOfSongs = fAp.doGetSongs(listSongs);
		
		assertEquals(2, listSongs.size());
		assertEquals(new Song("Bollicine", 443), listOfSongs.get(0));
		assertEquals(new Song("Una canzone per te", 379), listOfSongs.get(1));
	}

}
