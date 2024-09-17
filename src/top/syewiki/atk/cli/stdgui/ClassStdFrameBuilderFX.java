package top.syewiki.atk.cli.stdgui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClassStdFrameBuilderFX extends Application {

    private int sidebarHeight = 300; // Fixed height for the sidebar

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Tabbed Pane Example");

        // Create the root layout (BorderPane)
        BorderPane root = new BorderPane();

        // Create the left sidebar (VBox)
        VBox leftPanel = new VBox();
        leftPanel.setAlignment(Pos.TOP_CENTER);
        leftPanel.setSpacing(10);
        leftPanel.setStyle("-fx-background-color: #E0E0E0;");
        leftPanel.setPrefHeight(sidebarHeight); // Fixed height

        // Create the buttons for the left sidebar
        Button homeButton = new Button("khome");
        Button aboutButton = new Button("kabout");
        Button settingsButton = new Button("ksettings");

        // Set button size to maintain 9:5 aspect ratio
        homeButton.setPrefSize(180, 100);
        aboutButton.setPrefSize(180, 100);
        settingsButton.setPrefSize(180, 100);

        // Add buttons to the left panel
        leftPanel.getChildren().addAll(homeButton, aboutButton, settingsButton);

        // Create the right panel (StackPane) to display different content
        StackPane rightPanel = new StackPane();

        // Create content panels for each button
        VBox homePanel = createHomePanel();
        VBox aboutPanel = createContentPanel("About Page");
        VBox settingsPanel = createContentPanel("Settings Page");

        // Add all panels to the StackPane
        rightPanel.getChildren().addAll(homePanel, aboutPanel, settingsPanel);

        // Show the correct panel based on button clicks
        homeButton.setOnAction(e -> {
            homePanel.toFront();
        });

        aboutButton.setOnAction(e -> {
            aboutPanel.toFront();
        });

        settingsButton.setOnAction(e -> {
            settingsPanel.toFront();
        });

        // Set the left panel to the left side and right panel to the center of BorderPane
        root.setLeft(leftPanel);
        root.setCenter(rightPanel);

        // Create the scene
        Scene scene = new Scene(root, 600, 400);

        // Dynamically adjust the left panel width to be at most 1/5 of the window width
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double maxWidth = newVal.doubleValue() / 5; // Limit to 1/5 of the window width
            leftPanel.setPrefWidth(maxWidth);
        });

        // Show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create the home panel with a bold title and content
    private VBox createHomePanel() {
        VBox homePanel = new VBox();
        homePanel.setAlignment(Pos.CENTER);
        homePanel.setSpacing(10);
        homePanel.setStyle("-fx-background-color: white;");

        // Bold title "Welcome to ATOM"
        Label welcomeLabel = new Label("Welcome to ATOM");
        welcomeLabel.setFont(Font.font("Arial", 18)); // Bold font, size 18
        welcomeLabel.setStyle("-fx-font-weight: bold;");

        // Content text "Content"
        Label contentLabel = new Label("Content");

        // Add components to the home panel
        homePanel.getChildren().addAll(welcomeLabel, contentLabel);

        return homePanel;
    }

    // Method to create a content panel with a title and empty body
    private VBox createContentPanel(String title) {
        VBox contentPanel = new VBox();
        contentPanel.setAlignment(Pos.CENTER);
        contentPanel.setSpacing(10);
        contentPanel.setStyle("-fx-background-color: white;");

        // Title label
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", 16));
        titleLabel.setStyle("-fx-background-color: lightgray; -fx-padding: 10;");

        // Empty content area (placeholder)
        Label emptyLabel = new Label("Content");

        // Add components to the content panel
        contentPanel.getChildren().addAll(titleLabel, emptyLabel);

        return contentPanel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

