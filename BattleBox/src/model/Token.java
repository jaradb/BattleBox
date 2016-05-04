package model;

import battleBox.math.Vector2;

/**
 * A base Token class for every piece on the GameBoard
 */
public class Token 
{
	public enum Owner
	{
		player1,
		player2,
		neutral
	}
	
	public Owner tokenOwner;
	
	public Vector2 gridPosition;
	
	public String getImageAssetName()
	{
		return "Not implemented";
	}
	
}
