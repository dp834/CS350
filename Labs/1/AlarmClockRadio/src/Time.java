public class Time {
	private int hour;
	private int minute;
	private int second;
	private boolean isAM;
	
	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
		this.isAM = true;
	}
	
	public Time(int hour, int minute, int second, boolean isAM) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.isAM = isAM;
		this.correctTime();
	}
	
	private void correctTime() {
		while(this.second > 59) {
			this.minute++;
			this.second -= 60;
		}
		while(this.minute > 59) {
			this.hour++;
			this.minute -= 60;
		}
		
		while(this.hour > 12) {
			this.isAM = !this.isAM;
			this.hour -= 12;
		}		
	}
	
	public void tick() {
		this.second++;
		this.correctTime();
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d%s", this.hour, this.minute, this.second, this.getAMPMString());
	}
	
	private String getAMPMString() {
		return (this.isAM)? "AM": "PM";
	}
	
	/**
	 * 
	 * @param t
	 * @return true if times are the same
	 */
	public boolean equals(Time t) {
		return this.toString().compareTo(t.toString()) == 0;
		
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	public int getSecond() {
		return this.second;
	}

	public boolean getIsAM() {
		return this.isAM;
	}
}
