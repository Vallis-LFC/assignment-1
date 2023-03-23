//Vallis King Hang Luong
//501214102


import java.util.ArrayList;

public class Season extends AudioContent{
	public static final String TYPENAME = "SEASON";
	
	//initializes the arraylists
	public ArrayList<String>episodeTitles;
	public ArrayList<Integer>episodeLengths;
	public ArrayList<String>episodeFiles;
	
	/**
	 * creates a season with the paramters
	 * 
	 * @param eptitles
	 * @param eplength
	 * @param epfiles
	 */
	public Season(ArrayList<String> eptitles, ArrayList<Integer>eplength, ArrayList<String> epfiles) {
		this.episodeFiles = epfiles;
		this.episodeTitles = eptitles;
		this.episodeLengths = eplength;
	}
	
	/**
	 * creates a season without parameters
	 */
	public Season() {
		this.episodeFiles = new ArrayList<String>();
		this.episodeTitles = new ArrayList<String>();
		this.episodeLengths = new ArrayList<Integer>();
	}
	
	@Override
	public String getType() {
		
		return TYPENAME;
	}

}