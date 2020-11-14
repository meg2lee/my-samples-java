import java.util.Random;

public class forOps {

	public static void main(String[] args) {
		
		Random rd = new Random ();
		int i;
		int total = 0;
		
		for(int cnt = 0; cnt<10; total++ ) {
			i = rd.nextInt();
			if (i%2==0) {				
				System.out.printf("%d \n", i);
				cnt++;
			}
			System.out.printf("\nÃÑ ¹Ýº¹È½¼ö %d", total);
		}

	}

}
