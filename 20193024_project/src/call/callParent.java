package call;
public class callParent extends Call{//main에서 check하고 calling 호출
	private String phonenum=" ";
	@Override
	public void Check() {
		if(this.phonenum.contentEquals(" ")) {
			System.out.println("저장된 번호가 없습니다.");
			this.phonenum=enter();
		}
	}
	@Override
	public void calling() {
		System.out.println("Calling parent, "+phonenum);
	}
}