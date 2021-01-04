import java.util.Scanner;
interface Roulgame{
	void addItem(String s);
	int getSize();
	void showItem();
	void removeItem();
	void clearRoullete();	
	void start();
}
public class Roullete implements Roulgame{
	Scanner sc=new Scanner(System.in);
	private String[] list;
	private String name;
	private int size;
	public Roullete(int size,String name) {
		this.size=size;
		list=new String[size];
		for(int i=0;i<size;i++)
			list[i]=" ";
		this.name=name;
	}
	public int getSize() {
		return size;
	}
	public void addItem(String s) {//main에서 item 몇개 넣을건지 물어보고 
		for(int i=0;i<list.length;i++)
			if(list[i].equals(" ")) {
				list[i]=s;
				break;}
	}
	public void showItem() {
		System.out.println(name+" 룰렛의 크기: "+getSize());
		System.out.print(name+"에 저장된 내용: ");
		for(int i=0;i<size;i++)
			System.out.print(list[i]+" ");
		System.out.println();
	}
	public void removeItem() {
		showItem();
		System.out.print("지울 내용을 입력해주세요: ");
		String change=sc.next();
		for(int i=0;i<size;i++) {
			if(change.equals(list[i])) {
				String[]temp=new String[size-1];
				for(int j=0;j<i;j++)
					temp[j]=list[j];
				for(int j=i+1;j<size;j++)
					temp[j-1]=list[j];
				list=null;
				list=temp.clone();
				size--;
				break;
			}
			else if(i==size-1) {
				System.out.println("일치하는 단어가 없습니다.");
				return;
			}
		}
	}
	public void clearRoullete() {//main에서 벡터 지워주기
		System.out.println("정말 "+name+" 룰렛을 지우시겠습니까?");
		System.out.print("맞으면 1, 아니면 2를 눌러주세요: ");
		int x=sc.nextInt();
		if(x==1) {
			list=null;
			size=0;
			System.out.println("룰렛을 삭제하였습니다.");
		}
		else if(x==2) {
			System.out.println("취소되었습니다.");
		}
	}	
	public void start() {
		System.out.println("룰렛을 돌립니다!");
		int x=(int)(Math.random()*(size)+0);
		System.out.println(list[x]+" 가 선택되었습니다!");
	}
}
