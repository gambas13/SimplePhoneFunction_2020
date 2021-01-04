import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
class Settings {
	InputStreamReader in;
	FileInputStream fin;
	Scanner sc=new Scanner(System.in);
	String UserName;
	int UserAge;
	String deviceName;
	String deviceNum;
	boolean wifi;
	String dn;
	public Settings() {
		dn=Double.toString((Math.random()*99999)+10000);
		UserName=null;
		UserAge=0;
		deviceName="kiz"+dn;
		deviceNum=dn;
		wifi=false;
		fin=null;
		in=null;
	}
	public void UserInfo() {
		if(UserName==null) {
			System.out.println("사용자 이름이 저장되어있지 않습니다..");
			System.out.print("이름을 입력해주세요:  ");
			UserName=sc.next();
			System.out.println("저장되었습니다.");
		}
		if(UserAge==0) {
			System.out.println("사용자 나이가 저장되어 있지 않습니다.");
			System.out.print("나이를 입력해주세요:  ");
			UserAge=sc.nextInt();
			System.out.println("저장되었습니다. ");
		}
		System.out.println("사용자 이름: "+UserName+", 나이:  "+UserAge);
	}
	public void DeviceInfo() {
		System.out.println("디바이스 이름: "+deviceName);
		System.out.println("디바이스 넘버: "+deviceNum);
	}
	public void Setwifi() {
		System.out.print("와이파이를 설정하시겠습니까? y/n: ");
		String s=sc.next();
		if("y".equals(s))
			wifi=true;
		else
			wifi=false;
		System.out.println("Wifi connected: "+wifi);
	}
	public void showInfo() {
		try {fin=new FileInputStream("C:\\Users\\user\\ForUser.txt");
		in=new InputStreamReader(fin);
		int c;
		while((c=fin.read())!=-1)
			System.out.print((char)c);
		System.out.println();
		in.close();
		fin.close();
		}catch(IOException e){
			System.out.println("입출력 오류");
		}
	}
		public void showApp() {
			try {fin=new FileInputStream("C:\\Users\\user\\App.txt");
			in=new InputStreamReader(fin);
			int c;
			while((c=fin.read())!=-1)
				System.out.print((char)c);
			System.out.println();
			in.close();
			fin.close();
			}catch(IOException e){
				System.out.println("입출력 오류");
			}
		}
}

