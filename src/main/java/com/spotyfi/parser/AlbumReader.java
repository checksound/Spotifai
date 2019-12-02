package com.spotyfi.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.spotyfi.model.Album;
import com.spotyfi.model.Song;

public class AlbumReader {
	
	public Album doReadAlbum(Path pathAlbum) throws AlbumParserException {
		String baseNameFile = 
				FilenameUtils.getBaseName(pathAlbum.toString());
		
		File fileAlbum = pathAlbum.toFile();
		
		List<String> linesAlbum = new ArrayList<>();
		
		try (BufferedReader in
				   = new BufferedReader(new FileReader(fileAlbum))){
			
			String line = null;
						
			while ((line = in.readLine())!= null) {
				if(line.trim().equals("")) {
					continue;
				}
				
				linesAlbum.add(line);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			throw new AlbumParserException("Error opening file", e);
		} catch (IOException e) {
			throw new AlbumParserException("Error reading file", e);
		}
		
		List<Song> listSongs = new AlbumParser().doGetSongs(linesAlbum);
		
		Album album = new Album(baseNameFile, 0);
		album.addSongs(listSongs);
		return album;
	}

}
