import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * This class manages, stores, and plays audio content such as songs, podcasts and audiobooks. 
 */
public class Library
{
	private ArrayList<Song> 			songs; 
	private ArrayList<AudioBook> 	audiobooks;
	private ArrayList<Playlist> 	playlists; 
	
//	private ArrayList<Podcast> 	podcasts;
	
	// Public methods in this class set errorMesg string 
	// Error Messages can be retrieved from main in class MyAudioUI by calling  getErrorMessage()
	// In assignment 2 we will replace this with Java Exceptions
	String errorMsg = "";
	
	public String getErrorMessage()
	{
		return errorMsg;
	}

	public Library()
	{
		songs 			= new ArrayList<Song>(); 
		audiobooks 	= new ArrayList<AudioBook>(); ;
		playlists   = new ArrayList<Playlist>();
		//podcasts		= new ArrayList<Podcast>(); ;
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs, podcasts and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/podcast/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public boolean download(AudioContent content)
	{
		if(content.getType() == "AUDIOBOOK") {
			for (int i = 0; i<audiobooks.size();i++) {
				if (content.getTitle().equals(audiobooks.get(i).getTitle())) {
					return false;
				}
			}
			AudioBook download = (AudioBook) content;
			audiobooks.add(download);
		}
		else if (content.getType() == "SONG") {
			for (int i = 0; i<songs.size();i++) {
				if (content.getTitle().equals(songs.get(i).getTitle())) {
					return false;
				}
			}
			Song download = (Song) content;
			songs.add(download);
		}
		
		//for podcast
		else if (content.getType() == "SONG") {
			for (int i = 0; i<songs.size();i++) {
				if (content.getTitle().equals(songs.get(i).getTitle())) {
					return false;
				}
			}
			Song download = (Song) content;
			songs.add(download);
		}
		return true;
	}
	
	// Print Information (printInfo()) about all songs in the array list
	public void listAllSongs()
	{
		for (int i = 0; i < songs.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println(""+ "\n");	
		}
	}
	
	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		for (int i = 0; i< this.audiobooks.size();i++) {
			int index = i+1;
			System.out.print("" + index + ". ");
			this.audiobooks.get(i).printInfo();
			System.out.println();
		}
	}
	
  // Print Information (printInfo()) about all podcasts in the array list
//	public void listAllPodcasts()
//	{
//		for (int i = 0; i<this.podcasts.size();i++) {
//			this.podcasts.get(i).printInfo();
//		}
//	}
	
  // Print the name of all playlists in the playlists array list
	// First print the index number as in listAllSongs() above
	public void listAllPlaylists()
	{
		for (int i = 0; i < this.playlists.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			this.playlists.get(i).getTitle();
			System.out.println();	
		}
	}
	
  // Print the name of all artists. 
	/**
	 * prints the name of all artists
	 */
	public void listAllArtists()
	{
		// First create a new (empty) array list of string 
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist arrayl ist is complete, print the artists names
		ArrayList<String> artists = new ArrayList<String>();
		for (int i = 0;i<this.songs.size();i++) {
			if (artists.contains(this.songs.get(i).getArtist())) {
				continue;	//if it is inside the list, it will continue and skip the line below
			}
			artists.add(this.songs.get(i).getArtist()); //adds the artist to the list
		}
		for (int i = 0; i<artists.size();i++) {
			System.out.println((i+1)+". "+artists.get(i)); 	//prints the artist in the list
		}
	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public boolean deleteSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		this.songs.remove(index);
		for (int i = 0; i<this.playlists.size();i++) { //loops through all playlists to ensure none of them are left out.
			for (int x = 0; x<this.playlists.get(i).getContent().size();x++) { // loops through the playlist to find the song
				if (playlists.get(i).getContent().get(x).equals(this.songs.get(index)) && this.playlists.get(i).getContent().get(x).getType().equals("SONG")) { //checks if equal and checks if type is song 
					this.playlists.get(i).getContent().remove(x);	//removes the song in the playlist
					return true;
			}
			}
			
		}
		return false;
	}
	
