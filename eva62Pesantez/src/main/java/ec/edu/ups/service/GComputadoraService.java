package ec.edu.ups.service;

import java.util.List;

import ec.edu.ups.modelo.Computadora;
import ec.edu.ups.negicio.GestionComputadora;
import ec.edu.ups.service.Error;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("computadora")
public class GComputadoraService {

	@Inject
	private GestionComputadora gestionComputadora;
	
	@GET
	@Path("listarComputadoras")
	@Produces("application/json")
	public List<Computadora> listaB (){
		return gestionComputadora.ListaBienesInmuebles();
	}
	
	@GET
	@Path("datos")
	@Produces("application/json")
	public Computadora Datos() {
		Computadora c = new Computadora();
		c.setMarca("HP");
		c.setColor("Blanco");
		c.setPrecio(1200);
		return c;
	}
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarComputadora(Computadora computadora) {
		try {
			gestionComputadora.guardarComputadoras(computadora);
			return Response.status(Response.Status.OK).entity(computadora).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
}
