package view.guiInterface;
import java.util.ArrayList;

import battleBox.math.Vector2;

/**
 * The Image is an abstract interface of an Image that can be rendered. It has no concrete implementations.
 */
public interface Image
{
	void setVisible(boolean isVisible);
	
	void setPosition(Vector2 screenSpacePosition);
	
	void setSize(Vector2 size);
	
	void setGridPosition(Vector2 gridPosition);
	Vector2 getGridPosition();
	
	void setTexture(Texture newTexture);
	void tintTexture(float r, float g, float b);
	void deTint();
	
	void addMouseEventListener(ArrayList<Object> listeners, Vector2 gridPosition);
}
