
public class AlarmClock {

	protected Time currentTime;
	protected Time alarmTime;
	protected Time snoozeTime;
	protected boolean alarmEnabled;
	protected boolean alarmRinging;
	
	
	public AlarmClock(int time_h, int time_m, int time_s, String time_AMPM, int alarm_h, int alarm_m, String alarm_AMPM) {
		this.currentTime = new Time(time_h, time_m, time_s, (time_AMPM.compareToIgnoreCase("AM")==0));
		this.setAlarm(alarm_h, alarm_m, 0,alarm_AMPM);
		this.alarmOn();
		this.alarmRinging = false;
		
	}

	private void checkAlarm() {
		if(alarmEnabled && this.currentTime.equals(this.alarmTime) || snoozeTime != null && currentTime.equals(this.snoozeTime)) {
			System.out.println("Buzz Buzz Buzz");
			this.alarmRinging = true;
		}
		
	}

	public void setCurrentTime(Time t) {
		this.currentTime = t;
	}
	
	public Time getCurrentTime() {
		return this.currentTime;
	}
	
	public String showTime() {
		return this.currentTime.toString();
	}

	public void snooze() {
		this.snoozeTime = new Time(this.currentTime.getHour(), this.currentTime.getMinute() + 9, this.currentTime.getSecond(), this.currentTime.getIsAM());		
		this.alarmRinging = false;
	}

	public void tick() {
		this.currentTime.tick();
		this.checkAlarm();
	}

	public void alarmOff() {
		this.alarmEnabled = false;
		this.alarmRinging = false;
		this.snoozeTime = null;
	}
	
	public void setAlarm(int alarm_h, int alarm_m, int alarm_s, String alarm_AMPM) {
		this.alarmTime = new Time(alarm_h, alarm_m, 0, (alarm_AMPM.compareToIgnoreCase("AM")==0));
	}
	
	public Time getAlarm() {
		return this.alarmTime;
	}
	
	public void alarmOn() {
		this.alarmEnabled = true;
	}
	
	public boolean isAlarmOn() {
		return this.alarmEnabled;
	}


}

