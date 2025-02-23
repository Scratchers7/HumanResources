package inheritance;
/*
Journey Allison
2/15/2025
Sources:

*/
public class Media {
	//Class represents different forms of media
	private int releaseYear;//year the media was released
	private String writer;//who wrote the media
	
	public Media(int releaseYear, String writer)
	{
		this.releaseYear = releaseYear;
		this.writer = writer;
	}
	public int getReleaseYear()
	{
		return releaseYear;//return the year the media was released
	}
	public String getWriter()
	{
		return writer;//returns who wrote the media
	}
	@Override
	public String toString()
	{
		return writer+" wrote this media and released it in "+releaseYear;//basic toString gives all details about the media
	}
}
