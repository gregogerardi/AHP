package model;
import java.util.List;
import java.util.Vector;

public class Matriz {
	protected int maxFilas;
	protected int maxColumnas;
	protected double[][] matriz;
	
	public Matriz(int mf, int mc){ //le llega la lista de string de las opciones de pc o de alternativas, y todas las matrices tienen el mismo orden
		maxFilas = mf;
		maxColumnas = mc;
		matriz = new double [maxFilas][maxColumnas];
	}

	public int filas(){
		return maxFilas;
	}
	
	
	public int columnas(){
		return maxColumnas;
	}
	
	public double get (int f, int c){
		return matriz[f][c];
	}
	
	public void set (int f, int c, double d){
		matriz[f][c] = d;
	
	}
	

	
	public double getPromedioFila(int f){
		double totalFila= 0.0;
		for (int c=0; c<maxColumnas; c++){
			totalFila = totalFila + matriz [f][c]; 
		}
		return totalFila/maxColumnas;
	}
	
	public double getPromedioColumna(int c){
		double totalColumna= 0.0;
		for (int f=0; f<maxFilas; f++){
			totalColumna = totalColumna + matriz [f][c]; 
		}
		return totalColumna/maxFilas;
	}
	
	public double sumaFila(int f){
		double salida = 0.0;
		for (int c=0; c<maxColumnas; c++){
			salida= salida + matriz[f][c];
		}
		return salida;
	}
	
	public double sumaColumna(int c){
		double salida = 0.0;
		for (int f=0; f<maxFilas; f++){
			salida = salida + matriz [f][c];
		}
		return salida;
	}
	private void Normalizar(){ // Normaliza la matriz modificandola permanentemente
		//System.out.println("se normaliza la matriz :"+this.toString());
		double[][] salida=new double[this.maxFilas][this.maxColumnas];
		for (int f=0; f<maxFilas; f++)
			for (int c=0; c<maxColumnas; c++){
				salida[f][c]= this.get(f, c)/this.sumaColumna(c);
			}
		matriz=salida;
	}
	
	public Vector<Double> getVector(){ // Devuelve el promedio de cada fila en un vector
		this.Normalizar();
		Vector<Double> salida = new Vector<>();
		for (int f=0; f<maxFilas; f++){
			salida.add(this.getPromedioFila(f));
		}
		return salida;
	}
	

	public void complementar (){
		for (int f = 1; f<this.filas(); f++){
			for (int c=0; c<f; c++){
				this.set(f, c, 1/this.get(c, f));
			}
		}
	}
	
	public void addFila(Vector<Double>vect){ //Este metodo tenia el mismo problema que addColumna 
		double[][] nueva = new double[maxFilas+1][vect.size()];
		for (int f=0; f<maxFilas; f++)
			for (int c=0; c<maxColumnas; c++){
				nueva[f][c] = matriz[f][c];
			}
		for (int c=0; c<vect.size(); c++){
			nueva[maxFilas][c]=vect.get(c);
		}
		this.maxFilas++;
		if(this.maxColumnas==0)
			this.maxColumnas=vect.size();
		matriz = nueva;
	}
	
	public void addColumna(Vector<Double>vect){ 
		//Agrega una columna a la matriz. Puede tener problemas si agregamos una columna con
		// un largo inapropiado. (El vector tiene que tener el mismo size que la matriz excepto
		// cuando la matriz es inicializada como new matriz(0,0,null);
		double[][] nueva = new double[vect.size()][maxColumnas+1];
		for (int f=0; f<maxFilas; f++)
			for (int c=0; c<maxColumnas; c++){
				nueva[f][c] = matriz[f][c];
			}
		for (int f=0; f<vect.size(); f++){
			nueva[f][maxColumnas]=vect.get(f);
		}
		this.maxColumnas++;
		if(this.maxFilas==0)
			this.maxFilas=vect.size();
		matriz = nueva;
	}
	public String toString(){ //PARA MOSTRAR LA MATRIZ
		String text="[";
		for(int i=0;i<this.maxFilas;i++){
			for(int j=0;j<this.maxColumnas;j++){
				text=text+this.matriz[i][j];
				if(j+1!=this.maxColumnas)
					text=text+",";
			}
		if(i+1!=this.maxFilas)
			text=text+"\n";
		}
			text=text+"]";
		return text;
	}
	/*public boolean Consistencia() {	//se tiene que llamar con la matriz sin normalizar
		Matriz matrizNueva = clone(this);
		Vector<Double> vector = getVector();
		Vector<Double> primeraInstancia = new Vector<Double>();
		for (int i = 0 ; i < maxFilas ; i++)
		{
			for (int j = 0 ; j < maxColumnas ; j++)
			{
				primeraInstancia.add(i, primeraInstancia.get(i) + matrizNueva.get(i, j) * vector.get(j));
			}
		}
		double promedio = 0;
		for (int i = 0 ; i < maxFilas ; i++)
		{
			promedio += primeraInstancia.get(i) / vector.get(i);
		}
		promedio = ( (promedio / maxFilas ) - opciones.size() ) / (opciones.size()-1);
		double indiceAleatorio = getIndiceAleatorio(opciones.size());
		promedio = promedio / indiceAleatorio;
		if (promedio < 0.1)
			return true;
		else
			return false;
	}*/

	
	public double getIndiceAleatorio(int size) {// Devuelve una aproximacion del RI. Extraida de internet(No estaba en las filminas)
		return (1.98*(size-2))/size;
	}
	public Matriz clone(Matriz mat){
		Matriz matrizNueva = new Matriz(mat.maxFilas,mat.maxColumnas);
		for(int i=0;i<matrizNueva.maxFilas;i++)
			for(int j=0;j<matrizNueva.maxColumnas;j++)
				matrizNueva.set(i, j,mat.get(i, j));
		return matrizNueva;
	}
	
}
