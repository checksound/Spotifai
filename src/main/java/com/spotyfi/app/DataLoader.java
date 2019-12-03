package com.spotyfi.app;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.spotyfi.model.Album;
import com.spotyfi.model.Author;
import com.spotyfi.parser.AlbumParserException;
import com.spotyfi.parser.AlbumReader;
import com.spotyfi.parser.AuthorParser;
import com.spotyfi.parser.FileSystemParser;

public class DataLoader {
	
	private final class OEntry<K, V> implements Map.Entry<K, V> {
	    private final K key;
	    private V value;

	    public OEntry(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    @Override
	    public K getKey() {
	        return key;
	    }

	    @Override
	    public V getValue() {
	        return value;
	    }

	    @Override
	    public V setValue(V value) {
	        V old = this.value;
	        this.value = value;
	        return old;
	    }
	}
	
	private OEntry<Author, List<Album>> getAuthorAlbums(Path pathAuthor) 
			throws AlbumParserException {
		
		AuthorParser aP = new AuthorParser();
		String authorName = aP.getAuthorName(pathAuthor);
		Author author = new Author(authorName);
		
		FileSystemParser pSp = new FileSystemParser();
		List<Path> listFilesPath = pSp.getFilesInDirectory(pathAuthor, "txt");
		
		List<Album> listAlbum = new ArrayList<Album>();
		
		for (Path pathAlbum: listFilesPath) {
			Album album = new AlbumReader().doReadAlbum(pathAlbum);
			listAlbum.add(album);			
		}
		
		return new OEntry<Author, List<Album>>(author, listAlbum);
	}

	public Map<Author, List<Album>> load(String path) {
		
		FileSystemParser fSp = new FileSystemParser();
		List<Path> pathAuthors = fSp.getSubdirectories(path);
		
		Map<Author, List<Album>> map = 
				new TreeMap<Author, List<Album>>();
		
		for(Path pathAuthor: pathAuthors) {

			try {
				OEntry<Author, List<Album>> entry = getAuthorAlbums(pathAuthor);
				map.put(entry.getKey(), entry.getValue());
			} catch (AlbumParserException e) {
				System.out.println("Problem with path: " + pathAuthor +
						" - " + e.getMessage());
			}
			
			
		}
		
		return map;
	}
}
