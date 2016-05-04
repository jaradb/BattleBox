package view.swingGUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.guiInterface.Texture;

/**
 * The SwingTexture is a concrete implementation of the Texture interface, for loading textures from an external file.
 */
public class SwingTexture implements Texture
{
	public BufferedImage bufferedImage;
	public String filename;

	@Override
	public void loadTextureFromFile(String filename)
	{
		File filePath = new File(filename);
		
		try
		{
			bufferedImage = ImageIO.read(filePath);
		} 
		catch (IOException e)
		{
			System.out.println("Couldn't load image assets. Check path and filenames.");
		}
	}

}
