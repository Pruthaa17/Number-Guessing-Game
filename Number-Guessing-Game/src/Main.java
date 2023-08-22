import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.WindowAdapter;
        import java.awt.event.WindowEvent;

public class Main extends Frame {

    private static final int noOfTrials = 5;  //number of trials allowed.
    private final int number;        //holds the randomly generated number between 1 and 100.
    private int currentTrial;        //keeps track of the number of trials

    public Main() {
        number = 1 + (int) (100 * Math.random());
        currentTrial = 0;


        // properties of the main GUI frame.
        setTitle("Number Guessing Game");
        setSize(500, 350);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);

        Label instructions = new Label("A number is chosen between 1 to 100. Guess the number within 5 trials.");
        instructions.setForeground(Color.darkGray);
        add(instructions);

        Label guessLabel = new Label("Enter your guess:");
        guessLabel.setForeground(Color.black);
        Font myFont = new Font("Serif",Font.BOLD,14);
        guessLabel.setFont(myFont);
        add(guessLabel);

        TextField guessField = new TextField(10);
        add(guessField);

        Button guessButton = new Button("Guess");
        guessButton.setBackground(Color.green);
        add(guessButton);

        Label resultLabel = new Label();
        resultLabel.setForeground(Color.blue);
        add(resultLabel);

        guessButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentTrial < noOfTrials) {
                    int guess = Integer.parseInt(guessField.getText());
                    currentTrial++;

                    if (guess == number) {
                        resultLabel.setText("\nCongratulations! You guessed the number.");
                        resultLabel.setForeground(Color.green);
                    }
                    else if (guess < number) {
                        resultLabel.setText("The number is greater than " + guess);
                        resultLabel.setForeground(Color.red);
                    }
                    else {
                        resultLabel.setText("\nThe number is less than " + guess);
                        resultLabel.setForeground(Color.red);
                    }

                    if (currentTrial == noOfTrials && guess != number) {
                        resultLabel.setText("\nYou have exhausted " + noOfTrials + " trials. \nThe number was " + number);
                        resultLabel.setForeground(Color.black);
                    }
                }
            }
        } );

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.setVisible(true);
    }
}