  //Sort songs in library by year
	public void sortSongsByYear()
	{
		// Use Collections.sort() 
		Collections.sort(this.songs,new SongYearComparator());
	
	}
  // Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	private class SongYearComparator implements Comparator <Song>
	{

		public int compare(Song song1, Song other) {
			return song1.getYear() - other.getYear();
		}

	}
	

	// Sort songs by length
	public void sortSongsByLength()
	{
	 // Use Collections.sort() 
		Collections.sort(this.songs,new SongLengthComparator());
	}
  // Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{

	@Override
	public int compare(Song song1, Song other) {
		
		return song1.getLength() - other.getLength();
	}
		
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
	  // Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
		
		Collections.sort(this.songs);
		
	}

	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public boolean playSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		System.out.println("did this repeat");
		songs.get(index-1).play();
		return true;
	}
	
	// Play podcast from list (specify season and episode)
	// Bonus
	public boolean playPodcast(int index, int season, int episode)
	{
		return false;
	}
	
	// Print the episode titles of a specified season
	// Bonus 
	public boolean printPodcastEpisodes(int index, int season)
	{
		return false;
	}
	
	// Play a chapter of an audio book from list of audiobooks
	public boolean playAudioBook(int index, int chapter)
	{
		if (index < 1 || index > audiobooks.size()) //checks if the audiobook is inside the list
		{
			errorMsg = "AudioBook Not Found";
			return false;
		}
		this.audiobooks.get(index-1).selectChapter(chapter);//sets the current chapter
		this.audiobooks.get(index-1).play();
		return true;
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public boolean printAudioBookTOC(int index)
	{
		if (index < 1 || index > audiobooks.size()) //checks if the audiobook is inside the list
		{
			errorMsg = "AudioBook Not Found";
			return false;
		}
		
		
		this.audiobooks.get(index-1).printTOC();
		return true;
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public boolean makePlaylist(String title)
	{
		for (int i = 0; i<playlists.size();i++) {
			if(playlists.get(i).getTitle().equals(title)) {
				errorMsg = "Playlist " +title+" Already Exists";
				return false;
			}
		}
		Playlist newPl = new Playlist(title);
		playlists.add(newPl);
		return true;
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public boolean printPlaylist(String title)
	{
		for (int i = 0; i<this.playlists.size();i++) {
			System.out.println("in loop");
			if(playlists.get(i).getTitle().equals(title)) {
				playlists.get(i).printContents();
				return true;
			}
		}
		errorMsg = "Playlist Not Found";
		return false;
	}
	
	// Play all content in a playlist
	public boolean playPlaylist(String playlistTitle)
	{
		for (int i = 0; i<this.playlists.size();i++) {
			if(playlists.get(i).getTitle().equals(playlistTitle)) {
				playlists.get(i).playAll();
				return true;
			}
		}
		errorMsg = "Playlist Not Found";
		return false;
	}
	
	// Play a specific song/audiobook in a playlist
	public boolean playPlaylist(String playlistTitle, int indexInPL)
	{
		for (int i = 0; i<this.playlists.size();i++) {
			if (playlists.get(i).getTitle().equals(playlistTitle)) {
				playlists.get(i).play(indexInPL);
				return true;
//				else if (type.equalsIgnoreCase("PODCAST")) {
//					playlists.get(i).addContent(podcasts.get(index));
//				}
			}
		}
		return false;
	}
	
	// Add a song/audiobook/podcast from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public boolean addContentToPlaylist(String type, int index, String playlistTitle)
	{
		for (int i = 0; i<this.playlists.size();i++) {
			if (playlists.get(i).getTitle().equals(playlistTitle)) {
				if (type.equalsIgnoreCase("AUDIOBOOK")) {
					playlists.get(i).addContent(audiobooks.get(index));
				}
				else if (type.equalsIgnoreCase("SONG")) {
					playlists.get(i).addContent(songs.get(index));
				}
//				else if (type.equalsIgnoreCase("PODCAST")) {
//					playlists.get(i).addContent(podcasts.get(index));
//				}
				return true;
			}
			
		}
		return false;
	}

  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid 
	public boolean delContentFromPlaylist(int index, String title)
	{
		for (int i = 0; i<this.playlists.size();i++) {
			if (playlists.get(i).getTitle().equals(title)) {
					playlists.get(i).deleteContent(index);
				return true;
			}
		}
		return false;
	}
	
}