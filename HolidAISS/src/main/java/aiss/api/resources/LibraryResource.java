package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.MapLibraryRepository;
import aiss.model.repository.LibraryRepository;
import aiss.modelo.Library;
import aiss.modelo.Book;


@Path("/libs")
public class LibraryResource {
	
	/* Singleton */
	private static LibraryResource _instance=null;
	LibraryRepository repository;
	
	private LibraryResource() {
		repository=MapLibraryRepository.getInstance();

	}
	
	public static LibraryResource getInstance()
	{
		if(_instance==null)
				_instance=new LibraryResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Library> getAll()
	{
		return repository.getAllLibraries();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Library get(@PathParam("id") String id)
	{
		Library list = repository.getLibrary(id);
		
		if (list == null) {
			throw new NotFoundException("The library wit id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLibrary(@Context UriInfo uriInfo, Library library) {
		if (library.getName() == null || "".equals(library.getName()))
			throw new BadRequestException("The name of the library must not be null");
		
		if (library.getBooks()!=null)
			throw new BadRequestException("The books property is not editable.");

		repository.addLibrary(library);

		// Builds the response. Returns the library the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(library.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(library);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateLibrary(Library library) {
		Library oldlibrary = repository.getLibrary(library.getId());
		if (oldlibrary == null) {
			throw new NotFoundException("The library with id="+ library.getId() +" was not found");			
		}
		
		if (library.getBooks()!=null)
			throw new BadRequestException("The books property is not editable.");
		
		// Update name
		if (library.getName()!=null)
			oldlibrary.setName(library.getName());
		
		// Update description
		if (library.getDescription()!=null)
			oldlibrary.setDescription(library.getDescription());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeLibrary(@PathParam("id") String id) {
		Library toberemoved=repository.getLibrary(id);
		if (toberemoved == null)
			throw new NotFoundException("The library with id="+ id +" was not found");
		else
			repository.deleteLibrary(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{libraryId}/{bookId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addBook(@Context UriInfo uriInfo,@PathParam("libraryId") String libraryId, @PathParam("bookId") String bookId)
	{				
		
		Library library = repository.getLibrary(libraryId);
		Book book = repository.getBook(bookId);
		
		if (library==null)
			throw new NotFoundException("The library with id=" + libraryId + " was not found");
		
		if (book == null)
			throw new NotFoundException("The book with id=" + bookId + " was not found");
		
		if (library.getBook(bookId)!=null)
			throw new BadRequestException("The book is already included in the library.");
			
		repository.addBook(libraryId, bookId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(libraryId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(library);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{libraryId}/{bookId}")
	public Response removeBook(@PathParam("libraryId") String libraryId, @PathParam("bookId") String bookId) {
		Library library = repository.getLibrary(libraryId);
		Book book = repository.getBook(bookId);
		
		if (library==null)
			throw new NotFoundException("The library with id=" + libraryId + " was not found");
		
		if (book == null)
			throw new NotFoundException("The book with id=" + bookId + " was not found");
		
		
		repository.removeBook(libraryId, bookId);		
		
		return Response.noContent().build();
	}
}
