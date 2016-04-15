package nl.ru.ai.nakkerts.week4;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	 
    public Window() {
 
        super();
        setTitle("Callbacks");							
        setSize(new Dimension(800, 600));				//Niet wat klein?  1280 x 720 misschien? Of standaard 90% van screensize. Hoe komen we achter screen size?
        setLocationRelativeTo(null);					
        setDefaultCloseOperation(EXIT_ON_CLOSE);		
        getContentPane().setLayout(new BorderLayout());
 
        setVisible(true);
        DrawPanel rp = new DrawPanel();
        ButtonPanel bp = new ButtonPanel(rp);
        ButtonPanelColor bpc = new ButtonPanelColor(rp);    
        getContentPane().add(rp, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.SOUTH);
        getContentPane().add(bpc, BorderLayout.NORTH);
        
    }
 
}