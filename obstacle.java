package Arcade_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class obstacle
{
	private int x,y,dx,dy;
	private static final int DIAMETER=20;
	private Color color;
	private player ball;
	protected boolean gameStatus=false;
	
	public obstacle(int a, int b)
	{
		color = new Color(0,0,0);
		x=a;
		y=b;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval((int)x,(int)y, DIAMETER, DIAMETER);
	}

	//collision with the player
	boolean collides(player ball)
        {
                int cx = x + DIAMETER / 2;
                int cy = y + DIAMETER / 2;
                int ox = ball.x + DIAMETER / 2;
                int oy = ball.y + DIAMETER / 2;

                double dist = Math.sqrt((cx - ox)*(cx - ox) + (cy - oy)*(cy - oy));

                if(dist < DIAMETER)
                {
                        return true;
                }
                else
                {
                        return false;
                }
        }

        public boolean update(double dt, player ball)
        {
                /* update the position */
                x += (dx * dt);
                y += (dy * dt);

                /* check if we hit the player */
                if(collides(ball)==true)
                {
			//if it collides set game status to true and send it to the game background
			ball.stop();
			ball.color= new Color(0,0,50);
			gameStatus=true;
			return gameStatus;
                }
		else
		{
			gameStatus=false;
			return gameStatus;
		}
        }
}
