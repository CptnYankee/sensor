package sensor;

import java.awt.Color;

public class TempAdapter implements SensorAdapter{
	
	private static final double OK_THRESH = 234.9;
	private static final double DANGER_THRESH = 300.0;

	private double reading;
	private TemperatureSensor tSense;
	
	public TempAdapter() {
		tSense = new TemperatureSensor();
	}
	
	public String getType() {
		return tSense.getSensorType();
	}
	
	public String getStatus() {
		String testString =  tSense.getTempReport();
		return testString;
	}
	
	public double getReading() {
		reading = tSense.senseTemperature();
		return reading;
	}
	
	public double gauge() {
		return 500 * reading/DANGER_THRESH;
	}

	public Color getThreatLevel() {
		
		if(getStatus().equals("OK"))
			return Color.GREEN;
		
		if(getStatus().equals("CRITICAL"))
			return Color.YELLOW;
		
		if(getStatus().equals("DANGER"))
			return Color.RED;
		else
			return Color.WHITE;
	}
}
