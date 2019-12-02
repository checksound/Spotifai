package com.spotyfi.parser;

import java.util.ArrayList;
import java.util.List;

import com.spotyfi.model.Song;

public class AlbumParser {
	
	/*
	int calculateDuration(String durationString) {
		return 0;
	}
	*/
	
	int calculateDuration(String durationString) 
			throws AlbumParserException {
		
		durationString = durationString.trim();
		
		if(durationString.length() != 5) {
			throw new AlbumParserException("Invalid format line: " + 
					durationString + ", invalid length");
		}
		
		int index = durationString.indexOf(':');
		if(index != 2)
			throw new AlbumParserException("Invalid format line: " + 
					durationString);
		
		try {
			String minutesPart = durationString.substring(0, 2);
			String secondsPart = durationString.substring(3);
			
			int minutes = Integer.parseInt(minutesPart);
			int seconds = Integer.parseInt(secondsPart);
			
			int duration = minutes * 60 + seconds;
			return duration;
		} catch (NumberFormatException e) {
			throw new AlbumParserException("Invalid format line: " + 
					durationString);
		}
	}
	
	Song doGetSongFromLine(String lineAlbum) 
			throws AlbumParserException {
		
		if(lineAlbum == null)
			throw new IllegalArgumentException("");
		
		int index = lineAlbum.lastIndexOf(';');
		if(index == -1)
			throw new AlbumParserException("Invalid format line: " + lineAlbum);
		
		if(index == (lineAlbum.length() -1))
			throw new AlbumParserException("Invalid format line: " + lineAlbum);
		
		String songName = lineAlbum.substring(0, index);
		String durationString = lineAlbum.substring(index + 1);
		
		int duration = calculateDuration(durationString);
		return new Song(songName, duration);
	}
	
	public List<Song> doGetSongs(List<String> listLinesAlbum) 
			throws AlbumParserException {
		
		List<Song> listAlbumSongs = new ArrayList<>();
		
		for(String line: listLinesAlbum) {
			listAlbumSongs.add(doGetSongFromLine(line));
		}
		
		return listAlbumSongs;
	}
}
