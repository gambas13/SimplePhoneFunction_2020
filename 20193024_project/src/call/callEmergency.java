package call;
public class callEmergency extends Call{
	//main에서 번호 선택하라하고, scanner로 입력받고, 그거를 생성자의 인자로전달.
	public callEmergency(int x){
		super.num=x;
	}
	@Override
	public void calling() {//이후 calling 호출
		if(num==1)
			System.out.println("calling 119");
		else if(num==2)
			System.out.println("calling 112");
		else if(num==3)
			System.out.println("응급 호출 종료합니다.");
	}
}