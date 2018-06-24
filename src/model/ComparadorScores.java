package model;
import java.util.Comparator;
public class ComparadorScores implements Comparator<Score>{
	//COMPARA PARA ORDENAR LA SALIDA DE FORMA DESCENDENTE, POR ESO SE LA MULTIPLICA POR -1
	public int compare(Score s1, Score s2) {
		return -1* s1.getScore().compareTo(s2.getScore());
	}

	
}
