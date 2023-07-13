package ec.edu.ups.negicio;

import java.util.List;

import ec.edu.ups.dao.ComputadoraDAO;
import ec.edu.ups.modelo.Computadora;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionComputadora {
	@Inject
	private ComputadoraDAO daoComputadora;
	
	public void guardarComputadoras(Computadora computadora) throws Exception {
		if(!this.isCodigoValido	(computadora.getIdComputadora()))
			throw new Exception("Codigo Incorrecto");
		
		if(daoComputadora.read(computadora.getIdComputadora()) == null) {
			try {
				daoComputadora.insert(computadora);
			}catch(Exception e){
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoComputadora.update(computadora);
			}catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	
	
	
	
	private boolean isCodigoValido(int idBienInmueble) {
		return idBienInmueble == 0 || idBienInmueble != 0;
	}
	
	
	public List<Computadora> ListaBienesInmuebles (){
		 return daoComputadora.getAll();
	}
}
