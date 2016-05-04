package controller;
import battleBox.Constants;
import battleBox.math.Vector2;
import model.GameBoard;
import model.Token;
import view.ViewRenderer;

/**
 * The TurnController controls which player is currently making their turn, and handles inputs from the user to translate them
 * into game actions. 
 */
public class TurnController 
{
	//The current state of the turn.
	public enum TurnState
	{
		waitingToSelectToken,
		waitingToMoveToken,
	}
	
	public ViewRenderer viewRenderer;
	TurnState currentState = TurnState.waitingToSelectToken;
	Token tokenCurrentlySelected = null;
	
	public GameBoard boardToControl;
	
	public PlayerController player1;
	public PlayerController player2;
	
	private PlayerController currentPlayersTurn = null;
	
	float currentTurnTimer = 0;
	
	public void initialisePlayers()
	{
		player1 = new PlayerController(1);
		player2 = new PlayerController(2);
		
		currentPlayersTurn = player1;
	}
	
	public void switchPlayers()
	{
		//Switch player
		if(currentPlayersTurn == player1)
		{
			viewRenderer.uiRenderer.setCurrentPlayerIndicator(2);
			currentPlayersTurn = player2;
		}
		else if(currentPlayersTurn == player2) 
		{
			viewRenderer.uiRenderer.setCurrentPlayerIndicator(1);
			currentPlayersTurn = player1;
		}
				
		//Reset the turn timer when the player turns change over
		currentTurnTimer = 0;
		currentState = TurnState.waitingToSelectToken;
		tokenCurrentlySelected = null;
	}
	
	public void updateTurn(float timeDelta)
	{
		//If the time delta exceeds a second, that means the program must of froze while calculating the time delta. Let's make sure it isn't excessive.
		if(timeDelta > 1.0) timeDelta = 1.0f;
		
		//Track how many seconds have passed.
		currentTurnTimer += timeDelta;
		
		//Times up, change players.
		if(currentTurnTimer > Constants.turnTimeInSeconds)
		{
			switchPlayers();
		}
		
		//Let's sleep the thread for a bit so we don't choke the other threads (like the UI rendering one)
		try
		{
			Thread.sleep(5);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void handleClickEvent(Vector2 clickGridLocation)
	{
		//Let's figure out if a token was clicked on
		Token tokenClicked = boardToControl.getTokenAtLocation(clickGridLocation);

		//And depending on the state we're currently in, lets see what actions we can take.
		if(currentState == TurnState.waitingToSelectToken)
		{
			if(tokenClicked != null)
			{
				if(tokenClicked.tokenOwner == Token.Owner.player1 && currentPlayersTurn.playerIndex == 1)
				{
					//Got control of a token
					currentState = TurnState.waitingToMoveToken;
					tokenCurrentlySelected = tokenClicked;
					
					//Show the crosshair so the player knows they clicked a token.
					viewRenderer.boardRenderer.crossHairLabel.setGridPosition(clickGridLocation);
					viewRenderer.boardRenderer.crossHairLabel.setVisible(true);
					
					//Also highlight the moveable area.
					viewRenderer.boardRenderer.highlightTilesAroundPoint(clickGridLocation, true);
					
					return;
				}
				
				if(tokenClicked.tokenOwner == Token.Owner.player2 && currentPlayersTurn.playerIndex == 2)
				{
					//Got control of a token
					System.out.println("Player 2 got control of token!");
					
					currentState = TurnState.waitingToMoveToken;
					tokenCurrentlySelected = tokenClicked;
					
					viewRenderer.boardRenderer.crossHairLabel.setGridPosition(clickGridLocation);
					viewRenderer.boardRenderer.crossHairLabel.setVisible(true);
					viewRenderer.boardRenderer.highlightTilesAroundPoint(clickGridLocation, true);
					
					return;
				}
			}
		}
		
		if(currentState == TurnState.waitingToMoveToken)
		{
			if(tokenClicked == null)
			{
				viewRenderer.boardRenderer.moveTokenImage(tokenCurrentlySelected.gridPosition , clickGridLocation);
				
				viewRenderer.boardRenderer.highlightTilesAroundPoint(tokenCurrentlySelected.gridPosition, false);
				
				tokenCurrentlySelected.gridPosition = clickGridLocation;
				System.out.println("Token just moved to new location!");
				
				viewRenderer.boardRenderer.crossHairLabel.setVisible(false);
				
				//Successfully made a move, so lets switch players.
				switchPlayers();
			}
		}

	}
	
	
	
	
}
