package sorting;

public final class SelectionSortIntroduction {
	
	private SelectionSortIntroduction(){}

	private static void selectionSort(int[] x) {
	    for (int i=0; i<x.length-1; i++) {
	        int minIndex = i; // Index of smallest remaining value.
	        for (int j=i+1; j<x.length; j++) 
	            if (x[minIndex] > x[j]) 
	                minIndex = j; // Remember index of new minimum
	        if (minIndex != i) { 
	            // Exchange current element with smallest remaining.
	            int temp = x[i];
	            x[i] = x[minIndex];
	            x[minIndex] = temp;
	        }
	    }
	}
	
	private static void printIt(int[] ia){
		String sIa="";
		for (int i = 0; i < ia.length; i++) sIa +=(ia[i] + " ");
		System.out.println(sIa);
	}
	
	public static void main(String[] l){
		int[] ia = Tools.genArray(10);
		selectionSort(ia);
		printIt(ia);
	}
}