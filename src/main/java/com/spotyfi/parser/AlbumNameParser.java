package com.spotyfi.parser;

public class AlbumNameParser {
	
	public class AlbumInfo {
		
		public final String albunName;
		public final int albumYear;
		
		public AlbumInfo(String albunName, int albumYear) {
			this.albunName = albunName;
			this.albumYear = albumYear;
		}
			
	}
	
	public AlbumInfo getAlbumInfo(String albumFileName) {
		
		return new AlbumInfo("", 0);
	}

}
