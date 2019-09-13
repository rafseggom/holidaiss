package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSOutput;

import aiss.modelo.Library;
import aiss.modelo.Book;


public class MapLibraryRepository implements LibraryRepository{

	Map<String, Library> libraryMap;
	Map<String, Book> bookMap;
	private static MapLibraryRepository instance=null;
	private int index=0;			// Index to create librarys and books' identifiers.
	
	
	public static MapLibraryRepository getInstance() {
		
		if (instance==null) {
			instance = new MapLibraryRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		libraryMap = new HashMap<String,Library>();
		bookMap = new HashMap<String,Book>();
		
		// Create books
		Book philosopherStone=new Book();
		philosopherStone.setTitle("Harry Potter and the Philosopher's Stone");
		philosopherStone.setAutor("J.K.Rowling");
		philosopherStone.setYear("1997");
		philosopherStone.setSaga("Harry Potter");
		addBook(philosopherStone);
		
		Book gameOfThrones=new Book();
		gameOfThrones.setTitle("A Game of Thrones");
		gameOfThrones.setAutor("George R.R.Martin");
		gameOfThrones.setYear("1996");
		gameOfThrones.setSaga("Game of Thrones");
		addBook(gameOfThrones);
		
		Book fellowshipRing=new Book();
		fellowshipRing.setTitle("The Fellowship of the Ring");
		fellowshipRing.setAutor("J.R.R.Tolkien");
		fellowshipRing.setYear("1954");
		fellowshipRing.setSaga("The Lord of the Rings");
		addBook(fellowshipRing);
		
		Book mazeRunner=new Book();
		mazeRunner.setTitle("Maze Runner");
		mazeRunner.setAutor("James Dashner");
		mazeRunner.setSaga("Maze Runner");
		mazeRunner.setYear("2009");
		addBook(mazeRunner);
		
		Book worldWarZ=new Book();
		worldWarZ.setTitle("World War Z: An Oral History of the Zombie War");
		worldWarZ.setAutor("Max Brooks");
		worldWarZ.setYear("2006");
		worldWarZ.setSaga("-none-");
		addBook(worldWarZ);
		
		// Create libraries
		Library jalibrary=new Library();
		jalibrary.setName("AISSLibrary");
		jalibrary.setDescription("AISS Library");
		addLibrary(jalibrary);
		
		Library library = new Library();
		library.setName("Favourites");
		library.setDescription("A sample library");
		addLibrary(library);
		
		// Add books to libraries
		addBook(jalibrary.getId(), philosopherStone.getId());
		addBook(jalibrary.getId(), gameOfThrones.getId());
		addBook(jalibrary.getId(), mazeRunner.getId());
		addBook(jalibrary.getId(), fellowshipRing.getId());
		
		addBook(library.getId(), fellowshipRing.getId());
		addBook(library.getId(), worldWarZ.getId());
	}
	
	// Library related operations
	@Override
	public void addLibrary(Library l) {
		String id = "l" + index++;	
		l.setId(id);
		libraryMap.put(id,l);
	}
	
	@Override
	public Collection<Library> getAllLibraries() {
			return libraryMap.values();
	}

	@Override
	public Library getLibrary(String id) {
		return libraryMap.get(id);
	}
	
	@Override
	public void updateLibrary(Library p) {
		libraryMap.put(p.getId(),p);
	}

	@Override
	public void deleteLibrary(String id) {	
		libraryMap.remove(id);
	}
	

	@Override
	public void addBook(String libraryId, String bookId) {
		Library library = getLibrary(libraryId);
		library.addBook(bookMap.get(bookId));
	}

	@Override
	public Collection<Book> getAll(String libraryId) {
		return getLibrary(libraryId).getBooks();
	}

	@Override
	public void removeBook(String libraryId, String bookId) {
		getLibrary(libraryId).deleteBook(bookId);
	}

	
	// Book related operations
	
	@Override
	public void addBook(Book b) {
		String id = "b" + index++;
		b.setId(id);
		bookMap.put(id, b);
	}
	
	@Override
	public Collection<Book> getAllBooks() {
			return bookMap.values();
	}

	@Override
	public Book getBook(String bookId) {
		return bookMap.get(bookId);
	}

	@Override
	public void updateBook(Book s) {
		Book book = bookMap.get(s.getId());
		book.setTitle(s.getTitle());
		book.setSaga(s.getSaga());
		book.setAutor(s.getAutor());
		book.setYear(s.getYear());
	}

	@Override
	public void deleteBook(String bookId) {
		bookMap.remove(bookId);
	}
	
}
