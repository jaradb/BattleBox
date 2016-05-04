package model.tileTypes;

import model.Tile;

/**
 * The BlockedTile is a Tile that cannot be occupied, but can be destroyed. 
 */
public class BlockedTile  extends Tile
{
	@Override
	public String getImageAssetName()
	{
		return "blockedTile.png";
	}
}
