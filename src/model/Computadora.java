package model;
import java.util.Hashtable;

public class Computadora {
	private String modelo;
	private String marca;
	private Double precio;
	private Double pantalla;
	private String procesador;
	private Integer ram;
	private Double autonomia;
	private Hashtable<String, Integer> conectividad; //puertos y cantidad, o list<String> solo?
	private Double velocidad;
	private Double peso;
	private Integer capacidad;
	
	
	
	public Computadora() {
		super();
	}
	
	
	public Computadora(String modelo, String marca, Double precio, Double pantalla, String procesador, Integer ram,
			Double autonomia, Hashtable<String, Integer> conectividad, Double velocidad, Double peso,
			Integer capacidad) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.pantalla = pantalla;
		this.procesador = procesador;
		this.ram = ram;
		this.autonomia = autonomia;
		this.conectividad = conectividad;
		this.velocidad = velocidad;
		this.peso = peso;
		this.capacidad = capacidad;
	}


	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getPantalla() {
		return pantalla;
	}
	public void setPantalla(Double pantalla) {
		this.pantalla = pantalla;
	}
	public String getProcesador() {
		return procesador;
	}
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}
	public Hashtable<String, Integer> getConectividad() {
		return conectividad;
	}
	public void setConectividad(Hashtable<String, Integer> conectividad) {
		this.conectividad = conectividad;
	}
	public Double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
