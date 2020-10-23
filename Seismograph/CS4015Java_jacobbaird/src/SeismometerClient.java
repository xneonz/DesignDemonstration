import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SeismometerClient extends JFrame {
	
	private static final long serialVersionUID = 1949146277096231199L;
	
	private HashMap<String, Seismograph> seismographs;
	
	private JList<String> seismometerList;
	private JButton addButton;
	private JPanel addPanel;
	private JTextField inetField;
	private JLabel inetLabel;
	private JPanel inetPanel;
	private JTextField portField;
	private JLabel portLabel;
	private JPanel portPanel;
	private JTextField latitudeField;
	private JLabel latitudeLabel;
	private JPanel latitudePanel;
	private JTextField longitudeField;
	private JLabel longitudeLabel;
	private JPanel longitudePanel;
	private JTextField nameField;
	private JLabel nameLabel;
	private JPanel namePanel;
	private JLabel statusLabel;
	private JPanel statusPanel;
	
	private final int width = 400;
	private final int height = 800;
	
	public SeismometerClient() {
		
		BoxLayout layout;
		
		seismographs = new HashMap<String, Seismograph>();
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Seismometer");
		this.setResizable(false);
		
		layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		seismometerList = new JList<String>();
		seismometerList.setListData(new String[] {"No seismometers detected!"});
		seismometerList.setPreferredSize(new Dimension(width, 13 * height / 20));
		seismometerList.setFixedCellWidth(width);
		seismometerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					displaySeismometer();
				} catch (NullPointerException ex) {
				}
			}
		});
		seismometerList.setVisible(true);
		
		inetField = new JTextField();
		inetField.setVisible(true);
		
		inetLabel = new JLabel("INET ADDRESS");
		
		inetPanel = new JPanel(new GridLayout(1, 2));
		inetPanel.add(inetLabel);
		inetPanel.add(inetField);
		inetPanel.setPreferredSize(new Dimension(width, height / 20));
		
		portField = new JTextField();
		portField.setVisible(true);
		
		portLabel = new JLabel("INET PORT");
		
		portPanel = new JPanel(new GridLayout(1, 2));
		portPanel.add(portLabel);
		portPanel.add(portField);
		portPanel.setPreferredSize(new Dimension(width, height / 20));
		
		latitudeField = new JTextField();
		latitudeField.setVisible(true);
		
		latitudeLabel = new JLabel("LATITUDE");
		
		latitudePanel = new JPanel(new GridLayout(1, 2));
		latitudePanel.add(latitudeLabel);
		latitudePanel.add(latitudeField);
		latitudePanel.setPreferredSize(new Dimension(width, height / 20));
		
		longitudeField = new JTextField();
		longitudeField.setVisible(true);
		
		longitudeLabel = new JLabel("LONGITUDE");
		
		longitudePanel = new JPanel(new GridLayout(1, 2));
		longitudePanel.add(longitudeLabel);
		longitudePanel.add(longitudeField);
		longitudePanel.setPreferredSize(new Dimension(width, height / 20));
		
		nameField = new JTextField();
		nameField.setVisible(true);
		
		nameLabel = new JLabel("NAME");
		
		namePanel = new JPanel(new GridLayout(1, 2));
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.setPreferredSize(new Dimension(width, height / 20));

		addButton = new JButton("Add Seismometer");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSeismometer();
			}
		});
		addButton.setVisible(true);
		
		addPanel = new JPanel(new GridLayout(1, 1));
		addPanel.add(addButton);
		addPanel.setPreferredSize(new Dimension(width, height / 20));
		
		statusLabel = new JLabel();
		
		statusPanel = new JPanel(new GridLayout(1, 1));
		statusPanel.add(statusLabel);
		statusPanel.setPreferredSize(new Dimension(width, height / 20));
		
		
		this.add(seismometerList);
		this.add(inetPanel);
		this.add(portPanel);
		this.add(latitudePanel);
		this.add(longitudePanel);
		this.add(namePanel);
		this.add(addPanel);
		this.add(statusPanel);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new SeismometerClient();
		
	}
	
	public void displaySeismometer() {
		
		String name;
		
		try {
			
			name = seismometerList.getSelectedValue();
			statusLabel.setText(seismographs.get(name).toString());
			
		} catch (NullPointerException ex) {
		}
		
	}
	
	private void updateList() {
		
		int i = 0;
		
		Set<String> keySet = seismographs.keySet();
		String[] names = new String[keySet.size()];
		
		for(String name : keySet) {
			
			names[i] = name;
			i++;
			
		}
		
		seismometerList.setListData(names);
		
	}
	
	private void addSeismometer() {
		
		String inetAddress;
		int port;
		double longitude;
		double latitude;
		String name;
		Seismograph seismograph;
		
		inetAddress = inetField.getText();
		name = nameField.getText();
		
		if(name.length() == 0 || seismographs.containsKey(name)) {
			
			nameError();
			return;
			
		}
		
		try {
			
			port = Integer.parseInt(portField.getText());
			longitude = Double.parseDouble(longitudeField.getText());
			latitude = Double.parseDouble(latitudeField.getText());
			
		} catch (NumberFormatException e) {
			
			numberFormatError();
			return;
			
		}
		
		if(longitude > 180 || longitude < -180 || latitude > 90 || latitude < -90) {
			
			rangeError();
			return;
			
		}
		
		try {
		
			seismograph = new Seismograph(name, longitude, latitude, this, inetAddress, port);
			
		} catch (IOException e) {
			
			serverError();
			return;
			
		}
		
		seismographs.put(name, seismograph);
		
		seismograph.start();
		
		updateList();
		
		createSuccess();
		
	}
	
	private void numberFormatError() {
		
		statusLabel.setText("ERROR: UNRECOGNIZED NUMBER FORMAT");
		
	}
	
	private void rangeError() {
		
		statusLabel.setText("ERROR: INVALID LATITUDE/LONGITUDE");
		
	}
	
	private void nameError() {
		
		statusLabel.setText("ERROR: ENTER NEW NAME");
		
	}
	
	private void serverError() {
		
		statusLabel.setText("ERROR: SERVER UNAVAILABLE");
		
	}
	
	private void createSuccess() {
		
		statusLabel.setText("SEISMOMETER CREATED SUCCESSFULLY");
		
		latitudeField.setText("");
		longitudeField.setText("");
		inetField.setText("");
		portField.setText("");
		nameField.setText("");
		
	}
}