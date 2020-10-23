import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MazeFacade {
	
	
	//This method prints the maze as ASCII characters
	public void printMaze(int[][] maze) {
		
		TileFactory tileFactory;
		
		tileFactory = new TileFactory();
		
		for(int i = 0; i < maze.length; i++) {
			
			for(int j = 0; j < maze[i].length; j++) {
				
				MazeTile mazeTile = tileFactory.getTile(maze[i][j]);
				
				System.out.print(mazeTile.getASCII());
				
			}
			
			System.out.println();
			
		}
		
	}

	//This method prints the maze as an image in a JFrame
	public void displayMaze(int[][] maze) {
		
		int iconSize = 20;
		BufferedImage image;
		TileFactory tileFactory = new TileFactory();
		JFrame frame;
		JLabel label;
		
		image = new BufferedImage(iconSize * maze.length, iconSize * maze.length, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < maze.length; i++) {
			
			for(int j = 0; j < maze[i].length; j++) {
				
				BufferedImage icon = tileFactory.getTile(maze[i][j]).getIcon();
				
				for(int k = 0; k < iconSize; k++) {
					
					for(int l = 0; l < iconSize; l++) {
						
						image.setRGB(iconSize * i + k, iconSize * j + l, icon.getRGB(k, l));
						
					}
					
				}
				
			}
			
		}
		
		frame = new JFrame();
		label = new JLabel(new ImageIcon(image));
		label.setSize(iconSize * maze.length, iconSize * (maze.length + 2));
		frame.setTitle("Maze");
		frame.setSize(iconSize * maze.length, iconSize * (maze.length + 2));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Enables user to quit main method after closing JFrame
		frame.add(label);
		frame.setVisible(true);
		
	}
}