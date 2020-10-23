import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class SMSClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> populationCentres;
	private ArrayList<String> warningStations;
	private PopulationCentreFactory populationCentreFactory;
	private ArrayList<SeismographStream> seismographStreams;
	private MapDecorator mapVisualizer;
	private SeismometerListViewTarget populationListViewTarget;
	private SeismometerListViewTarget seismometerListViewTarget;
	private SeismometerListViewTarget stationListViewTarget;
	private AbstractAlertFactory alertFactory;
	
	int width = 1200;
	int height = 800;
	
	private SMSClient smsClient;
	
	private JLabel mapLabel;
	private JButton pairButton;
	private JButton warnerButton;
	private JPanel pairPanel;
	private JPanel warnerPanel;
	private JLabel inetTitle;
	private JLabel inetLabel;
	private JLabel portTitle;
	private JLabel portLabel;
	private JPanel inetPanel;
	private JRadioButton topographicButton;
	private JRadioButton politicalButton;
	private JPanel buttonPanel;
	private JRadioButton alertButton;
	private JRadioButton warnButton;
	private JPanel alertPanel;
	private JPanel listsPanel;
	private ButtonGroup mapGroup;
	private ButtonGroup warnGroup;
	private JList<String> listP;
	private JList<String> listS;
	private JList<String> listW;
	
	public SMSClient() throws IOException {
		
		BoxLayout layout;
		
		populationListViewTarget = new SeismometerListViewAdapter();
		seismometerListViewTarget = new SeismometerListViewAdapter();
		stationListViewTarget = new SeismometerListViewAdapter();
		
		alertFactory = new WarningFactory();
		
		populationCentreFactory = new PopulationCentreFactory();
		populationCentres = populationCentreFactory.getKeys();
		warningStations = new ArrayList<String>();
		
		smsClient = this;
		seismographStreams = new ArrayList<SeismographStream>();
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Seismic Monitoring Software 1.0");
		this.setResizable(true);
		
		layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		mapLabel = new JLabel();
		mapLabel.setPreferredSize(new Dimension(width, 3 * (int)((double) width / 1.78696566223) / 4));
		
		pairButton = new JButton("PAIR SEISMOMETER");
		pairButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				seismographStreams.add(new SeismographStream(smsClient));
				
			}
			
		});
		
		pairPanel = new JPanel(new GridLayout(1, 1));
		pairPanel.setPreferredSize(new Dimension(width, height / 30));
		pairPanel.add(pairButton);
		
		warnerButton = new JButton("PAIR WARNING STATION");
		warnerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new WarningSender();
				
			}
			
		});
		
		warnerPanel = new JPanel(new GridLayout(1, 1));
		warnerPanel.setPreferredSize(new Dimension(width, height / 30));
		warnerPanel.add(warnerButton);
		
		inetTitle = new JLabel("INET ADDRESS");
		
		inetLabel = new JLabel();
		
		inetPanel = new JPanel(new GridLayout(1, 4));
		inetPanel.setPreferredSize(new Dimension(width, height / 30));
		inetPanel.add(inetTitle);
		inetPanel.add(inetLabel);
		
		portTitle = new JLabel("INET PORT");
		
		portLabel = new JLabel();
		
		inetPanel.add(portTitle);
		inetPanel.add(portLabel);
		
		topographicButton = new JRadioButton("Topographic Map");
		topographicButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				updateMap(topographicButton);
				
			}
			
		});
		topographicButton.setSelected(true);
		
		politicalButton = new JRadioButton("Political Map");
		politicalButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				updateMap(politicalButton);
				
			}
			
		});
		politicalButton.setSelected(false);
	
		mapGroup = new ButtonGroup();
		
		mapGroup.add(topographicButton);
		mapGroup.add(politicalButton);
		
		buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.setPreferredSize(new Dimension(width, height / 30));
		buttonPanel.add(topographicButton);
		buttonPanel.add(politicalButton);
		
		warnButton = new JRadioButton("Warning Mode");
		warnButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				alertFactory = new WarningFactory();
				
			}
			
		});
		warnButton.setSelected(true);
		
		alertButton = new JRadioButton("Alert Mode");
		alertButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				alertFactory = new AlertFactory();
				
			}
			
		});
		alertButton.setSelected(false);
	
		warnGroup = new ButtonGroup();
		
		warnGroup.add(warnButton);
		warnGroup.add(alertButton);
		
		alertPanel = new JPanel(new GridLayout(1, 2));
		alertPanel.setPreferredSize(new Dimension(width, height / 30));
		alertPanel.add(warnButton);
		alertPanel.add(alertButton);
		
		updateMap(topographicButton);
		
		populationListViewTarget.setItems(populationCentres);
		
		listsPanel = new JPanel(new GridLayout(1, 3));
		listsPanel.setPreferredSize(new Dimension(width, height / 2));
		
		listP = populationListViewTarget.getListView();
		listP.setFixedCellWidth(width);
		listP.setVisible(true);
		
		listS = seismometerListViewTarget.getListView();
		listS.setFixedCellWidth(width);
		listS.setVisible(true);
		
		listW = stationListViewTarget.getListView();
		listW.setFixedCellWidth(width);
		listW.setVisible(true);
		
		listsPanel.add(new JScrollPane(listP));
		listsPanel.add(new JScrollPane(listS));
		listsPanel.add(new JScrollPane(listW));
		
		this.add(mapLabel);
		this.add(buttonPanel);
		this.add(alertPanel);
		this.add(pairPanel);
		this.add(warnerPanel);
		this.add(inetPanel);
		this.add(listsPanel);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		new SMSClient();
		
	}
	
	public void displaySocketInfo(String inet, String port) {
		
		inetLabel.setText(inet);
		portLabel.setText(port);
		
	}
	
	public void displaySeismographStreams() {
		
		ArrayList<String> items = new ArrayList<String>();
		
		for(SeismographStream stream : seismographStreams) {
			
			items.add(stream.getName() + ": " + stream.getFirstState().getCoordinates().toString());
			
		}
		
		seismometerListViewTarget.setItems(items);
		
	}

	public void displayWarningStations() {
		
		stationListViewTarget.setItems(warningStations);
		
	}
	
	public void updateMap(JRadioButton button) {
		
		if(button == politicalButton) {
			
			mapVisualizer = new PoliticalMap();
			
		} else {
			
			mapVisualizer = new TopographicMap();
			
		}
		
		for(String key : populationCentres) {
			
			mapVisualizer.addChild(new PopulationCentreComponent(populationCentreFactory, key));
			
		}
		
		mapVisualizer.display();
		
		mapLabel.setIcon(new ImageIcon(mapVisualizer.getImage().getScaledInstance(mapLabel.getPreferredSize().width, mapLabel.getPreferredSize().height, Image.SCALE_DEFAULT)));
		mapLabel.setHorizontalAlignment(JLabel.CENTER);
		mapLabel.setVerticalAlignment(JLabel.CENTER);
		mapLabel.setBorder(new LineBorder(Color.RED, 4));
		
	}
	
	class WarningSender implements Runnable {
		
		Thread t;
		PopulationCentre populationCentre;
		BufferedReader input;
		DataOutputStream output;
		
		public WarningSender() {
			
			start();
			
		}

		public void run() {
			
			AbstractSocketBuilder socketBuilder = SocketBuilder.getSocketBuilder();
			socketBuilder.buildSocket();
			SocketWrapper socketWrapper = ((SocketBuilder)socketBuilder).getSocket();
			Socket socket;
			
			displaySocketInfo(socketWrapper.getSocket().getInetAddress().toString(), Integer.toString(socketWrapper.getSocket().getLocalPort()));
			
			try {
				
				socket = socketWrapper.getSocket().accept();
				displaySocketInfo("","");
				
				output = new DataOutputStream(socket.getOutputStream());
				
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				populationCentre = populationCentreFactory.getPopulationCentre(input.readLine());
				
				warningStations.add(populationCentre.getKey());
				displayWarningStations();
				
				while(true) {
					
					t.sleep(10000);
					
					for(SeismographStream s : seismographStreams) {
						
						AbstractSeismographState state = s.getFinalState();
						
						if(state != null) {
							
							Double reading = state.getReading();
							Double distance = Coordinates.centre(populationCentre).distance(state.getCoordinates());
							
							if(true) {
								
								if(reading > 7) {
									
									if(distance > 80.0) {
										
										AbstractTsunamiAlert alert = alertFactory.createTsunamiAlert();
										alert.setSeverity(reading);
										output.writeBytes(alert.encode()+"\n");
										
									} else {
										
										AbstractEarthquakeAlert alert = alertFactory.createEarthquakeAlert();
										alert.setSeverity(reading);
										output.writeBytes(alert.encode()+"\n");
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		public void start() {
			
			Random rn = new Random();
			
			if(t == null) {
				
				t = new Thread(this, "Thread#" + rn.nextLong());
				t.start();
				
			}
			
		}
		
	}
	
}