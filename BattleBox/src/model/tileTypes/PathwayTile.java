package model.tileTypes;

import model.Tile;

/**
 * The PathwayTile is a Tile that can be occupied by a Token.
 */

public class PathwayTile  extends Tile
{
	@Override
	public String getImageAssetName()
	{
		return "pathwayTile.png";
	}
}
