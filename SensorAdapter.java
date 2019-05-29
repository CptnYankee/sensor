package sensor;

import java.awt.Color;

public interface SensorAdapter {
	
	public String getType();
	
	public String getStatus();
	
	public double getReading();
	
	public double gauge();
	
	public Color getThreatLevel();
}
