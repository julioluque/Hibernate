package ar.jluque.hibernateorm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * MySql - ESTABLE 
 * Sql Server - ESTABLE
 * Oracle - INESTABLE (Identity)
 * @author Alfredo
 */

@Entity
@Table(name = "clientes")
public class Clientes {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)   // PARA SQL SERVER
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")          // PRUEBAS PARA ORACLE
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")		*/
	private int id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellidos")
	private String apellidos;

	@Column(name = "Direccion")
	private String direccion;

	public Clientes() {
	}

	public Clientes(String nombre, String apellidos, String direccion) {
		// Id es autoincremental
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}

}
