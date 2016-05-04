package model.factories;

import battleBox.math.Vector2;
import model.Tile;
import model.tileTypes.*;

/**
 * The TileFactory creates the deepest impementation of Tile possible and places them in a position on the Grid
 */
public class TileFactory
{
	public Tile createTile(String tileType, Vector2 gridPosition)
	{
		Tile newTile = null;
		
		switch (tileType)
		{
		case "blank":
			newTile = new BlankTile();
			break;
			
		case "blocked":
			newTile = new BlockedTile();
			break;
			
		case "pathway":
			newTile = new PathwayTile();
			break;
			
		case "startingPoint":
			newTile = new StartingPointTile();
			break;
			
			
		}
		
		if(newTile == null)
		{
			System.out.println("Tried to create a tile of a non-existent type");
			return null;
		}
		
		newTile.gridPosition = gridPosition;
		
		return newTile;
	}
}
