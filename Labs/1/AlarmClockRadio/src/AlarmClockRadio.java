
public class AlarmClockRadio{
	private AlarmClock alarmClock;
	private Radio radio;
	
	public AlarmClockRadio(int time_h, int time_m, int time_s, String time_AMPM, int alarm_h, int alarm_m, String alarm_AMPM, String radioStation, int volume){
		this.alarmClock = new AlarmClock(time_h, time_m, time_s, time_AMPM, alarm_h, alarm_m, alarm_AMPM);
		this.radio = new Radio(radioStation, volume);
	}

	public void setVolume(int volume) {
		this.radio.setVolume(volume);
	}
	
	public void setStation(String station) {
		this.radio.setStation(station);
	}
	
	public int getVolume() {
		return this.radio.getVolume();
	}
	
	public String getStation() {
		return this.radio.getStation();
	}

	public Time getCurrentTime() {
		return this.alarmClock.getCurrentTime();
	}
	
	public void setCurrentTime(Time t) {
		this.alarmClock.setCurrentTime(t);
	}
	
	public String showTime() {
		return this.alarmClock.showTime();
	}
	
	public void tick() {
		this.alarmClock.tick();
		if(this.alarmClock.alarmRinging) {
			System.out.println("The Radio is playing " + this.radio.getStation());
		}
	}
	
	public void snooze() {
		this.alarmClock.snooze();
	}
	
	public void alarmOff() {
		this.alarmClock.alarmOff();
	}
	
	public void alarmOn() {
		this.alarmClock.alarmOn();
	}
	
	public boolean isAlarmOn() {
		return this.alarmClock.isAlarmOn();
	}
	
	public void radioOn() {
		this.radio.enable();
	}
	
	public void radioOff() {
		this.radioOff();
	}
	
}
