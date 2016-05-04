package view;

import java.util.ArrayList;
import battleBox.Constants;
import battleBox.math.Vector2;
import model.GameBoard;
import model.Token;
import view.guiInterface.*;


/**
 * The BoardRenderer contains a grid of Tiles and a list of Tokens to render the board to the user.
 */
public class BoardRenderer
{
	
	public GameBoard boardToRender;
	GUIFactory guiFactory;
	
	public Image crossHairLabel;
	public Image playerTurnLabel;
	
	Image[][] tileImages = null;

	ArrayList<Image> tokenImages = null;
	
	public BoardRenderer(GUIFactory guiFactoryToUse)
	{
		guiFactory = guiFactoryToUse;
	}


	public void setBoardToRender(GameBoard board)
	{
		boardToRender = board;
	}
	
	/**
	 * Create the grid of Tile Images that the BoardRenderer uses to repesent the board visually
	 */
	public void createTileImages()
	{
		int boardWidth = Constants.boardWidth;
		int boardHeight = Constants.boardHeight;
		
		tileImages = new Image[boardWidth][boardHeight];
						
		for(int i = 0; i < boardWidth; i++)
		{
			for(int j = 0; j < boardHeight; j++)
			{
				tileImages[i][j] = guiFactory.createImage(guiFactory.createTexture(boardToRender.tileGrid[i][j].getImageAssetName()));
				tileImages[i][j].setSize(new Vector2(Constants.defaultTileSize, Constants.defaultTileSize));
				tileImages[i][j].setGridPosition(new Vector2(i, j));
			}
		}
	}
	
	/**
	 * Create the list of Images of each Token currently on the GameBoard
	 */
	public void createTokenImages()
	{
		crossHairLabel  = guiFactory.createImage(guiFactory.createTexture("crosshair.png"));
		
		crossHairLabel.setSize(new Vector2(Constants.defaultTileSize, Constants.defaultTileSize));
		crossHairLabel.setGridPosition(new Vector2(0, 0));
		crossHairLabel.setVisible(false);
		
		tokenImages = new ArrayList<Image>();

		for(int i = 0; i < boardToRender.tokens.size(); i++)
		{
			Image newToken = guiFactory.createImage(guiFactory.createTexture(boardToRender.tokens.get(i).getImageAssetName()));
			newToken.setSize(new Vector2(Constants.defaultTileSize, Constants.defaultTileSize));
			newToken.setGridPosition(boardToRender.tokens.get(i).gridPosition);
			tokenImages.add(newToken);
			
			if(boardToRender.tokens.get(i).tokenOwner == Token.Owner.player1) newToken.tintTexture(1.0f, 0.5f, 0.5f);
			if(boardToRender.tokens.get(i).tokenOwner == Token.Owner.player2) newToken.tintTexture(0.5f, 0.5f, 1.0f);
		}
		
		
	}
	
	public void addMouseListeners(ArrayList<Object> listeners)
	{
		int boardWidth = Constants.boardWidth;
		int boardHeight = Constants.boardHeight;
								
		for(int i = 0; i < boardWidth; i++)
		{
			for(int j = 0; j < boardHeight; j++)
			{
				tileImages[i][j].addMouseEventListener(listeners, new Vector2(i, j));
			}
		}
		
	}
	
	/**
	 * Highlight the board around the specified area to help the user see where they're clicking.
	 */
	public void highlightTilesAroundPoint(Vector2 point, boolean highLight)
	{
		
		Image upperTile = getTileImageFromArray(point.x - 1, point.y);
		Image lowerTile = getTileImageFromArray(point.x + 1, point.y);
		Image leftTile = getTileImageFromArray(point.x, point.y - 1);
		Image rightTile = getTileImageFromArray(point.x, point.y + 1);
		Image centerTile = getTileImageFromArray(point.x, point.y);
	
		
		if(highLight)
		{
			if(upperTile != null) upperTile.tintTexture(1.0f, 1.0f, 0.1f);
			if(lowerTile != null) lowerTile.tintTexture(1.0f, 1.0f, 0.1f);
			if(leftTile != null) leftTile.tintTexture(1.0f, 1.0f, 0.1f);
			if(rightTile != null) rightTile.tintTexture(1.0f, 1.0f, 0.1f);
			if(centerTile != null) centerTile.tintTexture(1.0f, 1.0f, 0.1f);
		}
		else
		{
			if(upperTile != null) upperTile.deTint();
			if(lowerTile != null) lowerTile.deTint();
			if(leftTile != null) leftTile.deTint();
			if(rightTile != null) rightTile.deTint();
			if(centerTile != null) centerTile.deTint();
		}
	}
	

	/**
	 * Move a token image from the location it currently is in, to a new location.
	 */
	public void moveTokenImage(Vector2 originalPosition, Vector2 newPosition)
	{
		for(int i = 0; i < tokenImages.size(); i++)
		{
			if(tokenImages.get(i).getGridPosition().equals(originalPosition))
			{
				tokenImages.get(i).setGridPosition(newPosition);
			}
		}
	}
	
	public void handleClickEvent(Vector2 gridPosition)
	{
		
	}
	
	/**
	 * Private helper function to access the array without throwing an exception
	 */
	private Image getTileImageFromArray(int x, int y)
	{
		if(x < 0) return null;
		if(x >= Constants.boardWidth) return null;
		
		if(y < 0) return null;
		if(y >= Constants.boardHeight) return null;
		
		return tileImages[x][y];
		
	}
}


