package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.MapLibraryRepository;
import aiss.model.repository.LibraryRepository;
import aiss.modelo.Library;
import aiss.modelo.Book;

import java.net.URI;
import java.util.Collection;
import java.util.List;


@Path("/books")
public class BookResource {

	public static BookResource _instance=null;
	LibraryRepository repository;
	
	private BookResource(){
		repository=MapLibraryRepository.getInstance();
	}
	
	public static BookResource getInstance()
	{
		if(_instance==null)
			_instance=new BookResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Book> getAll()
	{
		return repository.getAllBooks();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Book get(@PathParam("id") String bookId)
	{
		Book Book = repository.getBook(bookId);
		if (Book == null) {
			throw new NotFoundException("The book with id="+ bookId +" was not found");			
		}
		return Book;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addBook(@Context UriInfo uriInfo, Book book) {
		if (book.getTitle() == null || "".equals(book.getTitle()))
			throw new BadRequestException("The name of the book must not be null");
		
		if (book.getSaga()==null && book.getAutor()==null && book.getYear()==null)
			throw new BadRequestException("The books property is not editable.");

		repository.addBook(book);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(book.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(book);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateBook(Book book) {
		Book oldbook = repository.getBook(book.getId());
		if (oldbook == null) {
			throw new NotFoundException("The library with id="+ book.getId() +" was not found");			
		}
		
		// Update name
		if (book.getTitle()!=null)
			oldbook.setTitle(book.getTitle());
		
		// Update description
		if (book.getAutor()!=null)
			oldbook.setAutor(book.getAutor());
		
		if (book.getSaga()!=null)
			oldbook.setSaga(book.getSaga());
		
		if (book.getYear()!=null)
			oldbook.setYear(book.getYear());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeBook(@PathParam("id") String bookId) {
		Book toberemoved=repository.getBook(bookId);
		if (toberemoved == null)
			throw new NotFoundException("The book with id="+ bookId +" was not found");
		else
			repository.deleteBook(bookId);
		
		return Response.noContent().build();
	}
	
}
