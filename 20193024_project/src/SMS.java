import java.util.Scanner;
public class SMS{
	Scanner smssc=new Scanner(System.in);
	String[] SMSList=new String[10];
	String[] SMSTitle=new String[10];
	String context;
	String title;
	int size;
	public SMS() {
		for(int i=0;i<SMSList.length;i++) {
			SMSList[i]=" ";
			SMSTitle[i]=" ";
		}
	}
	public void showSMS() {
		System.out.println("-------최근 문자 10개의 제목-------");
		for(int i=0;i<size;i++)
			System.out.print(SMSTitle[i]+" ");
		System.out.println();
	}
	public void sendSMS() {
		System.out.print("받는 사람의 번호를 입력해주세요: ");
		String num=smssc.next();
		System.out.print("문자의 제목을 작성해주세요");
		title=smssc.next();
		smssc.nextLine();
		System.out.print("내용을 작성해주세요.  작성을 취소하려면 \"종료\"를 입력해주세요.");
		context=smssc.nextLine();
		if(context.contentEquals("종료"))
			return;
		System.out.print("전송하시겠습니까? y/n: ");
		String s=smssc.next();
		if(s.equals("y")) {
			size++;
			System.out.println(num+" 에 문자를 전송하였습니다.");
			for(int i=0;i<SMSList.length;i++) {
				if(SMSList[i].equals(" ")) {
					SMSList[i]=context;
					SMSTitle[i]=title;
					return;
				}else if(i==SMSList.length-1) {
					System.out.println("저장공간이 가득 찼습니다.가장 오래된 문자를 삭제하려면 1, 저장하지 않으려면 2를 눌러주세요.");
					int x=smssc.nextInt();
					if(x==1) {
						System.out.println("가장 오래된 문자인 "+title+" 을 삭제하였습니다.");
						String[] tempTitle=new String[10];
						String[] tempCon=new String[10];
						for(int j=1;j<10;j++) {
							tempTitle[i]=SMSTitle[i];
							tempCon[i]=SMSList[i];
						}
						SMSTitle=tempTitle;
						SMSList=tempCon;
						SMSTitle[9]=title;
						SMSList[9]=context;
						return;
					}
					else if(x==2) {
						System.out.println("현재 문자를 저장하지 않습니다.");
						return;
					}
					else {
						System.out.println("잘못된 번호를 입력하셨습니다.");
						return;
					}
			}
			}
		}	
		else
			System.out.println("취소하였습니다.");	
	}
	public void readSMS() {
		showSMS();
		if(SMSTitle[0].equals(" ")) {
			System.out.println("문자가 없습니다.");
			return;
		}
		System.out.print("읽어올 문자의 제목을 입력해주세요.");
		String Rtitle=smssc.next();		
		for(int i=0;i<size;i++)
			if(Rtitle.equals(SMSTitle[i])) {
				System.out.println(SMSList[i]);
				break;
			}
			else if(i==size-1) {
				System.out.println("일치하는 문자가 없습니다.");
				break;
			}
	}
	public void deleteSMS() {
		showSMS();
		System.out.print("삭제할 문자의 제목을 입력해주세요: ");
		String Dtitle=smssc.next();
		for(int i=0;i<size;i++)
			if(Dtitle.equals(SMSTitle[i])) {
				String[] tempT=new String[10];
				String[] tempC=new String[10];
				System.out.println(Dtitle+" 문자를 삭제합니다.");
				for(int j=0;j<i;j++) {
					tempT[j]=SMSTitle[j];
					tempC[j]=SMSList[j];
				}
				for(int j=i+1;j<size;j++) {
					tempT[j]=SMSTitle[j];
					tempC[j]=SMSList[j];
				}
				size--;
				SMSTitle=tempT;
				SMSList=tempC;
				return;
			}
			else if(i==size-1)
				System.out.println("일치하는 문자가 없습니다.");
	}
}