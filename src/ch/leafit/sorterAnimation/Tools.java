package ch.leafit.sorterAnimation;

import java.util.Random;

public final class Tools {
	
	private Tools(){}
	
	private static Random rand = new Random();
	
	public static int[] genArray(int n){
		int[] ia= new int[n];
		for(int i=0; i<n;i++)ia[i]=Math.abs(rand.nextInt()%200);
		return ia;	
	}
}
