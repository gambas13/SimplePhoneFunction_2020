import  call.*;
import calculator.*;
import java.util.Scanner;
import java.util.Vector;
public class Main {
	static long beforetime=System.currentTimeMillis();
	static SMS text=new SMS();
	static Settings set=new Settings();
	static callFriend cf =new callFriend();
	static Call cp=new callParent();
	static Call ct=new callTeacher();
	static Vector<Dictionary> Dicv=new Vector<Dictionary>();
	static Scanner sc=new Scanner(System.in);
	public static int scanMain() {
		int m;
		System.out.print("실행할 어플 번호를 입력하세요 (종료: 0): ");
		m=sc.nextInt();//두번째 실행될 때 에러발생.
			return m;
	}
	public static void main(String[] args) {
		
		System.out.println("키즈폰 서비스입니다.");
		set.showApp();
		while(true) {
		int m=scanMain();
		if(m<0||m>10)
			continue;
		else if(m==0) {
			System.out.println("종료합니다.");
			break;
		}
		else
			startSystem(m);
		}
		sc.close();
	}
		static void startSystem(int menu) {
			if(menu==1) {
				System.out.println("전화 어플입니다.");
				int Cnum;
				while(true) {
				while(true) {
					System.out.print("메뉴를 선택하세요: 1)부모님께 전화  2)선생님께 전화 3)친구에게 전화 4)응급전화 5)종료: ");
					Cnum=sc.nextInt();
					if(Cnum<1||Cnum>5)
						System.out.println("없는 메뉴입니다.다시 입력해주세요.");
					else
						break;}//전화메뉴 while문
				if(Cnum==1) {
					cp.startCall();
				}
				else if(Cnum==2) {
					ct.startCall();
				}
				else if(Cnum==3) {
					cf.startCall();
				}//친구전화 끝
				else if(Cnum==4) {
					int n;
					while(true) {
					System.out.print("연락할 번호를 선택해주세요: 1) 119  2) 112  3)취소");
					n=sc.nextInt();
					if(n<1||n>3)
						System.out.println("잘못입력하셨습니다.");
					else
						break;
					}//응급메뉴 while
					Call ce=new callEmergency(n);
					ce.calling();
				}//응급전화 끝
				else if(Cnum==5) {
					System.out.println("어플을 종료합니다.");
					break;
				}
				}
			}//전화어플 종료
			else if(menu==2) {//menu2, 문자
				System.out.println("문자 어플입니다.");
				int n;
				while(true) {
				while(true) {
				System.out.print("메뉴를 선택해주세요: 1)문자 보내기  2)문자 읽어오기  3)문자 삭제  4)최근 문자 기록  5)종료");
				n=sc.nextInt();
				if(n<1||n>5)
					System.out.println("잘못입력하셨습니다.");
				else
					break;
				}//문자메뉴 while 끝
				if(n==1)
					text.sendSMS();
				else if(n==2)
					text.readSMS();
				else if(n==3)
					text.deleteSMS();
				else if(n==4)
					text.showSMS();
				else {
					System.out.println("문자 종료합니다.");
					break;
				}
				}
			}//menu2, 문자 끝
			else if(menu==3) {//menu3, 단어사전
				System.out.println("단어사전 입니다.");
				int n;
				while(true) {
				while(true) {
				System.out.print("옵션을 선택해주세요: 1)사전 만들기  2)기존에 있는 사전 선택 3)종료");
				n=sc.nextInt();
				if(n<1||n>3)
					System.out.println("잘못 입력하셨습니다.");
				else
					break;
				}//단어사전 menu while 끝
				if(n==1) {
					System.out.print("사전의 이름을 입력해주세요: ");
					String Dtitle;
					Dtitle=sc.next();
					Dictionary d=new Dictionary(Dtitle);
					d.makeDic();
					Dicv.add(d);
				}
				else if(n==2) {
					if(Dicv.isEmpty())
						System.out.println("사전이 없습니다.");
					else {
					System.out.println("사전 목록입니다.");
					int index = 0;	
					for(int i=0;i<Dicv.size();i++)
						System.out.print(Dicv.get(i).title+" ");
					System.out.println();
					while(true) {
					System.out.print("사전을 선택하세요: ");
					String select=sc.next();
					for(int i=0;i<Dicv.size();i++) {
						if(Dicv.get(i).title.equals(select)) {
							index=i;
							break;
						}
						
						else if(i==Dicv.size()-1) 
							index=-1;}
					if(index==-1) {
						System.out.println("일치하는 사전이 없습니다.");
						continue;
					}
					else
						break;
					}
					Dictionary d=Dicv.get(index);
					int x;
					while(true) {
					while(true) {
					System.out.print("어떤 일을 수행하실건가요? 1)단어 추가 2)뜻 변경  3)사전 지우기 4)단어찾기  5)단어지우기 6)제목바꾸기  7)단어보여주기 8)취소");
					x=sc.nextInt();
					if(x<1||x>8)
						System.out.println("잘못 입력하셨습니다.");
					else
						break;
					}//사전선택하고 뭐할건지 물어보는 while문
					
					if(x==1)
						d.addWord();
					else if(x==2)
						d.changeMean();
					else if(x==3) {
						int rd=d.removeDic();
						if(rd==1)
							Dicv.remove(d);
					}
					else if(x==4)
						d.findWord();
					else if(x==5)
						d.removeWord();
					else if(x==6)
						d.changeTitle();
					else if(x==7)
						d.showWord();
					else if(x==8) {
						System.out.println("취소되었습니다.");
						break;}
					}//사전 목록 선택했을 때 종료
				}
				}
				else if(n==3) { //첫 옵션에서 종료 선택했을 때
					System.out.println("종료합니다.");
					break;
				}
				}
			}//menu3, 단어사전 끝
			else if(menu==4) {
				System.out.println("계산기 어플입니다.");
				Calc calculator=new Calc();
				System.out.print("계산식을 입력해주세요.(모든 토큰은 공백으로 구분합니다.)");
				calculator.getCalc();
				calculator.makePostFix();
				System.out.println("계산 결과: "+calculator.evaluation());
			}//계산기 선택 끝
			else if(menu==5) {
				System.out.println("주사위 게임입니다.");
				Dicegame dice=new Dicegame();
				dice.startDice();
			}
			else if(menu==6) {
				System.out.println("룰렛돌리기 게임입니다.");
				System.out.print("룰렛 크기를 입력해주세요: ");
				int size;
				size=sc.nextInt();
				System.out.print("룰렛의 이름을 입력해주세요:" );
				String name;
				name=sc.next();
				Roullete r=new Roullete(size,name);
				int n;
				while(true) {
				while(true) {
				System.out.print("옵션을 선택해주세요: 1)내용삽입 2)내용보여주기 3)내용삭제 4)룰렛비우기 5)룰렛시작 6)종료: ");
				n=sc.nextInt();
				if(n<1||n>6)
					System.out.println("잘못 입력하셨습니다.");
				else
					break;
				}//룰렛옵션 while 끝
				if(n==1) 
					for(int j=0;j<size;j++) {
					System.out.print("내용을 입력해주세요: ");
					String s=sc.next();
					r.addItem(s);
					}
				else if(n==2)
					r.showItem();
				else if(n==3)
					r.removeItem();
				else if(n==4)
					r.clearRoullete();
				else if(n==5)
					r.start();
				else if(n==6) {
					System.out.println("종료합니다.");
					break;
				}
				}//roullete while
			}//룰렛돌리기 끝
			else if(menu==7) {
				System.out.println("가위바위보 게임입니다.");
				RSC rscgame=new RSC();
				rscgame.rsc();
			}
			else if(menu==8) {
				System.out.println("달력 어플입니다.");
				MonthSchedule June=new MonthSchedule(30);
				June.run();
			}
			else if(menu==9) {
				System.out.println("설정입니다.");
				int n;
				while(true) {
				while(true) {
				System.out.print("옵션을 선택해주세요: 1)사용자정보 2)디바이스정보 3)와이파이 4)설명서 5)종료");
				n=sc.nextInt();
				if(n<1||n>5)
					System.out.println("잘못 입력하셨습니다.");
				else
					break;}//설정 메뉴입력 while 종료
				if(n==1)
					set.UserInfo();
				else if(n==2)
					set.DeviceInfo();
				else if(n==3)
					set.Setwifi();
				else if(n==4)
					set.showInfo();
				else if(n==5) {
					System.out.println("종료합니다.");
					break;}
				}
				//setting while
			}//설정 전체 종료
			else if(menu==10) {
				System.out.println("시간 어플입니다.");
				Time time=new Time();
				int n;
				while(true) {
				while(true) {
				System.out.print("옵션을 선택해주세요: 1)오늘날짜 2)현재시각 3)실행시간 4)종료");
				n=sc.nextInt();
				if(n<1||n>4)
					System.out.println("잘못 입력하셨습니다.");
				else
					break;}
				if(n==1)
					time.getDate();
				else if(n==2)
					time.getTime();
				else if(n==3) {
					long aftertime=System.currentTimeMillis();
					time.timer(beforetime, aftertime);
				}
				else if(n==4) {
					System.out.println("종료합니다.");
					break;}
				//time while
				}
			}//시간종료
		}
	}



