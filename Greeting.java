import java.util.Scanner;

public class Greeting {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("���̵� �Է����ּ���");
		String userID = sc.nextLine();
		greeting(userID);
		
	}
	public static String greeting (String userID) {
		userID += "�� ȯ���մϴ�";
		return userID;
	}
}
