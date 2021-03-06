package battleBox;

import java.util.ArrayList;

import controller.TurnController;
import model.GameBoard;
import view.ViewRenderer;
import view.swingGUI.SwingFactory;

public class Main
{
	static TurnController turnController;
	static ViewRenderer viewRenderer;
	static GameBoard gameBoard;
	
	static SwingFactory guiRenderer;

	public static void main(String[] args)
	{
		//Create the renderer we're going to use to create the view.
		//We're using Swing/AWT, but an abstract factory exists so 
		//multiple renderer interfaces can be made.
		guiRenderer = new SwingFactory();
		
		
		//Create the view, model (GameBoard) and controller.
		viewRenderer = new ViewRenderer();
		gameBoard = new GameBoard();
		turnController = new TurnController();
		
		//Initialise the gameboard by populating it with Tiles and Tokens 
		gameBoard.createGameBoard();
		
		//Initialise the render with the concrete GUI factory implementation
		viewRenderer.initialiseRenderer(guiRenderer);
		viewRenderer.createWindow();
		viewRenderer.createBoardView(gameBoard);
		
		//Register the mouse listeners so they can respond to mouse events
		ArrayList<Object> mouseListeners = new ArrayList<Object>();
		mouseListeners.add(turnController);
		mouseListeners.add(gameBoard);
		mouseListeners.add(viewRenderer);
		viewRenderer.boardRenderer.addMouseListeners(mouseListeners);

		//Initialise the players and set up the turn controller to start the main game loop
		turnController.initialisePlayers();
		turnController.boardToControl = gameBoard;
		turnController.viewRenderer = viewRenderer;

		//Create a time delta using two points of time measured by System.nanoTime().
		long start = 0;
		long end = 0;
		
		//Start the main logic loop.
		do
		{
			//Get the start time
			start = System.nanoTime();
			
			//Update the turn controller, specifying a time delta in seconds
			turnController.updateTurn((start - end) / Constants.nanoSecondsPerSecond);
			
			//Set our end time to our start time so we can figure out a delta.
			end = start;
		}
		while(true);	//The game loop runs into the main window closes, then the program is terminated.
		
		
	}

}
