// GraphicsLab07st.java
// The student, starting version of the GraphicsLab07 assignment.


import java.awt.*;
import java.applet.*;


public class GraphicsLab07st extends Applet
{

	int maxX = 1024;
	int maxY = 768;
	int midX = maxX / 2;
	int midY = maxY / 2;
	int startWidth = maxX  /4;
	int startHeight = maxY / 4;
	int tlX = midX - (startWidth/2);
	int tlY = midY - (startHeight/2);

	public void paint (Graphics g)
	{
		drawSquare1( g ,  maxX ,  maxY );
		drawFractal( g , tlX , tlY , startWidth , startHeight );
	}

	public void drawSquare1(Graphics g, int maxX, int maxY)
	{
		midX = maxX/2;
		midY = maxY/2;
		startWidth = maxX/4;
		startHeight = maxY/4;
		tlX = midX - (startWidth/2);
		tlY = midY - (startHeight/2);
		g.fillRect(tlX,tlY,startWidth,startHeight);
	}

	public void delay(long n)
	{
		n *= 1000;
		long startDelay = System.nanoTime();
		long endDelay = 0;
		while (endDelay - startDelay < n )
			endDelay = System.nanoTime();
	}

	public void drawFractal(Graphics g, int maxX, int maxY, int length, int height)
	{
		if(height >= 1)
		{
			delay(500);
			g.fillRect( maxX , maxY , length , height );
			drawFractal( g , maxX - length / 2 , maxY - height / 2 , length / 2 , height / 2 );
			drawFractal( g, maxX + length, maxY - height / 2, length / 2, height / 2 );
			drawFractal( g , maxX - length / 2 , maxY + height , length /  2, height / 2 );
			drawFractal(g , maxX+length , maxY + height , length / 2  , height / 2 );
		}
	}

}


