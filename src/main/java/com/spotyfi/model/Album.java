package com.spotyfi.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Album {
	
	private final String albumName;
	private final int year;
	private final List<Song> listSongs = new ArrayList<>();
	
	public Album(String albumName, int year) {
		this.albumName = albumName;
		this.year = year;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public int getYear() {
		return year;
	}
	
	public void addSongs(List<Song> listSongs) {
		listSongs.addAll(listSongs);
	}
	
	public void addSong(Song song) {
		listSongs.add(song);
	}
	
	public List<Song> getListSongs() {
		List<Song> listSongsReturn = new ArrayList<>();
		
		Iterator<Song> listIter = listSongs.iterator();
		
		while(listIter.hasNext()) {
			listSongsReturn.add(listIter.next());
		}
		
		return listSongsReturn;
	}

	@Override
	public String toString() {
		return "Album [albumName=" + albumName + ", year=" + year + ", listSongs=" + listSongs + "]";
	}
	
	
}
