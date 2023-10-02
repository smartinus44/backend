package org.redhat.consensus.namevalidator;

import java.util.List;
import java.net.URI;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.inject.Inject;
import io.quarkus.logging.Log;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

	@Inject
	ProductRepository repository;

	@GET
	public List<Product> list() {
		return repository.listAll();
	}

	@POST
	@Transactional
	public Response create(Product product) {
		repository.persist(product);
		Log.info("A product has been created " + product.toString() + ".");
		return Response.created(URI.create("/products/" + product.id)).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public void delete(Long id) {
		Product entity = repository.findById(id);
		if (entity == null) {
			throw new NotFoundException();
		}
		if (repository.isPersistent(entity)) {
			repository.delete(entity);
		}
	}
}