package top.syewiki.atk.cli.stdgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ClassStdTabbedPaneBuilder {
    private int sidebarHeight = 300; // Height for the sidebar

    public void drawPane() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tabbed Pane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

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
            JButton khomeButton = new JButton("khome");
            JButton kaboutButton = new JButton("kabout");
            JButton ksettingsButton = new JButton("ksettings");

            // Set preferred size to buttons to achieve 9:5 aspect ratio
            Dimension buttonSize = new Dimension(180, 100); // Width: 180, Height: 100 (9:5 ratio)
            khomeButton.setPreferredSize(buttonSize);
            kaboutButton.setPreferredSize(buttonSize);
            ksettingsButton.setPreferredSize(buttonSize);

            // Create content panels for each button with title bar and empty panel
            JPanel homePanel = createHomePanel(); // Special method for home panel
            JPanel aboutPanel = createContentPanel("About Page");
            JPanel settingsPanel = createContentPanel("Settings Page");

            // Add content panels to the right panel
            rightPanel.add(homePanel, "HOME");
            rightPanel.add(aboutPanel, "ABOUT");
            rightPanel.add(settingsPanel, "SETTINGS");

            // Add action listeners to buttons
            khomeButton.addActionListener(e -> cardLayout.show(rightPanel, "HOME"));
            kaboutButton.addActionListener(e -> cardLayout.show(rightPanel, "ABOUT"));
            ksettingsButton.addActionListener(e -> cardLayout.show(rightPanel, "SETTINGS"));

            // Add buttons to the left panel with GridBagConstraints
            gbc.gridy = 0;
            leftPanel.add(khomeButton, gbc);
            gbc.gridy = 1;
            leftPanel.add(kaboutButton, gbc);
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
        titleBar.add(new JLabel("Home Page"));

        // Create the content area panel with bold title and text
        JPanel contentArea = new JPanel();
        contentArea.setLayout(new BoxLayout(contentArea, BoxLayout.Y_AXIS));
        contentArea.setBackground(Color.WHITE);

        // Bold title "Welcome to ATOM"
        JLabel welcomeLabel = new JLabel("Welcome to ATOM");
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(Font.BOLD, 18)); // Bold font, size 18
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text

        // Normal content "Content"
        JLabel contentLabel = new JLabel("Content");
        contentLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text

        // Add components to the content area
        contentArea.add(Box.createVerticalStrut(20)); // Add space at the top
        contentArea.add(welcomeLabel);
        contentArea.add(Box.createVerticalStrut(10)); // Add space between title and content
        contentArea.add(contentLabel);

        // Add the title bar and content area to the home panel
        homePanel.add(titleBar, BorderLayout.NORTH);
        homePanel.add(contentArea, BorderLayout.CENTER);

        return homePanel;
    }
}
