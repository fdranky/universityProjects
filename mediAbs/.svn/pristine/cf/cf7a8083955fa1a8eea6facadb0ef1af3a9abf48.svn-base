package logic;
import java.util.Arrays;

import org.simpleframework.xml.*;

@Root
public class StatisticData {
	
	@Element
	Integer date;
	@Element
	String[] interventionTypes;
	@Element
	Integer rotation;
	@Element
	Integer ward;	
	@Element
	String user;
	
	public StatisticData(Integer date, String[] interventionTypes,
			Integer rotation, Integer ward, String user) {
		super();
		this.date = date;
		this.interventionTypes = interventionTypes;
		this.rotation = rotation;
		this.ward = ward;
		this.user = user;
	}

	@Override
	public String toString() {
		return "StatisticData [date=" + date + ", interventionTypes="
				+ Arrays.toString(interventionTypes) + ", rotation=" + rotation
				+ ", ward=" + ward + ", user=" + user + "]";
	}

	
	

	

}
