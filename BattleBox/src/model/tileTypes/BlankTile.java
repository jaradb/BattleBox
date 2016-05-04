package model.tileTypes;

import model.Tile;

/**
 * The BlankTile is a Tile that cannot be occupied or manipulated. 
 */

public class BlankTile extends Tile
{
	@Override
	public String getImageAssetName()
	{
		return "blankTile.png";
	}
}
