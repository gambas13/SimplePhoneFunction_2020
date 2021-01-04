import java.util.ArrayList;
import java.util.Scanner;
interface DicFunction{
	void makeDic();
	void addWord();
	void changeMean();
	int removeDic();
	void findWord();
	void removeWord();
	void changeTitle();
	void showWord();
}
public class Dictionary implements DicFunction{//main에서 사전 종류 선택하기,vector로 dic만들어서 단어 모두 보여주기, 사전 보여주기 하기
	Scanner sc=new Scanner(System.in);
	public ArrayList<String> word;
	public ArrayList<String> meaning;
	String title;
	public Dictionary(String title){
		word=new ArrayList<>();
		meaning=new ArrayList<>();
		this.title=title;
	}
	@Override
	public void makeDic() {
		System.out.println("새로운 사전을 만듭니다.");
		System.out.println(this.title+" 사전을 만들었습니다.");
	}
	@Override
	public void addWord() {
		String eword,kword;
		System.out.println("사전에 단어를 추가합니다.");
		System.out.print("새로 추가할 영어단어를 입력해주세요:");
		eword=sc.next();
		System.out.print("새로 추가할 한글단어를 입력해주세요: ");
		kword=sc.next();
		word.add(eword);
		meaning.add(kword);
		System.out.println(this.title+" 에 새로운 단어가 추가되었습니다.");
	}
	@Override
	public void changeMean() {
		int idx = 0;
		String eword,cword;
		showWord();
		System.out.print("뜻을 바꿀 영어단어를 입력해주세요:");
		eword=sc.next();
		for(int i=0;i<word.size();i++)
			if(word.get(i).equals(eword)) {
				idx=i;
				meaning.remove(i);
				break;
			}
			else if(i==word.size()-1) {
				System.out.println("일치하는 영어단어가 없습니다.");
				System.out.println("다시 시도해주세요.");
				return;
			}
		System.out.print("바꿀 뜻을 입력해주세요:");
		cword=sc.next();
		meaning.add(idx, cword);
		System.out.println("변경사항이 저장되었습니다.");
		}
	@Override
	public int removeDic() {
		System.out.println(this.title+" 사전을 지우겠습니까? 사전에 저장되어있는 모든 기록들이 제거됩니다.");
		System.out.print("맞으면 1, 틀리면 2를 눌려주세요.");
		int s=sc.nextInt();
		if(s==1) {
			word.clear();
			meaning.clear();
			System.out.println("삭제되었습니다.");
		}
		else if(s==2) {
			System.out.println("취소되었습니다.");
		}
		return s;
	}
	@Override
	public void removeWord() {//main에서 사전 선택하기
		String eword;
		int idx=0;
		System.out.println("단어를 삭제합니다.");
		System.out.print("지울 단어를 입력해주세요:");
		eword=sc.next();
		for(int i=0;i<word.size();i++)
			if(eword.equals(word.get(i))) {
				idx=i;
					break;
			}
			else if(i==word.size()-1) {
				System.out.println("일치하는 단어가 없습니다.");
				return;
			}
		word.remove(idx);
		meaning.remove(idx);
		System.out.println("단어를 삭제하였습니다.");
	}
	@Override
	public void findWord() {
		System.out.print("찾을 단어를 입력해주세요: ");
		String eword=sc.next();
		int idx=0;
		for(int i=0;i<word.size();i++) {
			if(eword.equals(word.get(i))) {
				idx=i;
				break;
			}
			else if(i==word.size()-1) {
				System.out.println("일치하는 단어가 없습니다.");
				return;
			}
		}
		String mean=meaning.get(idx);
		System.out.println(eword+" 의 의미는 "+mean+" 입니다.");
	}
	@Override
	public void changeTitle() {
		System.out.println(this.title+" 의 이름을 변경하시겠습니까?");
		System.out.print("맞으면 1, 틀리면 2를 눌러주세요.");
		int x=sc.nextInt();
		if(x==1) {
			System.out.print("변경할 이름을 입력해주세요:");
			this.title=sc.next();
			System.out.println(this.title+" 로 변경되었습니다.");
			return;
		}
		else {
			System.out.println("취소되었습니다.");
			return;
		}
	}
	@Override
	public void showWord() {
		System.out.println();
		for(int i=0;i<word.size();i++) {
			System.out.print(word.get(i)+" ");
			System.out.println(meaning.get(i));
		}
	}
}
