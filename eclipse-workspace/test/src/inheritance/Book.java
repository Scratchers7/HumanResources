package inheritance;
/*
Journey Allison
2/15/2025
Sources:

*/
public class Book extends Media{
	//Book class represents a book which extends the media class
	private String publisher;//what company or person published the book
	private String coverArtist;//who illustrated the cover of the book
	public Book(int releaseYear, String writer,String publisher, String coverArtist)
	{
		super(releaseYear,writer);//calls Media constructor and passes in the release year and writer
		this.publisher = publisher;
		this.coverArtist = coverArtist;
	}
	public String getPublisher()
	{
		return this.publisher;//returns what company or person published the book
	}
	public String getCoverArtist()
	{
		return this.coverArtist;//returns who illustrated the cover of the book
	}
	@Override
	public String toString()
	{
		return super.getWriter()+
				" wrote this book. The Cover Artist is "+
				this.coverArtist+". It was published in "+
				super.getReleaseYear()+" by "+
				this.publisher;//gives details on the cover artist, publisher, and superClass variables like writer and release year
	}
}
