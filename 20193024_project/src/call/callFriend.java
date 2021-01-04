package call;
import java.util.Scanner;
public class callFriend extends Call{
	static private String[] fnum=new String[30];//check호출하고 show호출
	static private String[] fname=new String[30];
	Scanner sc=new Scanner(System.in);
	public callFriend() {
		for(int i=0;i<30;i++) {
			fnum[i]=" ";
			fname[i]=" ";
		}
	}
	@Override
	public void startCall() {
		Check();
		int n;
		while(true) {
		while(true) {
		System.out.print("옵션을 선택해주세요: 1)친구에게 전화걸기  2)친구 전화번호부 보기  3)번호 삭제하기  4)번호 추가하기 5)취소: ");
		n=sc.nextInt();//2번째 실행될 때 no such element exception 에러발생:
		if(n<1||n>5)
			System.out.println("잘못 입력하셨습니다.");
		else
			break;
		}
		if(n==5) {
			System.out.println("취소되었습니다.");
			break;
		}//친구전화 menu
		switch (n) {
		case 1:
			calling();
			break;
		case 2:
			show();
			break;
		case 3:
			remove();
			break;
		case 4:
			Check();
			break;
	
		}
		}
	}
	@Override
	public void Check() {
		if(fnum[0].equals(" ")) {
			System.out.println("친구목록이 비어있습니다.");
		}
		else if(!(fnum[fnum.length-1].equals(" "))) {
			System.out.println("친구 전화번호부가 가득 찼습니다.");
			System.out.println("저장되어있는 전화번호 갯수: "+fsize);
			return;
		}
		System.out.print("친구를 추가하시겠습니까? (y/n): ");
		String y=sc.next();
		if(y.equals("n"))
			return;
		else {
		System.out.println("친구를 추가합니다.");
		for(int j=0;j<fnum.length;j++)
				if(fnum[j].equals(" ")) {
					System.out.print("이름을 입력해주세요: ");
					fname[j]=sc.next();
					System.out.print("전화번호를 입력해주세요: ");
					fnum[j]=sc.next();
					System.out.println("저장되었습니다.");
					fsize++;
					System.out.println("저장되어 있는 전화번호 갯수: "+fsize);
					return;
				}
		}
		}
	public void show() {
		System.out.println("----------친구 전화번호부----------");
		for(int i=0;i<fsize;i++)
			System.out.println((i+1)+") "+fname[i]+"  "+fnum[i]);
	}//main에서 친구 번호 선택하라하고, 보여줄때는 친구 이름(fname)보여주기, 번호 입력받은걸로 calling 호출
	public void calling() {
		show();
		System.out.print("연락할 친구 이름을 입력하세요: ");
		String name=sc.next();
	for(int i=0;i<fsize;i++)
		if(name.equals(fname[i])) {
			System.out.println("Calling "+fname[i]+" "+fnum[i]);
			break;
		}
		else if(i==fsize-1)
			System.out.println("일치하는 이름이 없습니다.");
	}
	public void remove() {
		System.out.print("지울 친구의 이름을 입력해주세요: ");
		String name=sc.next();
		for(int i=0;i<fsize;i++)
			if(name.equals(fname[i])) {
					String[]tempname=new String[20];
					String[] tempnum=new String[20];
					for(int j=0;j<i;j++) {
						tempname[j]=fname[j];
						tempnum[j]=fnum[j];
					}
					for(int j=i+1;j<fsize-1;j++) {
						tempname[j]=fname[j];
						tempnum[j]=fnum[j];
					}
					fname=tempname;
					fnum=tempnum;
					fsize--;
				System.out.println(name+" 을 지웠습니다.");
				break;
			}
			else if(i==fsize-1)
				System.out.println("일치하는 이름이 없습니다.");
	}
}