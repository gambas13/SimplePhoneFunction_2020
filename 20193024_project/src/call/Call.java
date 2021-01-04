package call;
import java.util.Scanner;
interface Calling{
	void calling();
	String enter();
	void Check();
}
public class Call implements Calling{
	Scanner sc=new Scanner(System.in);
	static String phonenum;
	protected int num;
	int fsize;
	public void startCall() {
		Check();
		calling();
	}
	public Call() {
		phonenum=" ";
	}
	public void Check() {
		if(phonenum.equals(" ")){
			System.out.println("저장되어있는 번호가 없습니다.");
			phonenum=enter();
		}
	}
	public void calling() {
		System.out.print("Calling ");
	}
	
	public String enter() {
		System.out.print("번호를 입력하세요: ");
		String num=sc.next();
		return num;
	}

}


