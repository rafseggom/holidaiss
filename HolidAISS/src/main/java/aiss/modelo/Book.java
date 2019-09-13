package aiss.modelo;

public class Book {

	private String id;
	private String title;
	private String autor;
	private String saga;
	private String year;

	public Book() {
	}

	public Book(String title, String autor, String saga, String year) {
		this.title = title;
		this.autor = autor;
		this.saga = saga;
		this.year = year;
	}
	
	public Book(String id, String title, String autor, String saga, String year) {
		this.id=id;
		this.title = title;
		this.autor = autor;
		this.saga = saga;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSaga() {
		return saga;
	}

	public void setSaga(String saga) {
		this.saga = saga;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
