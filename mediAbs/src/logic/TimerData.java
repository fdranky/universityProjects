package logic;
import org.simpleframework.xml.*;

@Root
public class TimerData {
	
	@Element
	Integer rotation;
	@Element
	String user;
	@Element
	Integer duration;
	@Element
	Integer ward;
	
	
	public TimerData(Integer rotation, String user, Integer duration,
			Integer ward) {
		super();
		this.rotation = rotation;
		this.user = user;
		this.duration = duration;
		this.ward = ward;
	}


	@Override
	public String toString() {
		return "TimerData [rotation=" + rotation + ", user=" + user
				+ ", duration=" + duration + ", ward=" + ward + "]";
	}
	

	public Integer getRotation() {
		return rotation;
	}


	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Integer getWard() {
		return ward;
	}


	public void setWard(Integer ward) {
		this.ward = ward;
	}

	

	

}
