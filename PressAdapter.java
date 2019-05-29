package sensor;

import java.awt.Color;

public class PressAdapter implements SensorAdapter{
	
	private static final double OK_THRESH = 4.99;
	private static final double DANGER_THRESH = 6.58;
	
	private double reading;
	private PressureSensor pSense;
	
	public PressAdapter() {
		pSense = new PressureSensor();
	}
	
	public String getType() {
		return pSense.getSensorName();
	}
	
	public String getStatus() {
		return pSense.getReport();
	}
	
	public double getReading() {
		reading = pSense.readValue();
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
			return Color.DARK_GRAY;
	}
}

