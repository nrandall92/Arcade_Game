package Arcade_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

class Sound 
{
private Clip clip;
private AudioInputStream is;
private long last_play=0;

	public Sound(String name)
	{
		try
		{
			clip = AudioSystem.getClip();
			is = AudioSystem.getAudioInputStream(new File(name));
			clip.open(is);
		} 
		catch(Exception e)
		{
		}
	}
	

	public void play()
	{
		long now = new Date().getTime();
		if((now-last_play) < 250) 
		{
			return;
		}
		try
		{
			clip.stop();
			clip.setFramePosition(0);
			clip.start();
			last_play=now;
		}
		catch(Exception e)
		{
		}
	}
}
		

class SpeedUp
{
	private int x, y, dx, dy;
	private static final int DIAMETER = 20;
	private Color color;
	private player ball;
	private obstacle pillar;
	private gameover lose = new gameover();
	private static Sound sound = new Sound("sound.aiff");

	public SpeedUp()
	{
		color = new Color(76,25,0);
		Random r= new Random();
		x = r.nextInt(465) + 1;
		y = r.nextInt(465) + 1;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval((int)x,(int)y, DIAMETER, DIAMETER);
	}

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

  	public void update(double dt, player ball, gameover lose) 
	{
    		/* update the position */
    		x += (dx * dt);
    		y += (dy * dt);
		Random r = new Random();

    		/* check if we hit the snake head */
      		if(collides(ball)==true) 
		{	
        		/* change places */
        		x = r.nextInt(465) + 1;
			y = r.nextInt(465) + 1;
			sound.play();
			ball.speed += 10;
			lose.playerScore += 10;
      		}
  	}
		
}
