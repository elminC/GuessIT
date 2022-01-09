package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    TextField your_number;

    @FXML
    TextField text_field;

    int randomNumber;
    int playerGuess;
    final int maxNum = 100;
    int numofGuesses = 0;
    int limitofGuesses = 7;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        playerGuess = scanner.nextInt();
        randomNumber = random.nextInt(maxNum) + 1;

    }


    public void number_typed(KeyEvent keyEvent) {
        while (playerGuess != randomNumber) {
            numofGuesses++;


            if (playerGuess < randomNumber) {
                text_field.setText("Your number is too low");
            } else
                text_field.setText("Your number is greater");
        }
        if (playerGuess == numofGuesses) {
            text_field.setText("You are correct! Good job!");

        } else if (playerGuess == limitofGuesses) {
            text_field.setText("You are out of guesses.");
        }
    }
}
