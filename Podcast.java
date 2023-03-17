//import java.util.ArrayList;
//
//public class Podcast extends AudioContent{
//public static final String TYPENAME =	"PODCAST";
//	
//	private String host; 
//	private String narrator;
//	private ArrayList<String> Seasons;
//	private ArrayList<String>episodeTitles;
//	private ArrayList<String>episodes;
//
//	
//	public Podcast(String title, int year, String id, String type, String audioFile, int length,
//									String host, ArrayList<String> episodeTitles, ArrayList<String> episodes,ArrayList<String> seasons)
//	{
//		// Make use of the constructor in the super class AudioContent. 
//		// Initialize additional AudioBook instance variables. 
//		super(title,year,id,type,audioFile,length); 	//recalls the constructor in audiocontent
//		//sets the other parameters and intializes the private variables.
//		this.host = host;	
//		this.episodeTitles = episodeTitles;
//		this.episodes = episodes;
//		this.Seasons = seasons;
//
//	}
//	
//	public String getType()
//	{
//		return TYPENAME;
//	}
//
//  // Print information about the audiobook. First print the basic information of the AudioContent 
//	// by making use of the printInfo() method in superclass AudioContent and then print author and narrator
//	// see the video
//	public void printInfo()
//	{
//		super.printInfo();
//		System.out.print(" Host: "+this.host);
//		System.out.println("Seasons: "+this.Seasons.size());
//	}
//
//	
//	
//	
//  // Play the podcast by setting the audioFile to the current episode title (from chapterTitles array list) 
//	// followed by the current epis (from chapters array list)
//	// Then make use of the the play() method of the superclass
//	public void play()
//	{
//		System.out.println("did this repeat");
//		super.setAudioFile(.get(currentChapter)); //sets the chapter
//		super.play();
//	}
//	
//	// Print the table of contents of the book - i.e. the list of chapter titles
//	// See the video
//	public void printTOC()																		//return to this
//	{
//		System.out.println("did this repeat");
//		for(int i =0; i<this.chapterTitles.size();i++) {
//			System.out.println("Chapter "+(i+1)+". "+chapterTitles.get(i));
//			System.out.println();
//		}
//	}
//
//	// Select a specific chapter to play - nothing to do here
//	public void selectChapter(int chapter)
//	{
//		if (chapter >= 1 && chapter <= chapters.size())
//		{
//			currentChapter = chapter - 1;
//		}
//	}
//	
//	//Two AudioBooks are equal if their AudioContent information is equal and both the author and narrators are equal
//	public boolean equals(Object other)
//	{
//		AudioBook other_book = (AudioBook)other;
//		return super.equals(other_book) && this.author.equals(other_book.author) && this.narrator.equals(other_book.narrator);
//	
//	}
//	
//	public int getNumberOfChapters()
//	{
//		return chapters.size();
//	}
//
//	public String getAuthor()
//	{
//		return author;
//	}
//
//	public void setAuthor(String author)
//	{
//		this.author = author;
//	}
//
//	public String getNarrator()
//	{
//		return narrator;
//	}
//
//	public void setNarrator(String narrator)
//	{
//		this.narrator = narrator;
//	}
//
//	public ArrayList<String> getChapterTitles()
//	{
//		return chapterTitles;
//	}
//
//	public void setChapterTitles(ArrayList<String> chapterTitles)
//	{
//		this.chapterTitles = chapterTitles;
//	}
//
//	public ArrayList<String> getChapters()
//	{
//		return chapters;
//	}
//
//	public void setChapters(ArrayList<String> chapters)
//	{
//		this.chapters = chapters;
//	}
//
//}
