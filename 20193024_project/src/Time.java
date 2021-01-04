import java.util.Date;
import java.text.SimpleDateFormat;
class Time {
	private SimpleDateFormat date;
	private SimpleDateFormat time;
	private Date today;
	public Time() {
		today=new Date();
		date=new SimpleDateFormat("yyyy/MM/dd");
		time=new SimpleDateFormat("hh:mm:ss a");
	}
	public void getDate() {
		System.out.println("오늘 날짜: "+date.format(today));
	}
	public void getTime() {
		System.out.println("현재 시간: "+time.format(today));
	}
	public void timer(long before, long after) {//main에서 타이머 쓸거면 시작할 때 밀리스로 시간, 종료할 때 밀리스로 시간.
		String startTime=time.format(before);
		String endTime=time.format(after);
		long diff=(after-before)/1000;
		System.out.println("시작 시간: "+startTime);
		System.out.println("종료 시간: "+endTime);
		System.out.println("경과시간: "+diff+ "초");
	}
}
