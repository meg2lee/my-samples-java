import java.util.Scanner;

public class IdPwcheck {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���̵�� ��й�ȣ�� �Է��Ͻÿ�");
		
		String idPw = sc.nextLine();
		String[] idPwArray = idPw.split(" ");
		
		boolean idOk = idPwArray[0].equals("Megan");
		boolean passOk = idPwArray[1].equals("0123");
		
		boolean result = idOk && passOk;
		
		String msg = result? "�α��� ����" : "�α��� ����";
		
		System.out.println(msg);
	}

}
