package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimulationLoopPiratenKapern {

    private static final Logger logger = LogManager.getLogger(SimulationLoopPiratenKapern.class.getName());

    public static void SimulationLoop(String strategy1, String strategy2) {

        int simulation = 42;
        int currentGame = 1;

        //create 2 new players
        Players player1 = new Players("player1", strategy1);
        GameMechanics.playersList.add(player1);
        Players player2 = new Players("player2", strategy2);
        GameMechanics.playersList.add(player2);


        while (currentGame <= simulation)

        {

            System.out.println("------------------------------------------------------");
            System.out.printf("GAME: %d \n", currentGame);
            //game loop
            gameloop:
            while (true)

            {


                for (Players givenPlayer : GameMechanics.playersList) {

                    if (givenPlayer.strategy.equals("random"))
                    {
                        PlayerStrategy.RandomPlayerStrategy(givenPlayer);
                    }

                    else
                    {
                        PlayerStrategy.CombinationalPlayerStrategy(givenPlayer);

                    }

                    //winCheck
                    if (GameMechanics.WinGameCheck(givenPlayer) == true) {

                        break gameloop;

                    }


                }


            }

            currentGame++;


        }





        //print End of Simulation Win Percentage:
      GameMechanics.CalculateWinPercentage(GameMechanics.playersList);



    }

}
