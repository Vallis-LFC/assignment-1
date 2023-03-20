import java.util.ArrayList;

public class Season extends AudioContent{
	public static final String TYPENAME = "SEASON";
	
	public ArrayList<String>episodeTitles;
	public ArrayList<Integer>episodeLengths;
	public ArrayList<String>episodeFiles;
	
	public Season(ArrayList<String> eptitles, ArrayList<Integer>eplength, ArrayList<String> epfiles) {
		this.episodeFiles = epfiles;
		this.episodeTitles = eptitles;
		this.episodeLengths = eplength;
	}
	
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