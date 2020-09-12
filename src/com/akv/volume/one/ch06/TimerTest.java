package com.akv.volume.one.ch06;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.JOptionPane;


public class TimerTest {

    public static void main(String[] args){

        TimerActionListener tal = new TimerActionListener();

        javax.swing.Timer timer = new javax.swing.Timer(1000,tal);

        timer.start();

        JOptionPane.showMessageDialog(null,"Quit Program?");

        System.exit(0);

    }

}


class TimerActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {

        System.out.println("Current time is" + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();

    }
}