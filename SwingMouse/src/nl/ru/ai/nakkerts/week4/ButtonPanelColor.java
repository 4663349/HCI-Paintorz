package nl.ru.ai.nakkerts.week4;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanelColor extends JPanel{
    public ButtonPanelColor(DrawPanel panel) {
        super();
         
        
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3	= new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();
        JButton button9 = new JButton();
        JButton button10= new JButton();
        JButton button11 = new JButton();
        JButton button12 = new JButton();
        JButton button13 = new JButton();
        
        button1.setActionCommand("black");
        button2.setActionCommand("blue");
        button3.setActionCommand("cyan");
        button4.setActionCommand("darkgray");
        button5.setActionCommand("gray");
        button6.setActionCommand("lightgray");
        button7.setActionCommand("green");
        button8.setActionCommand("magenta");
        button9.setActionCommand("orange");
        button10.setActionCommand("pink");
        button11.setActionCommand("red");
        button12.setActionCommand("yellow");
        button13.setActionCommand("white");
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
        add(button13);
        
        InputHandlerNorth IHC = new InputHandlerNorth(panel);
        
        button1.addActionListener(IHC);
        button2.addActionListener(IHC);
        button3.addActionListener(IHC);
        button4.addActionListener(IHC);
        button5.addActionListener(IHC);
        button6.addActionListener(IHC);
        button7.addActionListener(IHC);
        button8.addActionListener(IHC);
        button9.addActionListener(IHC);
        button10.addActionListener(IHC);
        button11.addActionListener(IHC);
        button12.addActionListener(IHC);
        button13.addActionListener(IHC);
        
         
    }
}