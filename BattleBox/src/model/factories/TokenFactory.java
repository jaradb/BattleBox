package model.factories;

import battleBox.math.Vector2;
import model.Token;
import model.tokenTypes.*;
import model.tokenTypes.classTokenTypes.*;

/**
 * The TileFactory creates the deepest implementation of Token possible and places them in a position on the Grid, 
 * along with the owner of the token.
 */
public class TokenFactory
{
	public ClassToken createClassToken(String classType, Vector2 gridPosition, Token.Owner tokenOwner)
	{
		ClassToken newClassToken = null;
		
		switch (classType)
		{
		case "archer":
			newClassToken = new ArcherClassToken();
			break;
			
		case "cleric":
			newClassToken = new ClericClassToken();
			break;
			
		case "mage":
			newClassToken = new MageClassToken();
			break;
			
		case "thief":
			newClassToken = new ThiefClassToken();
			break;
			
		case "warrior":
			newClassToken = new WarriorClassToken();
			break;
		}
		
		if(newClassToken == null)
		{
			System.out.println("Tried to create a token of a non-existent type");
			return null;
		}
		
		newClassToken.tokenOwner = tokenOwner;
		newClassToken.gridPosition = gridPosition;
		
		return newClassToken;
	}
}
