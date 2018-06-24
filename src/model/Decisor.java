package model;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class Decisor {
	private List<Matriz> matricesAlternativas; //matrices de comparaciones de alternativas para cada criterio
	private List<Pc> alternativas; //lista con los modelos que cumplen los filtros
	private List<Criterio> criterios;
	private Escala escala;
	
	public Decisor (List<Pc> alternativas ){
		this.alternativas = alternativas;
		matricesAlternativas = new ArrayList<>();
		escala = new Escala();
	}

	public void setCriterios (List<Criterio> criterios){
		this.criterios = criterios;
	}
	
	public void addMatriz(Matriz m){
		matricesAlternativas.add(m);
		
	}
	

	public Matriz getMatrizComparacionCriterios(List<Criterio> criterios){
		//HACE UNA MATRIZ PARA LOS CRITERIOS PADRES.SI ALGUN CRITERIO TIENE SUBCRITERIOS SE GENERA UNA MATRIZ APARTE
		//Y SE LA REFERENCIA DESDE EL CRITERIO
		Matriz matrizCriteriosLocal = new Matriz(criterios.size(), criterios.size());
		for (int f=0; f<criterios.size(); f++){
			Criterio c1 = criterios.get(f);
			List<Criterio> comparaciones = c1.getComparados();
			//System.out.println( "f vale "+f+" "+c1.nombre+ " "+comparaciones.size());
			//SE COMPARA CON EL MISMO
			int c = f;
			matrizCriteriosLocal.set(f, c, 1.0);
			c++;
			//SE COMPARA CON LAS DEMAS COMPARACIONES QUE TENGA EL CRITERIO
			while (c<=comparaciones.size()){
				Criterio c2 = comparaciones.remove(0);
				matrizCriteriosLocal.set(f, c, c1.getComparacion(c2));
				c++;
			}
		    //SI TIENE SUBCRITERIOS SE LLAMA RECURSIVAMENTE A ESTE METODO Y SE GUARDA ESA MATRIZ DE RETORNO EN EL CRITERIO PADRE
			//System.out.println("venia generando la matriz "+ matrizCriterios.toString());
			List<Criterio> subcriterios = c1.getSubcriterios();
			if (!subcriterios.isEmpty()){
				Matriz m = this.getMatrizComparacionCriterios(subcriterios);
				//System.out.println("setea la matriz "+m.toString() );
				c1.setMatriz(m);
			}

		}
		matrizCriteriosLocal.complementar();
		return matrizCriteriosLocal;
	}
	
		
	private List<Criterio> aplanarCriterios(){
		//DEVUELVE TODOS LOS CRITERIOS HOJAS
		List<Criterio> salida = new ArrayList<>();
		for (Criterio c:criterios){
			salida.addAll(c.getHojas());
		}
		return salida;
	}
	
	 //COMPARACION PAREADA ENTRE ALTERNATIVAS
	public void compararAlternativas(){     
		List<Criterio> criteriosHojas = this.aplanarCriterios();
		for (Criterio c: criteriosHojas) {
			String atributo = c.getNombre();
			Matriz m = new Matriz (alternativas.size(), alternativas.size());
			//COMPARAR CADA PC RESPECTO A OTRA POR EL DATO PASADO Y DESPUES COMPLEMENTAR
			for (int j=0; j<alternativas.size(); j++){
				for (int k=j; k<alternativas.size(); k++){
					if (k==j){
						m.set(j, k, 1.0);
					}
					else {
						Double v1 = (Double) alternativas.get(j).get(atributo);
						Double v2 = (Double) alternativas.get(k).get(atributo);
						Double valorBuscado = (Double) c.getValor();
						Double maxValor = getMax(atributo);
						Double dif1= Math.abs(valorBuscado - v1)/maxValor; 
						Double dif2= Math.abs(valorBuscado - v2) /maxValor;
						Double valorFinal1;
						Double valorFinal2;
						if (dif1<=dif2){
							valorFinal1=escala.get(dif2-dif1);
							valorFinal2= (1/valorFinal1);
						}
						else {
							valorFinal2=escala.get(dif1-dif2);
							valorFinal1= (1/valorFinal2);
						}
						m.set(j, k, valorFinal1);
						m.set(k, j, valorFinal2);

					}
				}
			}
			matricesAlternativas.add(m);
		}
	}
	
	private Matriz generarMatrizFinal(List<Vector<Double>> vectores, Vector<Double> ponderacionesCriterios){
		Matriz salida = new Matriz (0,0);
		for (int i=0; i<vectores.size(); i++){
			salida.addColumna(vectores.get(i));
		}
		salida.addFila(ponderacionesCriterios);
		return salida;
	}
	
	private Vector<Score> getScores(Matriz m){
		Vector <Score> salida = new Vector<Score>();
		for (int f=0; f<m.filas()-1; f++){
			Score nuevo = new Score ((String)alternativas.get(f).get("modelo"), 0.0);
			for (int c=0; c<m.columnas(); c++){
				double s = nuevo.getScore()+m.get(f, c)*m.get(m.filas()-1, c); //multiplica cada casillero de la fila por cada casillero de la ultima fila
				nuevo.setScore(s);
			}
			salida.add(nuevo);
		}
		return salida;
	}
	
	private Vector<Double> getPonderacionesCriteriosHojas(){
		Vector<Double> salida = new Vector<Double>();
		for (Criterio c:criterios){
		
			salida.addAll(c.getPonderaciones());
		}
		return salida;
	}
	
	private Double getMax(String atributo){
		Double max = -1.0;
		for (Pc pc: alternativas){
			if ((Double)pc.get(atributo)>max)
				max = (Double)pc.get(atributo);
			}
		return max;
	}
	
	private void setComparacionCriterios(List<Criterio> criterios, Matriz matrizComparadora){
	//OBTIENE EL VECTOR DE COMPARACION DE CRITERIOS PARA TODOS LOS CRITERIOS DE UN NIVEL Y SI TIENE SUBCRITERIOS LLAMA RECURSIVAMENTE
		Vector<Double> comps = matrizComparadora.getVector();
		for (int i = 0; i<criterios.size(); i++){
			criterios.get(i).setPonderacion(comps.get(i));
			if (!criterios.get(i).getSubcriterios().isEmpty())
				setComparacionCriterios(criterios.get(i).getSubcriterios(),criterios.get(i).getMatriz());
		}

	}
	
	
	public Vector<Score> calcular(Matriz matrizCriterios){
		List<Vector<Double>> vectores = new ArrayList<>();
		//OBTIENE EL VECTOR DE CADA MATRIZ DE ALTERNATIVAS
		for (Matriz m: matricesAlternativas){   
			Vector <Double> v = m.getVector();
			vectores.add(v);
		}
		//OBTIENE EL VECTOR DE COMPARACION DE CRITERIOS PARA TODOS LOS CRITERIOS DEL NIVEL SUPERIOR, TENGAN O NO SUBCRITERIOS
		setComparacionCriterios(criterios, matrizCriterios);
		Vector<Double> ponderacionCriteriosFinales = this.getPonderacionesCriteriosHojas();
		List<Criterio> criteriosFinales = this.aplanarCriterios();
		for (int i = 0; i<criteriosFinales.size(); i++){
			criteriosFinales.get(i).setPonderacion(ponderacionCriteriosFinales.get(i));
		}
		//GENERA LA MATRIZ FINAL 
		Matriz scores = this.generarMatrizFinal(vectores, ponderacionCriteriosFinales);
		Vector<Score> salida = this.getScores(scores);
		salida.sort(new ComparadorScores());
		
		return salida;		
	}
}
