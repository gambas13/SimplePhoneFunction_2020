import java.util.Scanner;
class RSC {
	Scanner sc=new Scanner(System.in);
	String user;
	RSC(){
		user=null;
	}
	public void rsc() {
		String user;
		int n;
		String [] str= {"가위","바위","보"};
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.(\"그만\": 종료)");
		while(true) {
			System.out.print("가위 바위 보!>>");
			user=sc.next();
			if(user.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}
			n=(int)(Math.random()*3);
			System.out.print("사용자 = "+user+" , 컴퓨터 = "+str[n]);
			if(str[n].equals("가위")) {
				if(user.equals("가위"))
					System.out.println(", 비겼습니다.");
				else if(user.equals("바위"))
					System.out.println(", 사용자가 이겼습니다.");
				else if(user.equals("보"))
					System.out.println(", 컴퓨터가 이겼습니다.");
			}
			else if(str[n].equals("바위")) {
				if(user.equals("가위"))
					System.out.println(", 컴퓨터가 이겼습니다.");
				else if(user.equals("바위"))
					System.out.println(", 비겼습니다.");
				else if(user.equals("보"))
					System.out.println(", 사용자가 이겼습니다.");
			}
			else if(str[n].equals("보")) {
				if(user.equals("가위"))
					System.out.println(", 사용자가 이겼습니다.");
				else if(user.equals("바위"))
					System.out.println(", 컴퓨터가 이겼습니다.");
				else if(user.equals("보"))
					System.out.println(", 비겼습니다.");
			}
		}
	}
}