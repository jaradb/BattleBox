package battleBox.math;

/**
* A simple two point Vector class for keeping track of the 2d grid.
*/
public class Vector2
{
	public int x;
	public int y;
	
	public Vector2(int newX, int newY)
	{
		x = newX;
		y = newY;
	}
	
	public Vector2()
	{
		x = 0;
		y = 0;
	}
	
	//Make sure the equality method checks the contents of both the x and the y values
    @Override
    public boolean equals(Object obj) 
    {
       if(!(obj instanceof Vector2)) return false;
      
       Vector2 objAsVector = (Vector2)obj;
       
       if(objAsVector.x == this.x && objAsVector.y == this.y) return true;
       
       return false;
      
    }
}
