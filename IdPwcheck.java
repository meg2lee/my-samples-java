import java.util.Scanner;

public class IdPwcheck {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디와 비밀번호를 입력하시오");
		
		String idPw = sc.nextLine();
		String[] idPwArray = idPw.split(" ");
		
		boolean idOk = idPwArray[0].equals("Megan");
		boolean passOk = idPwArray[1].equals("0123");
		
		boolean result = idOk && passOk;
		
		String msg = result? "로그인 성공" : "로그인 실패";
		
		System.out.println(msg);
	}

}
