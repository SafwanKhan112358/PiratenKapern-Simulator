package pk;

public class SeaBattleCard extends Card {


    int numSabers;

    SeaBattleCard(int givenSabers)
    {
        super(CardType.SEABATTLE);
        numSabers = givenSabers;

    }
    
    public int getNumbSabers() {

        return numSabers;

    }


}
