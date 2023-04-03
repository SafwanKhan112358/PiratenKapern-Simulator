package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMechanics {

    private static final Logger logger = LogManager.getLogger(GameMechanics.class.getName());
    private static int GoldDiamondFaceValue = 100;
    private static int PointsForGameWin = 6000;

    private static int threeOfKind = 100;
    private static int fourOfKind = 200;
    private static int fiveOfKind = 500;
    private static int sixOfKind = 1000;
    private static int sevenOfKind = 2000;
    private static int eightOfKind = 4000;

    public static int SkullMin = 3;

    public static List<Players> playersList = new ArrayList<>();



    public static void CalculateWinPercentage(List<Players> givenList)

    {

        logger.info("*****************************************************************");

        for (Players givenPlayer: givenList)
        {


            double playerwinPercentage = (double) givenPlayer.wins / 42 * 100;



            System.out.printf("%s win Percentage: %.1f %% \n", givenPlayer.name, playerwinPercentage);

        }

    }



    //winGameCheck is flawed since it doesn't perfectly adhere to business logic
    public static boolean WinGameCheck(Players player)

    {

        //win check
        if (player.score >= PointsForGameWin)

        {
            //increment win count
            player.wins = player.wins +1;

            //display win message;

            System.out.printf("%s wins the game! \n", player.name);

            //reset all players attributes for next game
            for (Players i: playersList)
            {
                ResetForNextGame(i);
            }

            return true;
        }


        else

        {

            return false;
        }


    }

    //abstracting common game mechanisms
    public static int skullCheck(Players player)

    {

        Integer skullAmount = player.faceOccurence.get(Faces.SKULL);

        return skullAmount.intValue();

    }


    public static void MapPlayerResults (Players player)

    {
        int count = 0;

        //iterate through hashmap and for given Key, find its occurences in the player rollResults and then adjust

        for (Faces givenFace: player.faceOccurence.keySet())
        {

            for (Faces givenRoll: player.rollResults)
            {

                if (givenFace.equals(givenRoll))
                {

                    count = count + 1;

                }


            }

            player.faceOccurence.replace(givenFace,count);
            //reset count
            count = 0;

        }

        System.out.println(player.faceOccurence);


    }

    public static Faces largestFaceSet (Players player)

    {
        Faces largestFaceSet = null;

        //at a player's first roll, the largestFaceSet will be null

        if (player.rollResults.size() != 0)

        {

            //identify my largest set; what is my largest face that holds the set;

            int highestKeyValue = Collections.max(player.faceOccurence.values());

            for (Faces givenFace : player.faceOccurence.keySet())
            {

                //ignore skull
                if (givenFace.equals(Faces.SKULL) == false) {

                    int amount = player.faceOccurence.get(givenFace);


                    if (highestKeyValue == amount) {

                        //just find the first association, and then break out of loop;
                        largestFaceSet = givenFace;

                        return largestFaceSet;

                    }


                }


            }


        }

        return null;

    }

    public static void AssignPoints (Players player)
    {

        player.score = player.score + currentRollPoints(player);

    }

    public static int currentRollPoints (Players player)
    {
        //safeguarding
        if (skullCheck(player) >= GameMechanics.SkullMin)
        {

            return 0;

        }

        else

        {
            int currentRollPoints = PointsDiamondOrGold(player) + PointsCombinations(player);

            return currentRollPoints;

        }


    }


    public static int PointsDiamondOrGold(Players player)

    {

        //safeguarding
        if (skullCheck(player) >= GameMechanics.SkullMin)
        {

            return 0;

        }

        else
        {
            int coinCount = 0;

            for (Faces i: player.rollResults)

            {
                if (i.equals(Faces.DIAMOND) || i.equals(Faces.GOLD))

                {
                    coinCount = coinCount + 1;


                }


            }

            return coinCount*GoldDiamondFaceValue;


        }

    }



    public static int PointsCombinations(Players player)
    {

        int comboScore = 0;

        //traverse through Hashmap and assign the highest combination for the givenFace
        //ignore Skulls
        for (Faces givenFace : player.faceOccurence.keySet())

        {
            if (givenFace.equals(Faces.SKULL) == false)

            {

                if (player.faceOccurence.get(givenFace).equals(8))
                {

                    comboScore = comboScore + eightOfKind;

                }

                else if (player.faceOccurence.get(givenFace).equals(7))
                {

                    comboScore = comboScore + sevenOfKind;


                }

                else if (player.faceOccurence.get(givenFace).equals(6))

                {

                    comboScore = comboScore + sixOfKind;


                }

                else if (player.faceOccurence.get(givenFace).equals(5))

                {

                    comboScore = comboScore + fiveOfKind;


                }

                else if (player.faceOccurence.get(givenFace).equals(4))

                {

                    comboScore = comboScore + fourOfKind;


                }

                else if (player.faceOccurence.get(givenFace).equals(3))

                {

                    comboScore = comboScore + threeOfKind;


                }


            }

        }

        return comboScore;


    }

    //This one is a bit hard to abstract, but it's taking all the players' attributes and resetting them
    //purpose: reset all attributes before the start of the next game;
    public static void ResetForNextGame (Players player)
    {

        player.rollResults.clear();
        player.score = 0;


    }

    public static void ResetForNextTurn (Players player)
    {

        player.rollResults.clear();

    }






}
