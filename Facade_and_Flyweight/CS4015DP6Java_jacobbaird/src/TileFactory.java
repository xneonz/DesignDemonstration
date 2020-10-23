public class TileFactory {

	private MazeTile[] tiles;

	public TileFactory() {
		
		tiles = new MazeTile[3];
		
		tiles[0] = new MazeSpace();
		tiles[1] = new MazeWall();
		tiles[2] = new MazeDoor();
		
	}
	
	public MazeTile getTile(int key) {
		
		for(int i = 0; i < tiles.length; i++) {
		
			if(tiles[i].getKey() == key) {
				
				return tiles[i];
				
			}
			
		}
		
		return null;
		
	}
}