package model;

public class Score {
	private String nombre;
	private Double score;
	
	public Score(String n, Double s){
		nombre = n;
		score = s;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	public String toString(){
		return (this.nombre+":"+this.score);
	}
}
