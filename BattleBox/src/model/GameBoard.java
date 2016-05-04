package model;

import java.util.ArrayList;

import battleBox.Constants;
import battleBox.math.Vector2;
import model.factories.*;

/**
 * The GameBoard, which is populated with Tokens (the player pieces) and Tiles (the grid that forms the board itself)
 */
public class GameBoard
{
	TokenFactory tokenFactory;
	TileFactory tileFactory;
	
	public Tile[][] tileGrid;
	public ArrayList<Token> tokens;
	
	public GameBoard()
	{
		tokenFactory = new TokenFactory();
		tileFactory = new TileFactory();
	}
	
	public void createGameBoard()
	{
		//Create the tiles based off the size of the board.
		int boardWidth = Constants.boardWidth;
		int boardHeight = Constants.boardHeight;
		
		tileGrid = new Tile[boardHeight][boardWidth];
		
		for(int i = 0; i < boardWidth; i++)
		{
			for(int j = 0; j < boardHeight; j++)
			{
				tileGrid[i][j] = new TileFactory().createTile("pathway", new Vector2(i, j));
			}
		}
		
		//Let's create a blockage in the middle of the board to make it more exciting.
		tileGrid[3][4] = new TileFactory().createTile("blocked", new Vector2(3, 4));
		tileGrid[4][4] = new TileFactory().createTile("blocked", new Vector2(4, 4));
		tileGrid[5][4] = new TileFactory().createTile("blocked", new Vector2(5, 4));
				
		
		//Populate the board with playable tokens, 5 for each player.
		tokens = new ArrayList<Token>();
		for(int i = 0; i < 2; i++)
		{
			int gridX = 2;
			int gridY = i == 0 ? 0 : 8;
			
			tokens.add(tokenFactory.createClassToken("archer", new Vector2(gridX, gridY), Token.Owner.values()[i]));
			gridX++;
			
			tokens.add(tokenFactory.createClassToken("cleric", new Vector2(gridX, gridY), Token.Owner.values()[i]));
			gridX++;
			
			tokens.add(tokenFactory.createClassToken("mage", new Vector2(gridX, gridY), Token.Owner.values()[i]));
			gridX++;
			
			tokens.add(tokenFactory.createClassToken("thief", new Vector2(gridX, gridY), Token.Owner.values()[i]));
			gridX++;
			
			tokens.add(tokenFactory.createClassToken("warrior", new Vector2(gridX, gridY), Token.Owner.values()[i]));
		}
	}
	
	//Scan the tokens for one at the specified location
	public Token getTokenAtLocation(Vector2 location)
	{
		for(int i = 0; i < tokens.size(); i++)
		{
			if(tokens.get(i).gridPosition.equals(location))
			{
				return tokens.get(i);
			}
		}
		
		return null;
	}
	
	
	public void handleClickEvent(Vector2 clickGridLocation)
	{
		
	}
	
}
