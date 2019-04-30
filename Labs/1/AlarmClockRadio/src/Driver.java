
public class Driver {
	public static void main(String[]args){
		int i;
		int seconds;
		AlarmClockRadio myClock = new AlarmClockRadio(8,0,0,"AM",8,5,"AM", "1080AM", 10);
		
		for(i=0;i<5;i++){
			System.out.println("Time:"+myClock.showTime());
			for(seconds=0;seconds<60;seconds++){
				myClock.tick();
			}
		}
		myClock.snooze();
		for(i=0;i<9;i++){
			System.out.println("Time:"+myClock.showTime());
			for(seconds = 0;seconds<60;seconds++){
				myClock.tick();
			}
		}
		myClock.alarmOff();
	}
}
	
