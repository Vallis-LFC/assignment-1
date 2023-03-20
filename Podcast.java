import java.util.ArrayList;

public class Podcast extends AudioContent{
public static final String TYPENAME =	"PODCAST";
	
	private String host; 
	private ArrayList<Season>seasons;
	private int currentSeason = 0;

	
	public Podcast(String title, int year, String id, String type, String audioFile, int length, String host, ArrayList<Season> seasons)
	{
		// Make use of the constructor in the super class AudioContent. 
		// Initialize additional Podcast instance variables. 
		super(title,year,id,type,audioFile,length); 	//recalls the constructor in audiocontent
		//sets the other parameters and intializes the private variables.
		this.host = host;	
		this.seasons = seasons;

	}
	
	public String getType()
	{
		return TYPENAME;
	}

  // Print information about the podcast. First print the basic information of the AudioContent 
	// by making use of the printInfo() method in superclass AudioContent and then print author and host
	// see the video
	public void printInfo()
	{
		super.printInfo();
		System.out.print("Host: "+this.host+"\n Seasons: "+this.seasons.size()+"\n");

	}

	
	
	
  // Play the podcast by setting the audioFile to the current episode title (from chapterTitles array list) 
	
	public void playEp(int episode, int season)
	{	
		super.setAudioFile(seasons.get(season).episodeFiles.get(episode)); //sets the chapter
		super.play();
	}
	
	// Print the table of contents of the book - i.e. the list of chapter titles
	// See the video
	public void printTOC(int season)																		
	{
		System.out.println("Seasons: "+this.seasons.size());
		for (int i = 0; i< seasons.get(season).episodeTitles.size() ;i++) {
			System.out.println("Episode "+(i+1)+" ."+this.seasons.get(season).episodeTitles.get(i));
			System.out.println();
		}
	}

	
	//Two AudioBooks are equal if their AudioContent information is equal and both the host and seasons are equal
	public boolean equals(Object other)
	{
		Podcast other_book = (Podcast)other;
		return super.equals(other_book) && this.host.equals(other_book.host) && this.seasons.equals(other_book.seasons);
	
	}
	
	public int getNumberOfEpisodes(int season)
	{
		return this.seasons.get(season).episodeTitles.size();
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public ArrayList<Season> getSeasons()
	{
		return seasons;
	}

	public ArrayList<String> getEpisodeTitles()
	{
		return seasons.get(currentSeason).episodeTitles;
	}

	public void setChapterTitles(ArrayList<String> chapterTitles)
	{
		this.seasons.get(currentSeason).episodeTitles = chapterTitles;
	}

	public ArrayList<String> getEpisodes()
	{
		return this.seasons.get(currentSeason).episodeFiles; 
	}

	public void setChapters(ArrayList<String> episodes)
	{
		this.seasons.get(currentSeason).episodeFiles = episodes;
	}

	// Select a specific chapter to play - nothing to do here
	public void selectChapter(int season)
	{
		if (season >= 1 && season <= seasons.size())
		{
			currentSeason = season - 1;
		}
	}
}
