package aiss.model.repository;

import java.util.Collection;

import aiss.modelo.Library;
import aiss.modelo.Book;

public interface LibraryRepository {
	
	
	// Books
	public void addBook(Book b);
	public Collection<Book> getAllBooks();
	public Book getBook(String bookId);
	public void updateBook(Book b);
	public void deleteBook(String bookId);
	
	// Librarys
	public void addLibrary(Library l);
	public Collection<Library> getAllLibraries();
	public Library getLibrary(String playlistId);
	public void updateLibrary(Library l);
	public void deleteLibrary(String playlistId);
	public Collection<Book> getAll(String playlistId);
	public void addBook(String playlistId, String bookId);
	public void removeBook(String playlistId, String bookId); 

	
	
	
	

}
