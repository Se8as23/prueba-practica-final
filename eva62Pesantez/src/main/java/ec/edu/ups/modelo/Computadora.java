package ec.edu.ups.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Computadora {
	

		@Id
		@GeneratedValue
		@Column(name="id_Computadora")
		private int idComputadora;
		
		@Column
		private String marca;
		
		@Column
		private String color;
		
		@Column
		private int precio;
		

		public Computadora () {
			
		}


		public int getIdComputadora() {
			return idComputadora;
		}


		public void setIdComputadora(int idComputadora) {
			this.idComputadora = idComputadora;
		}


		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}


		public int getPrecio() {
			return precio;
		}


		public void setPrecio(int precio) {
			this.precio = precio;
		}


		@Override
		public String toString() {
			return "Computadora [idComputadora=" + idComputadora + ", marca=" + marca + ", color=" + color + ", precio="
					+ precio + "]";
		}



}
