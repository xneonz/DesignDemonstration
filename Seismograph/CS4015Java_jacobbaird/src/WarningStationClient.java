import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WarningStationClient extends JFrame {
	
	private static final long serialVersionUID = -8424002048416925138L;
	private ArrayList<WarningStation> warningStations;
	private ArrayList<String> populationCentres;
	private PopulationCentreFactory populationCentreFactory;
	private int width = 400;
	private int height = 800;
	private WarningStationClient client;
	
	private JList<String> stationList;
	private JList<String> centreList;
	private JPanel listPanel;
	private JLabel inetLabel;
	private JTextField inetField;
	private JPanel inetPanel;
	private JLabel portLabel;
	private JTextField portField;
	private JPanel portPanel;
	private JButton pairButton;
	
	public WarningStationClient() throws IOException {
		
		warningStations = new ArrayList<WarningStation>();
		populationCentreFactory = new PopulationCentreFactory();
		client = this;
		
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Warning Station");
		this.setVisible(true);
		
		stationList = new JList<String>();
		stationList.setFixedCellWidth(width);
		
		centreList = new JList<String>();
		centreList.setFixedCellWidth(width);
		
		listPanel = new JPanel(new GridLayout(2, 1));
		listPanel.setPreferredSize(new Dimension(width, 7 * height / 8));
		listPanel.add(stationList);
		listPanel.add(centreList);
		
		populationCentreFactory = new PopulationCentreFactory();
		populationCentres = populationCentreFactory.getKeys();
		
		inetLabel = new JLabel("INET ADDRESS");
		inetField = new JTextField();
		inetPanel = new JPanel(new GridLayout(1, 2));
		inetPanel.setPreferredSize(new Dimension(width, height / 16));
		inetPanel.add(inetLabel);
		inetPanel.add(inetField);
		
		portLabel = new JLabel("INET PORT");
		portField = new JTextField();
		portPanel = new JPanel(new GridLayout(1, 2));
		portPanel.setPreferredSize(new Dimension(width, height / 16));
		portPanel.add(portLabel);
		portPanel.add(portField);
		
		pairButton = new JButton("PAIR WARNING STATION");
		pairButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				warningStations.add(new WarningStation(client));
				
			}
			
		});
		pairButton.setPreferredSize(new Dimension(width, height / 16));
		
		this.add(listPanel);
		this.add(inetPanel);
		this.add(portPanel);
		this.add(pairButton);
		
		updateList();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		new WarningStationClient();
		
	}
	
	public void updateList() {
		
		String[] array = new String[warningStations.size()];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = warningStations.get(i).toString();
			
		}
		
		stationList.setListData(array);
		
		array = new String[populationCentres.size()];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = populationCentres.get(i);
			
		}
		
		centreList.setListData(array);
		centreList.setSelectedIndex(0);
		
	}
	
	public String getSelectedCentre() {
		
		return centreList.getSelectedValue();
		
	}
	
	public int getInetPort() {
		
		return Integer.parseInt(portField.getText());
		
	}
	
	public String getInetAddress() {
		
		return inetField.getText();
		
	}
	
	public void displayAlert(String alert) {
		
		stationList.setListData(new String[] {alert});
		
	}
	
}