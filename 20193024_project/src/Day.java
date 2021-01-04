import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Day {//하루 할 일 클래스
		   private String work; // 하루의 할 일을 나타내는 문자열
		   public void set(String work) { this.work = work; }
		   public String get() { return work; }
		   public void show() {
		      if(work == null) System.out.println("없습니다.");
		      else System.out.println(work + "입니다.");
		   }
		}
		class MonthSchedule {//월별 일정
		   Scanner sc=new Scanner(System.in);
		   private Day days[];
		  Date date=new Date();
		  private int Mday;
		  SimpleDateFormat today=new SimpleDateFormat("yyyy/MM/dd"); 
		   MonthSchedule(int day) {
			   this.Mday=day;
		      this.days = new Day[day];
		      for(int i=0; i<days.length; i++) {
		         days[i] = new Day();
		      }
		   }
		   private void input() {
		      System.out.print("날짜를 선택하세요: (1~"+Mday+")");
		      int day = sc.nextInt();
		      sc.nextLine();
		      System.out.print("할일을 입력하세요: ");
		      String work = sc.nextLine();
		      day--;
		      if(day < 0 || day > Mday) { 
		         System.out.println("날짜를 잘못 입력하였습니다. 다시 입력해주세요. ");
		         return;
		      }
		      days[day].set(work);
		   }
		   private void view() {
		      System.out.print("날짜를 선택하세요: (1~"+Mday+")");
		      int day = sc.nextInt();
		      day--;
		      if(day < 0 || day > Mday) { 
		         System.out.println("날짜를 잘못 입력하였습니다.다시 입력해주세요.");
		         return;
		      }
		      System.out.print((day+1)+"일의 할 일은 ");
		      days[day].show();
		   }
		   private void finish() {
		      System.out.println("프로그램을 종료합니다.");
		   }
		   public void run() {
		      System.out.println("이번달 일정 관리");
		      System.out.print("오늘 날짜: "+today.format(date));
		      while(true) {
		         System.out.println();
		         System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
		         int select = sc.nextInt();
		         switch(select) {
		         case 1: input(); break;
		         case 2: view(); break;
		         case 3: finish(); return;
		         }
		      }
		   }
}
