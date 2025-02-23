package inheritance;
/*
Journey Allison
2/15/2025
Sources:

*/
import java.util.ArrayList;
public class Movie extends Media{
	//Movie class represents a movie which is a type of media and extends it
	private String director;//who directed the movie
	private ArrayList<String> actors;//list of everyone who acted in the movie
	
	public Movie(int releaseYear, String writer,String director)
	{
		super(releaseYear,writer);//calls Media constructor and passes in the release year and writer
		this.director =director;
	}
	public String getDirector()
	{
		return this.director;//returns who directed the movie
	}
	@Override
	public String toString()
	{
		return "This movie wa writen by "+
			super.getWriter()+", directed by "+
			this.director+", and released in "+
			super.getReleaseYear();
		//gives detail on the director, writer, and release year of the movie
	}
}
