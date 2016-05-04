package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.*;
import java.util.ArrayList;

import battleBox.math.Vector2;

/**
* An implementation of AWT's MouseListener, so we can intercept mouse clicks using AWT/Swing.
* All objects in the objectsToInvoke ArrayList will get handleClickEvent invoked on them.
* This is so any subsystem that needs to know about a mouse click can subscribe to handle it.
*/
public class BoardMouseListener implements MouseListener
{
	public Vector2 gridPosition;
	
	
	public ArrayList<Object> objectsToInvoke;

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
		//Go through every object in the list of objects listening for mouse events and trigger their "handleClickEvent"
		//provided they have it implemented. Otherwise throw an exception.
		if(objectsToInvoke != null)
		{
			for(int i = 0; i < objectsToInvoke.size(); i++)
			{
				Class<?> invokedClass = objectsToInvoke.get(i).getClass();
				Method clickHandleMethod = null;
				
				try
				{
					clickHandleMethod = invokedClass.getMethod("handleClickEvent", Vector2.class);
				} 
				catch (NoSuchMethodException e)
				{
					e.printStackTrace();
				} 
				catch (SecurityException e)
				{
					e.printStackTrace();
				}
				
				try
				{
					clickHandleMethod.invoke(objectsToInvoke.get(i), gridPosition);
				} 
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} 
				catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				} 
				catch (InvocationTargetException e)
				{
					e.printStackTrace();
				}
			}
		}
			
		System.out.println("clicked: " + gridPosition.x + " " + gridPosition.y);
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		
		
	}

}
