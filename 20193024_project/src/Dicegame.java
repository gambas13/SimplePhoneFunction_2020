import java.util.Scanner;
public class Dicegame {
	Scanner sc=new Scanner(System.in);
	public void startDice() {
		int user;
		int com;
		int choose1;
		int choose2;
		System.out.println("주사위 게임을 시작합니다. ");
		while(true) {
			System.out.print("옵션을 선택해주세요: 1) 랜덤으로 굴리기, 2) 사용자가 직접 선택하기, 3) 종료: ");
			choose1=sc.nextInt();
			if(choose1==1) {
				user=(int)(Math.random()*6)+1;
				com=(int)(Math.random()*6)+1;
			}
			else if(choose1==2) {
				com=(int)(Math.random()*6)+1;
				System.out.print("주사위 숫자를 입력해주세요: ");
				user=sc.nextInt();
			}
			else if(choose1==3) {
				System.out.println("게임이 종료됩니다.");
				break;}
			else {
				System.out.println("번호를 잘못 입력하셨습니다.");
				continue;
			}
			while(true) {
			System.out.print("게임룰을 선택해주세요: 1) 큰 수가 승리, 2) 작은 수가 승리: ");
			choose2=sc.nextInt();
			if(choose2==1) {
				if(user>com) {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("사용자가 승리했습니다!");
				}
				else if(user==com) {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("비겼습니다!");
				}
				else {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("컴퓨터가 승리했습니다!");
				}
				break;	
			}
			else if(choose2==2) {
				if(user<com) {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("사용자가 승리했습니다!");
				}
				else if(user==com) {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("비겼습니다!");
				}
				else {
					System.out.println("사용자의 주사위: "+user);
					System.out.println("컴퓨터의 주사위: "+com);
					System.out.println("컴퓨터가 승리했습니다!");
				}
				break;
			}
			else {
				System.out.println("잘못된 숫자를 입력하셨습니다.");
				continue;
			}
			}continue;
		}
	}
}
