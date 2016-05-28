/* Joshua Marasigan
 * OfficeCombat <Main.java>
 * */

package officecombat;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
	
	/* --------------- */
	/* [Global Fields] */
	/* --------------- */
	private static GridPane screenSelection = new GridPane();
	private static AudioClip selFX;
	private static AudioClip hoverFX;
	private static Button tile1;
	private static Button tile2;
	private static Button tile3;
	private static Button tile4;
	private static Button tile5;
	private static Button tile6;
	private static VBox rightSelect;
	private static BackgroundImage myBG;
	private static MediaPlayer mTheme;
	private static MediaPlayer sTheme;
	private static AudioClip hitFX;
	private static VBox titleDiv;
	private static Scene titleScene;
	private static ToggleButton startBtn;
	private static HBox selectDiv;
	private static VBox leftSelect;
	
	/* Global stage to edit throughout Model */
	private static Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Stage initializations
			window = primaryStage;
			window.setTitle("Office Combat!");
			
			// Background Image
			myBG = new BackgroundImage(
					new Image("file:BG.png",450,400,true,true), 
					BackgroundRepeat.REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			
			/* -------------- */
			/* [Title Screen] */
			/* -------------- */
			
			// Animation title sprite.
			
			// Title Screen Music
			File theme = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Azureflux_Intro.mp3");
			String titleSound = theme.toURI().toString();
			Media mainTheme = new Media(titleSound);
			mTheme = new MediaPlayer(mainTheme);
			
			File selec = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Azureflux_Bit_Bossa.mp3");
			String selecSoun = selec.toURI().toString();
			Media select = new Media(selecSoun);
			sTheme = new MediaPlayer(select);
			
			// Selection FX
			File hovb = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Bang.mp3");
			String hoverb = hovb.toURI().toString();
			selFX = new AudioClip(hoverb);
			
			File pun = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Punch_A.mp3");
			String punchA = pun.toURI().toString();
			hitFX = new AudioClip(punchA);
			
			// Play main theme until exit Title scene.
			mTheme.play();
			
			// Sound Effects
			File hov = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Hover.mp3");
			String hover = hov.toURI().toString();
			hoverFX = new AudioClip(hover);
			
			File rin = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\OfficeCombat\\Ring.mp3");
			String ring = rin.toURI().toString();
			new AudioClip(ring);
			
			// Title Images
			Image banner = new Image("file:Title_A.png");
	        ImageView mainBanner = new ImageView(banner);
			mainBanner.setEffect(new DropShadow());
	        
			// Button Init. w/ Images
			Image startB = new Image("file:Start_Btn.png");
			startBtn = new ToggleButton();
			startBtn.setPadding(Insets.EMPTY);
			startBtn.setEffect(new DropShadow());
			startBtn.setStyle("-fx-background-color: transparent;");
			startBtn.setGraphic(new ImageView(startB));
			
			// Button Hover Effect
			startBtn.setOnMouseEntered(e->{
				startBtn.setTranslateY(-5);
				hoverFX.play(10);
			});
			startBtn.setOnMouseExited(e->{
				startBtn.setTranslateY(5);
			});
			
			// Grouping for Title Screen
			titleDiv = new VBox(20);
			titleDiv.setBackground(new Background(myBG));
			titleDiv.setAlignment(Pos.CENTER);
			titleDiv.getChildren().addAll(mainBanner, startBtn);
			
			// Initialize primaryStage to Title Screen.
			titleScene = new Scene(titleDiv, 450, 400);
			window.setScene(titleScene);
			window.show();

			/* ------------------- */
			/* Character Selection */
			/* ------------------- */
			selectDiv = new HBox();
			selectDiv.setBackground(new Background(myBG));
			selectDiv.setAlignment(Pos.CENTER);

			// Select Banner
			Image sBanner = new Image("file:charSelect.png");
	        ImageView selBanner = new ImageView(sBanner);
	        selBanner.setEffect(new DropShadow());
			HBox holdB = new HBox();
			holdB.getChildren().addAll(selBanner);
			holdB.setAlignment(Pos.CENTER);

	        // Initialize tiles for select
			setSelect();
			
			// Left Side
			leftSelect = new VBox();
			leftSelect.getChildren().addAll(holdB, screenSelection);
			
			// Right Side			
			rightSelect = new VBox();
			
			// Retrieve both sides and set scene.
			selectDiv.getChildren().addAll(leftSelect, rightSelect);
			Scene selectScene = new Scene(selectDiv, 450, 400);
			
			startBtn.setOnAction(e -> {
				mTheme.stop();
				hitFX.play();
				window.setScene(selectScene);
				sTheme.play();
			});
			
			/* -------------- */
			/* [Fight Screen] */
			/* -------------- */
			HBox fightDiv = new HBox();
			TextField d = new TextField("Hi");
			fightDiv.getChildren().addAll(d);
			
			Scene fight = new Scene(fightDiv);
			
			// Char Select scene transition
			tile1.setOnAction(e -> {
				hitFX.play();
				sTheme.stop();
				window.setScene(fight);
			});
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Event handler for char select btn */
	@SuppressWarnings("unused")
	private static void whenPressed() {
		
		// Use in conjunction w/ Lambda expression. (replace {..} w/ label)
	}
	
	/* ---------------------------------------------------- */
	/* Place all tile elements of character to select board */
	/* ---------------------------------------------------- */
	private static void setSelect() {
		
		// Initial gridpane reference
		int i = 0;
        int j = 0;
        
        // First Tile with Event Handlers
		tile1 = new Button();
		Image tileA = new Image("file:icon_A1.png");
		Image tileAS = new Image("file:icon_A2.png");
		tile1.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile1.setGraphic(new ImageView(tileA));
		tile1.setPadding(Insets.EMPTY);
		tile1.setOnMouseEntered(e -> {
			tile1.setGraphic(new ImageView(tileAS));
			selFX.play(.5);
		});
		tile1.setOnMouseExited(e -> {
			tile1.setGraphic(new ImageView(tileA));
		});
		screenSelection.add(tile1, j, i);
		
		// Tile 2
		i+=0;
		j+=1;
		tile2 = new Button();
		Image tileB = new Image("file:icon_B1.png");
		Image tileBS = new Image("file:icon_B2.png");
		tile2.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile2.setGraphic(new ImageView(tileB));
		tile2.setPadding(Insets.EMPTY);
		tile2.setOnMouseEntered(e -> {
			tile2.setGraphic(new ImageView(tileBS));
			selFX.play(.5);
			new Label("Test 2");
		});
		tile2.setOnMouseExited(e -> {
			tile2.setGraphic(new ImageView(tileB));
		});
		screenSelection.add(tile2, j, i);
        
		// Tile 3
		i+=0;
		j+=1;
		tile3 = new Button();
		Image tileC = new Image("file:icon_C1.png");
		Image tileCS = new Image("file:icon_C2.png");
		tile3.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile3.setGraphic(new ImageView(tileC));
		tile3.setPadding(Insets.EMPTY);
		tile3.setOnMouseEntered(e -> {
			tile3.setGraphic(new ImageView(tileCS));
			selFX.play(.5);
			new Label("Test 3");
		});
		tile3.setOnMouseExited(e -> {
			tile3.setGraphic(new ImageView(tileC));
		});
		screenSelection.add(tile3, j, i);
		
		// Tile 4
		i=1;
		j=0;
		tile4 = new Button();
		Image tileD = new Image("file:icon_D1.png");
		Image tileDS = new Image("file:icon_D2.png");
		tile4.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile4.setGraphic(new ImageView(tileD));
		tile4.setPadding(Insets.EMPTY);
		tile4.setOnMouseEntered(e -> {
			tile4.setGraphic(new ImageView(tileDS));
			selFX.play(.5);
			new Label("Test 4");
		});
		tile4.setOnMouseExited(e -> {
			tile4.setGraphic(new ImageView(tileD));
		});
		screenSelection.add(tile4, j, i);
		
		// Tile 5
		i+=0;
		j+=1;
		tile5 = new Button();
		Image tileE = new Image("file:icon_E1.png");
		Image tileES = new Image("file:icon_E2.png");
		tile5.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile5.setGraphic(new ImageView(tileE));
		tile5.setPadding(Insets.EMPTY);
		tile5.setOnMouseEntered(e -> {
			tile5.setGraphic(new ImageView(tileES));
			selFX.play(.5);
			new Label("Test 5");
		});
		tile5.setOnMouseExited(e -> {
			tile5.setGraphic(new ImageView(tileE));
		});
		screenSelection.add(tile5, j, i);
		
		// Tile 6
		i+=0;
		j+=1;
		tile6 = new Button();
		Image tileF = new Image("file:icon_F1.png");
		Image tileFS = new Image("file:icon_F2.png");
		tile6.setStyle("-fx-background-color: transparent; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );");
		tile6.setGraphic(new ImageView(tileF));
		tile6.setPadding(Insets.EMPTY);
		tile6.setOnMouseEntered(e -> {
			tile6.setGraphic(new ImageView(tileFS));
			selFX.play(.5);
			new Label("Test 6");
		});
		tile6.setOnMouseExited(e -> {
			tile6.setGraphic(new ImageView(tileF));
		});
		screenSelection.add(tile6, j, i);

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
