
public class Radio {
	private int volume;
	private String station;
	private boolean enabled;
	
	public Radio(String station, int volume) {
		this.setStation(station);
		this.setVolume(volume);
		this.enabled = false;
	}
	
	public void enable() {
		this.enabled = true;
		System.out.println("Radio began playing " + this.getStation());
	}
	
	public void disable() {
		this.enabled = false;
		System.out.println("Radio stopped playing");
	}
	
	public void setVolume(int volume) {
		this.volume = (volume<0) ? 0 : volume;
	}
	
	public void setStation(String station) {
		this.station = station;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public String getStation() {
		return this.station;
	}
}
