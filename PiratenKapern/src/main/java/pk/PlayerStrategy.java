package pk;
import  pk.Dice;
import pk.Faces;
import pk.Players;
import pk.GameMechanics;

import java.util.Random;


public class PlayerStrategy
{

    private static int pointsMin = 500;

    public static boolean RandomDecisionToContinueOrNot (Players player)

    {
        //to continue or not depends on a random number generator
        Random random = new Random();


        int number = random.nextInt(2);

        if (number == 1)
        {

            return true;

        }

        else

        {

            return false;

        }

    }


    public static boolean CombinationalDecisionToContinueOrNot (Players player)

    {

        //if the points that could be earned in the current roll is more than or equal to 500 OR skullcheck returns is more or equal to 2

        if ((GameMechanics.currentRollPoints(player) >= pointsMin) || (GameMechanics.skullCheck(player) >= 2))

        {

            return false;

        }


        return true;


    }




    public static void RandomPlayerStrategy (Players player)

    {


        //first roll
        Players.rollDice(player);

        while (true)


        {

            if (GameMechanics.skullCheck(player) >= GameMechanics.SkullMin)
            {
                //some print statement
                System.out.printf("3 or more skulls obtained! %s still has %d points in the game \n", player.name, player.score);

                GameMechanics.ResetForNextTurn(player);

                break;

            }


            else
            {
                //print statement for how many dice I can re-roll
                System.out.printf("Current roll points: %d points. %s could continue and can re-roll %d dice  \n", GameMechanics.currentRollPoints(player),player.name, Players.maxDice - GameMechanics.skullCheck(player));

                //player decision
                if (RandomDecisionToContinueOrNot(player) == true)

                {
                    //print statement of wanting to continue
                    System.out.println("Continue! ");

                    //use same rollDice method for randomStrategy
                    Players.rollDice(player);

                }


                else
                {

                    //Assign points based on game rules
                    GameMechanics.AssignPoints(player);

                    //print statement of not wanting to continue
                    System.out.printf("Current roll points: %d points. %s doesn't want to continue. %s has %d points in the game so far \n", GameMechanics.currentRollPoints(player), player.name, player.name, player.score);


                    GameMechanics.ResetForNextTurn(player);

                    break;


                }



            }


        }


    }


    public static void CombinationalPlayerStrategy (Players player)

    {


        //first roll
        Players.rollDice(player);

        while (true)


        {

            if (GameMechanics.skullCheck(player) >= GameMechanics.SkullMin)
            {
                //some print statement
                System.out.printf("3 or more skulls obtained! %s still has %d points in the game \n", player.name, player.score);

                GameMechanics.ResetForNextTurn(player);

                break;

            }


            else
            {
                //print statement for how many dice I can re-roll
                System.out.printf("Current roll points: %d points. %s could continue and re-roll %d dice  \n", GameMechanics.currentRollPoints(player), player.name, Players.maxDice - GameMechanics.skullCheck(player));

                //player decision
                if (CombinationalDecisionToContinueOrNot(player) == true)

                {
                    //print statement of wanting to continue
                    System.out.println("Continue! ");


                    //use of StratReroll for subsequent rolls
                    Players.stratReroll(player);


                }


                else
                {

                    //Assign points based on game rules
                    GameMechanics.AssignPoints(player);

                    //print statement of not wanting to continue
                    System.out.printf("Current roll points: %d points. %s doesn't want to continue. %s has %d points in the game so far \n", GameMechanics.currentRollPoints(player),player.name, player.name, player.score);


                    GameMechanics.ResetForNextTurn(player);

                    break;


                }



            }


        }


    }







}
