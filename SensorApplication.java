package sensor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	/************************************************************************************
	 * @author Joshua Standerfer														*
	 * Date:5/24/19																		*
	 * Desc: This class acts as an interface between a client, and the Sensor Adapters.	*
	 * Upon creation, it will get a value from the sensors for display.					*
	 ************************************************************************************/
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
	
		JPanel pGauge = new JPanel();
		JPanel  pressurePnl = new JPanel(new GridLayout(1,2));
		SensorAdapter pAdap = new PressAdapter();
		JLabel pLbl = new JLabel(Double.toString(pAdap.getReading()) + " ----> " + pAdap.getStatus());
		pressurePnl.setBorder(new TitledBorder(pAdap.getType()));
		//pGauge.setOpaque(true);
		//pGauge.setBounds(new Rectangle(0,0,(int)pAdap.gauge(),1000));
				
		pGauge.setBackground(pAdap.getThreatLevel());
		pressurePnl.add(pGauge);
		pressurePnl.add(pLbl);
		add(pressurePnl);
		
		JPanel rGauge = new JPanel();
		JPanel  radiationPnl = new JPanel(new GridLayout(1,2));
		SensorAdapter rAdap = new RadAdapter();
		JLabel rLbl = new JLabel(Double.toString(rAdap.getReading()) + " ----> " + rAdap.getStatus());
		radiationPnl.setBorder(new TitledBorder(rAdap.getType()));
		//rGauge.setBounds();
		//rGauge.setOpaque(true);
		
		rGauge.setBackground(rAdap.getThreatLevel());
		radiationPnl.add(rGauge);
		radiationPnl.add(rLbl);
		add(radiationPnl);
		
		JPanel tGauge = new JPanel();
		JPanel  temperaturePnl = new JPanel(new GridLayout(1,2));
		SensorAdapter tAdap = new TempAdapter();
		JLabel tLbl = new JLabel(Double.toString(tAdap.getReading()) + " ----> " + tAdap.getStatus());
		temperaturePnl.setBorder(new TitledBorder(tAdap.getType()));
		//tGauge.setBounds(new Rectangle(0,0,(int)tAdap.gauge(),1000));
		//tGauge.setOpaque(true);
		
		tGauge.setBackground(tAdap.getThreatLevel());
		temperaturePnl.add(tGauge);
		temperaturePnl.add(tLbl);
		add(temperaturePnl);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	/********************************************************
	 * @author Joshua Standerfer							*
	 * Desc: For now this acts as the client.				*
	 *******************************************************/
	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
		
	}

}
