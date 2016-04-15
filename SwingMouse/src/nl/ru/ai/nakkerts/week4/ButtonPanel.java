package nl.ru.ai.nakkerts.week4;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
    public ButtonPanel(DrawPanel panel) {
        super();
 
        JButton button1 = new JButton("Rectangle");
        JButton button2 = new JButton("Ellipse");
        JButton button3	= new JButton("Line");
        JButton button8	= new JButton("Move");
        //JButton button4 = new JButton("add");
        //JButton button5 = new JButton("mod");
        JButton button6 = new JButton("Remove");
        JButton button7 = new JButton("Resize");
        JButton button9	= new JButton("Borders");
 
        add(button1);
        add(button2);
        add(button3);
        //add(button4);
        //add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        
        InputHandler IH = new InputHandler(panel);
 
        button1.addActionListener(IH);
        button2.addActionListener(IH);
        button3.addActionListener(IH);
        //button4.addActionListener(IH);
        //button5.addActionListener(IH);
        button6.addActionListener(IH);
        button7.addActionListener(IH);
        button8.addActionListener(IH);
        button9.addActionListener(IH);
    }
}