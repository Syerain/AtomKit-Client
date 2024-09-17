package top.syewiki.atk.cli.stdgui;

import javax.swing.*;
import java.net.URL;

public class ClassStdFrameBuilder{

    public JButton buildButton(String title){
        JButton button = new JButton(title);
        return button;
    }
    public JButton buildButton(String title, Icon icon){
        JButton button = new JButton(title,icon);
        return button;
    }

    public void drawUI(){
        //Frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //button

        URL url = getClass().getResource("/top/syewiki/atk/gui/cli/techno.png");
        Icon imgTechno = new ImageIcon(url);
        /*JButton button = new JButton("CLICK",imgTechno);
        button.setToolTipText("tips");
        button.setBounds(50,50,50,50);  */

        //button2
        JButton button2 = this.buildButton("btn2");
        button2.setBounds(20,50,50,50);

        //button3 with a img
        JButton button3 =this.buildButton("btn3",imgTechno);
        button3.setBounds(40,50,50,50);
        button3.setSize(50,50);

        //add
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);

        //endOps
        frame.pack();
        frame.setVisible(true);
    }
}
