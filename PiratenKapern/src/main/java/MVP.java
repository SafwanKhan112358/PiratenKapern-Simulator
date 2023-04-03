import pk.Dice;
import pk.Faces;
import java.util.ArrayList;
import java.util.Random;

public class MVP {


    public static void main(String[] args) {


        //simulation and currentGame variables
        int simulation = 42;
        int currentGame = 1;
        int winningCondition = 6000;

        //create 2 new Players, with an initial score of 0 and wins 0, and initial coinCount to 0;
        Player player1 = new Player(0, 0, 0);
        ArrayList<Faces> rollResult = new ArrayList<Faces>();
        int skullCount = 0;

        Player player2 = new Player(0, 0, 0);
        ArrayList<Faces> rollResultPlayer2 = new ArrayList<Faces>();
        int skullCountPlayer2 = 0;


        //simulation loop
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("GAME SIMULATION");
        while (currentGame <= simulation) {


            System.out.printf("GAME %d \n", currentGame);

            //debugging statements
            System.out.printf("Player 1 score at start of game: %d \n", player1.score);
            System.out.printf("Player 2 score at start of game: %d \n", player2.score);

            gameloop:

            //repeated abstraction of rolling all 8 dice and adding them to a given player's rollResult

            while (true) {


                System.out.println("Player 1's turn: ");

                //treat as player.FirstRoll(player1)

                //game specific or player specific
                for (int i = 0; i < 8; i++) {
                    rollResult.add(player1.dice1.roll());

                }


                System.out.println(rollResult);


                //skullCheck is probably a method that belongs to the game class, but it takes in a player object

                //access the rolls
                //purpose to check for skulls

                for (Faces i : rollResult) {

                    if (i.equals(Faces.SKULL)) {
                        skullCount = skullCount + 1;
                    }

                }

                //while loop conditioning
                //treat as player.strategy(player1)

                while (skullCount < 3) {

                    //win check to break out of game loop;
                    if (player1.score >= winningCondition) {

                        System.out.println("Player 1 wins this game!");
                        //increment win count
                        player1.wins = player1.wins + 1;

                        //resetting
                        player1.coinCount = 0;
                        skullCount = 0;
                        rollResult.clear();
                        break gameloop;

                    }

                    //how many dice can I re-roll?
                    System.out.printf("Player 1 could continue and %d dice can be re-rolled", 8 - skullCount);

                    System.out.println();

                    Random random = new Random();

                    //generate a random number between 0 and 1;
                    //int number = random.nextInt(2);
                    int number = random.nextInt(2);

                    //if it's one keep going
                    if (number == 1) {

                        System.out.println("Player 1 wants to keep going");

                        //erase  ArrayList
                        rollResult.clear();

                        //re-roll all available dice

                        for (int i = 0; i < 8 - skullCount; i++) {

                            rollResult.add(player1.dice1.roll());


                        }

                        for (Faces i : rollResult) {

                            if (i.equals(Faces.SKULL)) {
                                skullCount = skullCount + 1;

                            }


                        }


                        System.out.println(rollResult);

                    }

                    //don't want to continue
                    //this should somehow be integrated with the else statement on the bottom;
                    else {
                        System.out.println("Player 1 doesn't want to continue");

                        //Access the currrent ArrayList and look for Diamonds or Gold
                        for (Faces i : rollResult) {

                            if (i.equals(Faces.DIAMOND) || i.equals(Faces.GOLD)) {
                                player1.coinCount = player1.coinCount + 1;


                            }


                        }

                        player1.score = player1.score + 100 * player1.coinCount;

                        System.out.println(player1.score);


                        //win check to break out of game loop;
                        if (player1.score >= winningCondition) {

                            System.out.println("Player 1 wins this game!!");
                            //increment win count
                            player1.wins = player1.wins + 1;

                            //resetting
                            player1.coinCount = 0;
                            skullCount = 0;
                            rollResult.clear();
                            break gameloop;

                        }


                        break;

                    }


                }


                if (skullCount >= 3) {
                    System.out.printf("3 or more skulls obtained in this turn. Player 1 has finished its turn. Player 1 has %d points in the game\n", player1.score);

                } else {

                    System.out.printf("Player 1 has finished its turn. Player 1 has %d points in the game \n", player1.score);

                }

                //resetting
                player1.coinCount = 0;
                skullCount = 0;
                rollResult.clear();


                //player2
                System.out.println("********************************************");
                System.out.println("Player 2's turn: ");

                //treat as player.FirstRoll(player2)
                for (int i = 0; i < 8; i++) {
                    rollResultPlayer2.add(player2.dice1.roll());

                }

                System.out.println(rollResultPlayer2);


                //access the rolls
                //purpose to check for skulls

                for (Faces i : rollResultPlayer2) {

                    if (i.equals(Faces.SKULL)) {

                        skullCountPlayer2 = skullCountPlayer2 + 1;

                    }

                }


                //while loop conditioning
                //treat as player.strategy(player2)

                while (skullCountPlayer2 < 3) {

                    //win check to break out of game loop;
                    if (player2.score >= winningCondition) {

                        System.out.println("Player 2 wins this game!");
                        //increment win count
                        player2.wins = player2.wins + 1;

                        //resetting
                        player2.coinCount = 0;
                        skullCountPlayer2 = 0;
                        rollResultPlayer2.clear();
                        break gameloop;


                    }

                    //how many dice can I re-roll?
                    System.out.printf("Player 2 could continue and %d dice can be re-rolled \n", 8 - skullCountPlayer2);

                    System.out.println();

                    Random random = new Random();

                    //generate a random number between 0 and 1;
                    int number = random.nextInt(2);

                    System.out.println(number);

                    //if it's one keep going
                    if (number == 1) {
                        System.out.println("Player 2 wants to keep going");

                        //erase  ArrayList
                        rollResultPlayer2.clear();

                        //re-roll all available dice
                        for (int i = 0; i < 8 - skullCountPlayer2; i++) {

                            rollResultPlayer2.add(player2.dice1.roll());


                        }

                        for (Faces i : rollResultPlayer2) {

                            if (i.equals(Faces.SKULL)) {

                                skullCountPlayer2 = skullCountPlayer2 + 1;

                            }

                        }


                        System.out.println(rollResultPlayer2);

                    }

                    //don't want to continue
                    //this should somehow be integrated with the else statement on the bottom;
                    else {
                        System.out.println("Player 2 doesn't want to continue");

                        //Access the currrent ArrayList and look for Diamonds or Gold
                        for (Faces i : rollResultPlayer2) {

                            if (i.equals(Faces.DIAMOND) || i.equals(Faces.GOLD)) {
                                player2.coinCount = player2.coinCount + 1;


                            }


                        }

                        player2.score = player2.score + 100 * player2.coinCount;

                        System.out.println(player2.score);

                        //win check
                        if (player2.score >= winningCondition) {

                            System.out.println("Player 2 wins this game!!");
                            //increment win count
                            player2.wins = player2.wins + 1;
                            //resetting
                            player2.coinCount = 0;
                            skullCountPlayer2 = 0;
                            rollResultPlayer2.clear();
                            break gameloop;

                        }


                        break;

                    }


                }

                if (skullCountPlayer2 >= 3) {

                    System.out.printf("3 or more skulls obtained in this turn. Player 2 has finished its turn. Player 2 has %d points in the game \n", player2.score);

                } else {

                    System.out.printf("Player 2 moved on. Player 2 has %d points in the game \n", player2.score);

                }


                //resetting
                player2.coinCount = 0;
                skullCountPlayer2 = 0;
                rollResultPlayer2.clear();


            }


            //display win count
            System.out.printf("Player 1 win count: %d \n", player1.wins);
            System.out.printf("Player 2 win count: %d \n", player2.wins);

            //reset player core for next game
            player1.score = 0;
            player2.score = 0;


            currentGame = currentGame + 1;


        }

        //display wins' percentage for player

        //typecasting to avoid 0 being displayed
        double player1winPercentage = (double) player1.wins / simulation * 100;
        double player2winPercentage = (double) player2.wins / simulation * 100;


        System.out.println("**********************************************************");
        System.out.printf("Player1 win Percentage: %.1f %% \n", player1winPercentage);
        System.out.printf("Player2 win Percentage: %.1f %% \n", player2winPercentage);


    }
}


    class Player

    {
        //A player has some key attributes
        //a dice
        //a score
        //a win counter
        int score;
        Dice dice1;
        int wins;

        int coinCount;

        Player(int score, int wins, int coinCount)

        {
            this.score = score;
            dice1 = new Dice();
            this.wins = wins;
            this.coinCount = coinCount;



        }

    }





