package test;

import model.Matriz;

public class TestComplementar {

	public static void Test22(){
		Matriz m1 = new Matriz(2,2);
		m1.set(0, 0, 1.0);
		m1.set(0, 1, 7.0);
		m1.set(1, 1, 1.0);
		m1.complementar();
		System.out.println(m1.toString());
		
	}
	
	public static void Test44(){
		Matriz m1 = new Matriz(4,4);
		m1.set(0, 0, 1.0);
		m1.set(0, 1, 2.0);
		m1.set(0, 2, 3.0);
		m1.set(0, 3, 4.0);
		m1.set(1, 1, 1.0);
		m1.set(1, 2, 2.0);
		m1.set(1, 3, 3.0);
		m1.set(2, 2, 1.0);
		m1.set(2, 3, 2.0);
		m1.set(3, 3, 1.0);
		m1.complementar();
		System.out.println(m1.toString());

	}
	public static void main (String args[]){
		Test44();
		
		
	}
}
