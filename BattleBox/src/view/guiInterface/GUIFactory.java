package view.guiInterface;

/**
 * The GUIFactory is an abstract interface for creating a GUI. It has no concrete implementations.
 */
public interface GUIFactory
{
	void createWindow(String windowTitle, int sizeX, int sizeY);
	
	Image createImage(Texture texture);
	
	TextBox createTextBox();
	
	Texture createTexture(String filename);
}
