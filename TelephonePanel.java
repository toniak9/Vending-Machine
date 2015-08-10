/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

/**
 *
 * @author Sruti
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelephonePanel extends JPanel

{
    public static void main (String[] args)
    {
      //  JPanel panel = new JPanel();
     //   panel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

         JPanel p = new JPanel();
        p.setLayout (new BorderLayout());
      //  p.addActionListener (new DialListener());
     JLabel title = new JLabel ("");
        p.add (title, BorderLayout.NORTH);
        JButton clear = new JButton ("clear");
      p.add (clear, BorderLayout.EAST);
    JPanel keys = new JPanel();
            keys.setLayout (new GridLayout (5,3));
         keys.add (new JButton ("send"));
       keys.add (new JButton (""));
           keys.add (new JButton ("end"));
          keys.add (new JButton ("1"));

            keys.add (new JButton ("2"));
            keys.add (new JButton ("3"));
            keys.add (new JButton ("4"));

          keys.add (new JButton ("5"));
            keys.add (new JButton ("6"));

            keys.add (new JButton ("7"));

            keys.add (new JButton ("8"));

            keys.add (new JButton ("9"));

            keys.add (new JButton ("*"));

            keys.add (new JButton ("0"));

            keys.add (new JButton ("#"));

    p.add (keys, BorderLayout.CENTER);
      // frame.add(p);

          //  frame.pack();

          //  frame.setVisible(true);

     
    }

}


