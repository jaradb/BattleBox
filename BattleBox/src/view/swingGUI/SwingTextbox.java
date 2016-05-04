package view.swingGUI;

import view.guiInterface.TextBox;
import javax.swing.*;

import battleBox.math.Vector2;

/**
 * The SwingTextbox is a concrete implementation of the TextBox interface, allowing for a box that displays text to be created.
 */
public class SwingTextbox implements TextBox
{
	public JTextField jTextField;

	@Override
	public void setBounds(Vector2 position, Vector2 size)
	{
		jTextField.setBounds(	position.x, 
								position.y, 
								size.x, 
								size.y);
		
	}

	@Override
	public void setText(String string)
	{
		// TODO Auto-generated method stub
		jTextField.setText(string);
		
	}

}
