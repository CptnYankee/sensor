package sensor;

import java.awt.Color;

public class RadAdapter implements SensorAdapter{
	
	private static final double OK_THRESH = 2.9;
	private static final double DANGER_THRESH = 4.0;
	
	private double reading;
	private RadiationSensor rSense;
	
	public RadAdapter() {
		rSense = new RadiationSensor();
	}
	
	public String getType() {
		return rSense.getName();
	}
	
	public String getStatus() {
		return rSense.getStatusInfo();
	}
	
	public double getReading() {
		reading = rSense.getRadiationValue();
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

