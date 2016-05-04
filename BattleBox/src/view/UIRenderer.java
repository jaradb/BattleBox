package view;

import battleBox.Constants;
import battleBox.math.Vector2;
import view.guiInterface.*;

/**
 * The UIRenderer manages rendering all the UI outside of the Board (like the Player indicator)
 */
public class UIRenderer
{
	GUIFactory guiFactory;
	
	public TextBox currentPlayerTextbox;
	
	public UIRenderer(GUIFactory guiFactoryToUse)
	{
		guiFactory = guiFactoryToUse;
	}
	
	/**
	 * Create the textbox used to tell the user which player is currently making a move.
	 */
	public void createCurrentPlayerIndicator()
	{
		currentPlayerTextbox = guiFactory.createTextBox();
		
		Vector2 textBoxSize = new Vector2(200, 50);
		
		
		currentPlayerTextbox.setBounds(new Vector2((Constants.windowWidth / 2) - (textBoxSize.x / 2), 
													Constants.windowHeight - textBoxSize.y), 
													textBoxSize);
		
		setCurrentPlayerIndicator(1);
	}
	
	public void setCurrentPlayerIndicator(int playerNumber)
	{
		if(playerNumber == 1)
		{
			currentPlayerTextbox.setText("Player 1 (Red)'s turn");
		}
		else
		{
			currentPlayerTextbox.setText("Player 2 (Blue)'s turn");
		}
	}
	
}
