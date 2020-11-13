import java.util.Scanner;

public class Greeting {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("아이디를 입력해주세요");
		String userID = sc.nextLine();
		greeting(userID);
		
	}
	public static String greeting (String userID) {
		userID += "님 환영합니다";
		return userID;
	}
}
