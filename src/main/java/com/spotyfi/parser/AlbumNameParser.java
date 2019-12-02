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
		
		String[] albumNameSplit = albumFileName.split("_");
		
		if(albumNameSplit.length == 1) {
			return new AlbumInfo(albumFileName, 0);
		}
		
		if(albumNameSplit.length == 2) {
			String lastPart = albumNameSplit[1];
			
			boolean isNumeric = false;
			int valueYear = 0;
			try {
				valueYear = Integer.parseInt(lastPart);
				isNumeric = true;
			} catch (NumberFormatException e) {
				
			}
			
			if(isNumeric)
				return new AlbumInfo(albumNameSplit[0], valueYear);
			else
				return new AlbumInfo(albumFileName, 0);
		}
		
		if(albumNameSplit.length > 2) {
			String lastPart = albumNameSplit[albumNameSplit.length - 1];
			
			boolean isNumeric = false;
			int valueYear = 0;
			try {
				valueYear = Integer.parseInt(lastPart);
				isNumeric = true;
			} catch (NumberFormatException e) {
				
			}
			
			String accString = albumNameSplit[0];
			int lenght = isNumeric? 
					albumNameSplit.length - 1: albumNameSplit.length;
			
			for(int i = 1; i < lenght; i++) {
				accString += (" " + albumNameSplit[i]);
			}
			
			if(isNumeric)
				return new AlbumInfo(accString, valueYear);
			else
				return new AlbumInfo(accString, 0);
			
		}
		
		return new AlbumInfo("", 0);
	}

}
