package war.controllers;
import war.models.PlayingCard;
import war.models.Suit;
import war.models.Rank;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * GameController.java - JavaFX controller for the War card game GUI.
 * Handles all button events and updates the view.
 *
 * UD2 scope: Front-end layout with event handlers wired up.
 * PlayingCard integration as proof of concept (random cards on Draw).
 * Full game logic (Deck, Player, WarGame) will be connected in UD3.
 *
 * @author Nathan Tshishimbi
 * @version 1.1 (UD2) / (05/09/2026)
 */
public class GameController {

    //*** FXML-INJECTED UI COMPONENTS ***//

    // Player info labels (Human & CPU)
    @FXML private Label p1NameLabel;
    @FXML private Label p1CardCountLabel;
    @FXML private Label p2NameLabel;
    @FXML private Label p2CardCountLabel;

    // Card display labels (styled as card faces in FXML)
    @FXML private Label p1CardDisplay;
    @FXML private Label p2CardDisplay;

    // Game status
    @FXML private Label statusLabel;
    @FXML private Label roundLabel;
    @FXML private Label p1WinsLabel;
    @FXML private Label p2WinsLabel;

    // Buttons
    @FXML private Button drawButton;
    @FXML private Button resolveWarButton;
    @FXML private Button newGameButton;
    @FXML private Button saveButton;
    @FXML private Button loadButton;

    //*** INSTANCE VARIABLES ***//
    private int roundCount = 0;
    private int p1Wins = 0;
    private int p2Wins = 0;

    //*** INITIALIZATION ***//

    /**
     * Called automatically by JavaFX after FXML is loaded.
     * Sets up the initial state of all UI components.
     */
    @FXML
    public void initialize() {
        resolveWarButton.setDisable(true);
        statusLabel.setText("Click 'Draw Card' to begin!");
        System.out.println("GameController initialized successfully.");
    }

    //*** EVENT HANDLERS ***//

    /**
     * Handles the "Draw Card" button click.
     *
     * UD2 Proof of Concept: Creates two random PlayingCard objects
     * using the Suit and Rank enums from UD1, displays them in the
     * card labels, and uses beats() to determine the round winner.
     *
     * In UD3, this will be replaced by actual Deck/Player logic.
     */
    @FXML
    private void handleDraw() {
        // Grab all enum values for random selection
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();

        // Create random cards for each player using PlayingCard constructors
        PlayingCard p1Card = new PlayingCard(
                suits[(int) (Math.random() * suits.length)],
                ranks[(int) (Math.random() * ranks.length)],
                true  // face up so toString() shows the card
        );

        PlayingCard p2Card = new PlayingCard(
                suits[(int) (Math.random() * suits.length)],
                ranks[(int) (Math.random() * ranks.length)],
                true
        );

        // Display cards using PlayingCard.toString()
        p1CardDisplay.setText(p1Card.toString());
        p2CardDisplay.setText(p2Card.toString());

        // Use PlayingCard.beats() to determine the winner
        roundCount++;
        roundLabel.setText("Round: " + roundCount);

        if (p1Card.beats(p2Card)) {
            p1Wins++;
            statusLabel.setText("Player 1 wins this round!");
            p1WinsLabel.setText("P1 Wins: " + p1Wins);
        }
        else if (p2Card.beats(p1Card)) {
            p2Wins++;
            statusLabel.setText("Player 2 wins this round!");
            p2WinsLabel.setText("P2 Wins: " + p2Wins);
        }
        else {
            statusLabel.setText("Both played " + p1Card.getRank() + " — WAR!");
            resolveWarButton.setDisable(false);
        }

        // Console output for debugging
        System.out.println("Round " + roundCount + ": " + p1Card + " vs " + p2Card);
    }

    /**
     * Handles the "Resolve War" button click.
     * Stub for UD2 — full war logic will be implemented in UD3.
     */
    @FXML
    private void handleResolveWar() {
        statusLabel.setText("War resolved! (Full logic coming in UD3)");
        resolveWarButton.setDisable(true);
        System.out.println("Resolve War clicked.");
    }

    /**
     * Handles the "New Game" button click.
     * Resets all UI components to their initial state.
     */
    @FXML
    private void handleNewGame() {
        p1CardDisplay.setText("?");
        p2CardDisplay.setText("?");
        statusLabel.setText("New game started! Click 'Draw Card' to begin.");
        roundCount = 0;
        p1Wins = 0;
        p2Wins = 0;
        roundLabel.setText("Round: 0");
        p1WinsLabel.setText("P1 Wins: 0");
        p2WinsLabel.setText("P2 Wins: 0");
        p1CardCountLabel.setText("Cards: 26");
        p2CardCountLabel.setText("Cards: 26");
        resolveWarButton.setDisable(true);
        System.out.println("New Game clicked — UI reset.");
    }

    /**
     * Handles the "Save" button click.
     * Stub for UD2 — File I/O will be implemented in UD3.
     */
    @FXML
    private void handleSave() {
        statusLabel.setText("Game saved! (File I/O coming in UD3)");
        System.out.println("Save clicked.");
    }

    /**
     * Handles the "Load" button click.
     * Stub for UD2 — File I/O will be implemented in UD3.
     */
    @FXML
    private void handleLoad() {
        statusLabel.setText("Game loaded! (File I/O coming in UD3)");
        System.out.println("Load clicked.");
    }
}
