package logic;
import org.simpleframework.xml.*;

@Root
public class InfectionDiagnosis {
	
	@Element
	String title;

	public InfectionDiagnosis(String title) {
		super();
		this.title = title;
	}

	@Override
	public String toString() {
		return "InfectionDiagnosis [title=" + title + "]";
	}
	
	
	
	

}
