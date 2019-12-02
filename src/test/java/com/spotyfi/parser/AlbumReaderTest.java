package com.spotyfi.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.spotyfi.model.Album;
import com.spotyfi.model.Song;

class AlbumReaderTest {

	@Test
	void testDoReadAlbum() {
		Path pathAlbum = Paths.get("./tests/test_content_album", 
				"Bollicine.txt");
		
		try {
			Album album = new AlbumReader().doReadAlbum(pathAlbum);
			
			assertEquals("Bollicine", album.getAlbumName());
			
			List<Song> listSongs = album.getListSongs();
			
			assertEquals(8, listSongs.size());
			
			/*
			 
			  	Bollicine;07:23
				Una canzone per te;06:19
				Portatemi Dio;02:56
				Vita spericolata;09:34
				Deviazioni;06:32
				Giocala;08:01
				Ultimo domicilio conosciuto;07:21
				Mi piaci perché;05:34
			 
			 */
			
			assertEquals(new Song("Bollicine", 443), listSongs.get(0));
			assertEquals(new Song("Mi piaci perché", 334), listSongs.get(7));
			
			
		} catch (AlbumParserException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	void testDoReadAlbumParsingNameName() {
		Path pathAlbum = Paths.get("./tests/test_album_name", 
				"Bollicine_1983.txt");
		
		try {
			Album album = new AlbumReader().doReadAlbum(pathAlbum);
			
			assertEquals("Bollicine", album.getAlbumName());
			assertEquals(1983, album.getYear());
			
			List<Song> listSongs = album.getListSongs();
			
			assertEquals(8, listSongs.size());
			
			assertEquals(new Song("Bollicine", 443), listSongs.get(0));
			assertEquals(new Song("Mi piaci perché", 334), listSongs.get(7));
			
			
		} catch (AlbumParserException e) {
			fail(e.getMessage());
		}
		
	}

}
