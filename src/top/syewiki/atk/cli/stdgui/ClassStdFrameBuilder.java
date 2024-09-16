package top.syewiki.atk.cli.stdgui;

import javax.swing.*;

public class ClassStdFrameBuilder{
    public void drawUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("CLICK");
        frame.getContentPane().add(button);

        frame.pack();
        frame.setVisible(true);
    }
}
