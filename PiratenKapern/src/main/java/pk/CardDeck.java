package pk;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CardDeck {

    List <Card> cardDeck = new ArrayList<Card>();
    int cardDeckNumber = 35;

    CardDeck()
    {
        cardDeck.add(new SeaBattleCard(2));
        cardDeck.add(new SeaBattleCard(2));
        cardDeck.add(new SeaBattleCard(3));
        cardDeck.add(new SeaBattleCard(3));
        cardDeck.add(new SeaBattleCard(4));
        cardDeck.add(new SeaBattleCard(4));
        cardDeck.add(new MonkeyBusinessCard());
        cardDeck.add(new MonkeyBusinessCard());
        cardDeck.add(new MonkeyBusinessCard());
        cardDeck.add(new MonkeyBusinessCard());

        for (int i = 0; i < cardDeckNumber - 6; i++)
        {

            cardDeck.add(new NOPCard());

        }

        //shuffle the deck so that the card's positions are not constant
        Collections.shuffle(cardDeck);

    }

    public Card drawCard()
    {

        Card drawnCard = cardDeck.get(0);
        return drawnCard ;

    }


}
