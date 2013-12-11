package Arcade_Game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

//creates the game over screen and tells the player score
class gameover
{
protected int playerScore=0;

	public void gameover()
	{
		JFrame frame = new JFrame("Game Over!");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		//create score
		JLabel score = new JLabel("Player Score: " + playerScore);
		score.setHorizontalAlignment(JLabel.CENTER);
		frame.add(score);

		//adds the quit button and adds the action listener
		JButton quit = new JButton("Exit Game");
		frame.getContentPane().add(quit);
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		frame.setSize(200,75);
		frame.setVisible(true);
	}
}


