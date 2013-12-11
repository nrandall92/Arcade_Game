package Arcade_Game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

//this class creates the player
class player 
{
	protected int speed = 100;
	protected int x, y;
	protected boolean gameStatus=false; 
        private int dx, dy;
	private static final int DIAMETER = 20;
  	protected Color color;

  	public player( ) 
	{
    		color = new Color(250,0,0);
		x=y=250;
		dx=dy=0;	
  	}

 	public void draw(Graphics g) 
	{
		g.setColor(color);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	//left,up,right,down, stop movement
	public void left( ) {dx = -speed;}
	public void up( ) {dy = -speed;}
	public void right( ) {dx = speed;}
	public void down( ) {dy = speed;}
	public void stop( ) 
	{
		dx=dy=0;
	}

	public boolean update(double dt) 
        {
                x += (dx * dt);
                y += (dy * dt);

		
                if(y < 0 || y > 475 || x < 0 || x > 475)
		{
			stop();
			color = new Color(0,0,50);
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
