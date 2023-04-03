package pk;

import java.util.*;

public class Players {

        public Dice dice;

        public static int maxDice = 8;

        public String name;

        public String strategy;

        public int score;
        public int wins;

        public List<Faces> rollResults;

        public Map<Faces,Integer> faceOccurence;


        public Players(String name, String strategy)

        {
            this.name = name;
            this.strategy = strategy;


            dice = new Dice();
            this.score = 0;
            this.wins = 0;

            rollResults = new ArrayList<>();

            faceOccurence = new HashMap<>(){};

            faceOccurence.put(Faces.MONKEY,0);
            faceOccurence.put(Faces.PARROT,0);
            faceOccurence.put(Faces.GOLD,0);
            faceOccurence.put(Faces.DIAMOND,0);
            faceOccurence.put(Faces.SABER,0);
            faceOccurence.put(Faces.SKULL,0);


        }



        //common mechanisms


    //mechanism that's good to go!
    public static void rollDice (Players player)

    {


        if (player.rollResults.size() == 0)

        {
            for (int i = 0; i < (maxDice); i++)

            {

                player.rollResults.add(player.dice.roll());

            }


        }

        else
        {
            for (int i = 0; i < (maxDice); i++)

            {

                if (player.rollResults.get(i) != Faces.SKULL)

                {

                    player.rollResults.set(i, player.dice.roll());


                }


            }


        }


        System.out.println(player.rollResults);

        GameMechanics.MapPlayerResults(player);

        }


        //During a nonRandom Strategy, this method is used for subsequent rolls. This could apply to sea battle or combo strategy
    public static void stratReroll (Players player)
    {
        //iterate through rollResults
        //when rerolling, can't re-roll skulls and the largest determined set and diamond and gold faces

        for (int i = 0; i < player.rollResults.size(); i++)
        {

            if ((player.rollResults.get(i) != Faces.SKULL) && (player.rollResults.get(i) != GameMechanics.largestFaceSet(player)) && (player.rollResults.get(i) != Faces.DIAMOND) && (player.rollResults.get(i) != Faces.GOLD) )

            {

              player.rollResults.set(i,player.dice.roll());


            }


        }

        System.out.println(player.rollResults);
        GameMechanics.MapPlayerResults(player);


    }


}








