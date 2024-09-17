package top.syewiki.atk.cli.stdgui;
import top.syewiki.atk.cli.ClassThreadAwake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ClassStdTabbedPaneBuilder {
    private int sidebarHeight = 300; // Height for the sidebar
    public ClassThreadAwake threadAwake;

    public ClassStdTabbedPaneBuilder(ClassThreadAwake threadAwake){
        this.threadAwake = new ClassThreadAwake("syewiki.top",6001);
    }

    public void drawPane(ClassThreadAwake threadAwake) {

        this.threadAwake.start();

        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("AtomKit-v1.0");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            // Create the panel for the left column with GridBagLayout
            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;

            // Create the panel for the right side with CardLayout
            JPanel rightPanel = new JPanel();
            CardLayout cardLayout = new CardLayout();
            rightPanel.setLayout(cardLayout);

            // Create buttons for the left panel
            JButton khomeButton = new JButton("主页");
            JButton kawakeButton = new JButton("唤醒页");
            JButton ksettingsButton = new JButton("设置");

            // Set preferred size to buttons to achieve 9:5 aspect ratio
            Dimension buttonSize = new Dimension(180, 100); // Width: 180, Height: 100 (9:5 ratio)
            khomeButton.setPreferredSize(buttonSize);
            kawakeButton.setPreferredSize(buttonSize);
            ksettingsButton.setPreferredSize(buttonSize);

            // Create content panels for each button with title bar and empty panel
            JPanel homePanel = createHomePanel(); // Special method for home panel
            JPanel awakePanel = createAwakePage();
            JPanel settingsPanel = createContentPanel("设置");

            // Add content panels to the right panel
            rightPanel.add(homePanel, "HOME");
            rightPanel.add(awakePanel, "AWAKE");
            rightPanel.add(settingsPanel, "SETTINGS");

            // Add action listeners to buttons
            khomeButton.addActionListener(e -> cardLayout.show(rightPanel, "HOME"));
            kawakeButton.addActionListener(e -> cardLayout.show(rightPanel, "AWAKE"));
            ksettingsButton.addActionListener(e -> cardLayout.show(rightPanel, "SETTINGS"));

            // Add buttons to the left panel with GridBagConstraints
            gbc.gridy = 0;
            leftPanel.add(khomeButton, gbc);
            gbc.gridy = 1;
            leftPanel.add(kawakeButton, gbc);
            gbc.gridy = 2;
            leftPanel.add(ksettingsButton, gbc);

            // Add panels to the frame
            frame.add(leftPanel, BorderLayout.WEST);
            frame.add(rightPanel, BorderLayout.CENTER);

            // Add ComponentListener to dynamically adjust left panel width based on frame size
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int frameWidth = frame.getWidth();
                    int maxWidth = frameWidth / 5; // Left panel max width is 1/5 of the frame width
                    leftPanel.setPreferredSize(new Dimension(maxWidth, sidebarHeight)); // Set fixed height and dynamic width
                    frame.revalidate(); // Ensure the layout is updated
                }
            });

            frame.setVisible(true);
        });
    }

    // Method to create a content panel with a title bar and an empty panel
    private JPanel createContentPanel(String title) {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create the title bar panel
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.add(new JLabel(title));

        // Create an empty panel to act as the content area
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(Color.WHITE);

        // Add the title bar and empty panel to the content panel
        contentPanel.add(titleBar, BorderLayout.NORTH);
        contentPanel.add(emptyPanel, BorderLayout.CENTER);

        return contentPanel;
    }

    // Special method to create home panel with a bold title and content
    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        // Create the title bar panel
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.add(new JLabel("主页"));

        // Create the content area panel with bold title and text
        JPanel contentArea = new JPanel();
        contentArea.setLayout(new BoxLayout(contentArea, BoxLayout.Y_AXIS));
        contentArea.setBackground(Color.WHITE);

        // Bold title "Welcome to ATOM"
        JLabel welcomeLabel = new JLabel("欢迎来到ATOM");
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(Font.BOLD, 18)); // Bold font, size 18
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text

        JPanel text = new JPanel(new GridLayout(0, 1));
        text.add(welcomeLabel);
        text.add(new JLabel("到左侧栏唤醒页输入操作码"));
        text.add(new JLabel("甲辰龙年 癸酉月 甲申日"));
        text.add(new JLabel("中秋节快乐!!!"));
        text.setBackground(Color.WHITE);

        /*
        // Normal content "Content"
        JLabel contentLabel = new JLabel("<html><body><p align=\"center\">到左侧栏唤醒页输入操作码<br/>甲辰龙年 癸酉月 甲申日<br/>中秋节快乐!!!</p></body></html>");
        contentLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Center the text
        */

        // Add components to the content area
        /*
        contentArea.add(Box.createVerticalStrut(20)); // Add space at the top
        contentArea.add(welcomeLabel);
        contentArea.add(Box.createVerticalStrut(10)); // Add space between title and content

        contentArea.add(contentLabel);
        */

        URL url = getClass().getResource("/top/syewiki/atk/gui/cli/moonCake.png");
        Icon moonCakeImage = new ImageIcon(url);
        JLabel moonCake = new JLabel(moonCakeImage);
        moonCake.setOpaque(true);
        moonCake.setBackground(Color.WHITE);

        // Add the title bar and content area to the home panel
        homePanel.add(titleBar, BorderLayout.NORTH);
        homePanel.add(contentArea, BorderLayout.CENTER);
        homePanel.add(moonCake, BorderLayout.SOUTH);
        homePanel.add(text,BorderLayout.CENTER);

        return homePanel;
    }

    private JPanel createAwakePage(){
        JPanel awakePanel = new JPanel();
        awakePanel.setLayout(new BorderLayout());

        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.add(new JLabel("唤醒页"));
        awakePanel.add(titleBar,BorderLayout.NORTH);

        JTextField opCodeTF = new JTextField(null,"请输入操作码(点击清空)",20);
        awakePanel.add(opCodeTF,BorderLayout.CENTER);

        URL url = getClass().getResource("/top/syewiki/atk/gui/cli/techno.png");
        Icon imgTechno = new ImageIcon(url);
        JButton sendB = new JButton("发送",imgTechno);
        sendB.setToolTipText("发送操作码");
        sendB.setBackground(Color.GRAY);
        awakePanel.add(sendB,BorderLayout.EAST);

        JPanel contentArea = new JPanel();
        contentArea.setLayout(new BoxLayout(contentArea, BoxLayout.Y_AXIS));
        contentArea.setBackground(Color.WHITE);

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opCodeTF.requestFocus();
                int echoValue = JOptionPane.showConfirmDialog(null,"确定要发送吗","WARNING",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
                if (echoValue==JOptionPane.YES_OPTION){
                    String opCode = opCodeTF.getText();
                    threadAwake.msger.sendMsg(opCode);
                } else if (echoValue==JOptionPane.NO_OPTION) {
                } else {
                }
            }
        };
        sendB.addActionListener(buttonListener);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1){
                    opCodeTF.setText("");
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        opCodeTF.addMouseListener(mouseListener);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    int echoValue = JOptionPane.showConfirmDialog(null,"确定要发送吗","WARNING",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
                    if (echoValue==JOptionPane.YES_OPTION){
                        String opCode = opCodeTF.getText();
                        threadAwake.msger.sendMsg(opCode);
                    } else if (echoValue==JOptionPane.NO_OPTION) {
                    } else {
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        opCodeTF.addKeyListener(keyListener);

        return awakePanel;
    }
}



