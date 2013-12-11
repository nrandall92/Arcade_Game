package Arcade_Game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;


public class main
{
        public static void main(String args[])
        {
                JFrame frame = new JFrame("Speed Ball");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
		//add the gamebackground
		GameBackground g = new GameBackground();
		frame.add(g);
		frame.addKeyListener(g);

                frame.setSize(500,500);
                frame.setVisible(true);
        }
}

