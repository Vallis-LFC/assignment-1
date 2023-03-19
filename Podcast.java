import java.util.ArrayList;

public class Podcast extends AudioContent{
public static final String TYPENAME =	"PODCAST";
	
	private String host; 
	private ArrayList<Season>seasons;
	private int currentSeason = 0;

	
	public Podcast(String title, int year, String id, String type, String audioFile, int length, String host, ArrayList<Season> seasons)
	{
		// Make use of the constructor in the super class AudioContent. 
		// Initialize additional AudioBook instance variables. 
		super(title,year,id,type,audioFile,length); 	//recalls the constructor in audiocontent
		//sets the other parameters and intializes the private variables.
		this.host = host;	
		this.seasons = seasons;

	}
	
	public String getType()
	{
		return TYPENAME;
	}

  // Print information about the audiobook. First print the basic information of the AudioContent 
	// by making use of the printInfo() method in superclass AudioContent and then print author and narrator
	// see the video
	public void printInfo()
	{
		super.printInfo();
		System.out.print(" Host: "+this.host);
		System.out.println("Seasons: "+this.seasons.size());
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

	
	//Two AudioBooks are equal if their AudioContent information is equal and both the author and narrators are equal
	public boolean equals(Object other)
	{
		Podcast other_book = (Podcast)other;
		return super.equals(other_book) && this.host.equals(other_book.host) ;
	
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


	public ArrayList<String> getEpisodeTitles()
	{
		return seasons.;
	}

	public void setChapterTitles(ArrayList<String> chapterTitles)
	{
		this.chapterTitles = chapterTitles;
	}

	public ArrayList<String> getChapters()
	{
		return chapters;
	}

	public void setChapters(ArrayList<String> chapters)
	{
		this.chapters = chapters;
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
