import java.util.Arrays;
import java.util.Random;

public class ArrayInOrder {

	public static void main(String[] args) {
	
		Random rd = new Random ();
		int a[] = new int [10];
		int fromto=0;
		
		for (int i=0;i<a.length;) {
			a[i] = rd.nextInt(20)+1;
		}
		 System.out.println(Arrays.toString(a));	
			
			for (int cnt=0;cnt<a.length-1;cnt++) {
				for (int cmp=cnt+1;cmp<a.length;cmp++) {
					if (a[cnt] < a[cmp]) {
						fromto = a[cnt];
						a[cnt] = a[cmp];
						a[cmp] = fromto;
					}
				}			
			}	System.out.println(Arrays.toString(a));					
		}	
	}	
