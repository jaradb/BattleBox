package model.tileTypes;

import model.Tile;

/**
 * The StartingPointTile is a Tile that is used as the start (or spawn) point for Tokens
 */
public class StartingPointTile  extends Tile
{
	@Override
	public String getImageAssetName()
	{
		return "startingPointTile.png";
	}
}
