package Arcade_Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


//this class is responsible for creating the gamespace
class GameBackground extends JComponent implements KeyListener
{
	private long elapsed;
	private player ball;
	private SpeedUp object;
	private obstacle pillar, pillar2, pillar3, pillar4;
	private int x,y;
	private gameover lose = new gameover();
	private static final int DIAMETER=20;

	//creates game objects
	public GameBackground( )
        {
                elapsed = new Date( ).getTime( );
                ball = new player( );
		object = new SpeedUp();
		pillar = new obstacle(100,250);
		pillar2= new obstacle(400,250);
		pillar3= new obstacle(250,100);
		pillar4= new obstacle(250,400);
        }

        //when no key is pressed
        public void keyTyped(KeyEvent e)
        {
                //ditto
        }

        //when a key is pressed the player will move
        public void keyPressed(KeyEvent e)
        {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT )
                {
			ball.stop();
                        ball.right( );
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT )
                {
			ball.stop();
                        ball.left( );
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP )
                {
			ball.stop();
                        ball.up( );
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN )
                {
			ball.stop();
                        ball.down( );
                }
        }

	//if a key is released do nothing
        public void keyReleased(KeyEvent e)
        {
                //ditto
        }

        //draws and colors all objects
	public void paintComponent(Graphics g)
	{
		if(ball.gameStatus==false && 
		   pillar.gameStatus==false && 
                   pillar2.gameStatus==false && 
                   pillar3.gameStatus==false && 
                   pillar4.gameStatus==false)
		{
			g.setColor(new Color(120, 210, 24));
			g.fillRect(0,0, 500,500);
			ball.draw(g);	
			object.draw(g);
			pillar.draw(g);
			pillar2.draw(g);
			pillar3.draw(g);
			pillar4.draw(g);	
		
			//update
    			long time_now = new Date( ).getTime( );
    			double seconds = (time_now - elapsed) / 1000.0f;
    			elapsed = time_now;
			ball.update(seconds);
			object.update(seconds, ball, lose);
			pillar.update(seconds, ball);
			pillar2.update(seconds,ball);
			pillar3.update(seconds,ball);
			pillar4.update(seconds,ball);

    			//forced update
    			revalidate( );
    			repaint( );
    		
			/* sleep for 1/20th of a second */
    			try 
			{
      				Thread.sleep(50);
    			} 
			catch(InterruptedException e) 
			{
      				Thread.currentThread( ).interrupt( );
    			}			
		}
		else
		{
			//you lose
			lose.gameover();
		}
	}
}

