package view;

import battleBox.Constants;
import battleBox.math.Vector2;
import model.GameBoard;
import view.guiInterface.GUIFactory;

/**
 * The ViewRenderer oversees the rendering of the board, and of the UI.
 */
public class ViewRenderer
{
	GUIFactory guiFactory;
	
	public BoardRenderer boardRenderer;
	public UIRenderer uiRenderer;
	
	public void initialiseRenderer(GUIFactory factoryToUse)
	{
		guiFactory = factoryToUse;
		
		boardRenderer = new BoardRenderer(guiFactory);
		uiRenderer = new UIRenderer(guiFactory);
	}
	
	public void createWindow()
	{
		guiFactory.createWindow(Constants.windowTitle, Constants.windowWidth, Constants.windowHeight);
	}
	
	public void createBoardView(GameBoard board)
	{
		boardRenderer.setBoardToRender(board);
		
		boardRenderer.createTokenImages();
		boardRenderer.createTileImages();
		
		uiRenderer.createCurrentPlayerIndicator();
	}
	
	
	public void handleClickEvent(Vector2 gridPosition)
	{
		boardRenderer.handleClickEvent(gridPosition);
	}
	
	
	
}

