package cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import cardgame.Card.Suit;
import cardgame.Card.Rank;

public class Player2 implements PlayerStrategy {
	//Initialized all necessary members
	public int playerid;
	public int opponentid;
	private List<Card>player2_cards=new ArrayList<>();
	Card currentcard;
	public int score;
	Suit declared;
	// init method initialize playerid and opponent id
	@Override
	public void init(int playerId, int opponentIds) {
			this.playerid =playerId;
			this.opponentid =opponentIds;
	}
	
	@Override
	//This method call once and initialize initial cards
	public void receiveInitialCards(List<Card> cards) {
		this.player2_cards=cards;
	}

	@Override
	//Check whether the wild card is played
	public boolean shouldDrawCard(Card topPileCard, Suit changedSuit) {
		if(changedSuit==null)
			return false;
		else
		{
			declared=changedSuit;
			return true;
		}
	}
	@Override
	// Recieve the opponent drawn card
	public void receiveCard(Card drawnCard) {
		currentcard=drawnCard;
	}
	//Decide which card has to be drawn
	//implemented with if else clause.
	//If wildcard has drawn if block executes.If No wildcard has drawn else blocks executed.But both works same functionality. 
	@Override
	public Card playCard(boolean wildcard) {
		//If wildcard has drawn if block executes.If No wildcard has drawn else blocks executed.
		if(wildcard)
		{
			Card playcard=null;
			Card Wildcard=null;
			int maxRank=-1;
			//I use strategy of eliminating maximum rank card.
			for(Card c:player2_cards)
			{
				if(c.getSuit()==declared)
				{
					if((c.getRank().ordinal()>maxRank))
							{
								playcard=c;
								maxRank=c.getRank().ordinal();
							}
				}
				else if(c.getRank()==Rank.EIGHT)
				{
					Wildcard=c;
				}
			}
			if(playcard==null && Wildcard!=null)
			{
				player2_cards.remove(Wildcard);
				System.out.println("Player 2:"+ player2_cards.size());
				return Wildcard;
			}
			else if(Wildcard==null && playcard==null)
			{
				while(true && !Game.cardDeck.isEmpty())
				{
					if(Game.cardDeck.get(0).getSuit()==declared)
					{
						playcard=Game.cardDeck.get(0);
						Game.cardDeck.remove(0);
						break;
					}
					player2_cards.add(Game.cardDeck.get(0));
					Game.cardDeck.remove(0);
				}
			}
			System.out.println("Player 2:"+ player2_cards.size());	
			return playcard;
		}
		//If No wildcard has drawn else blocks executed.But both works same functionality.
		else
		{
			Suit Currentsuit=currentcard.getSuit();
			Rank Currentrank=currentcard.getRank();
			Card playcard=null;
			Card Wildcard=null;
			int maxRank=-1;
			for(Card c:player2_cards)
			{
				if(c.getRank()==Currentrank||c.getSuit()==Currentsuit)
				{
					if((c.getRank().ordinal()>maxRank))
							{
								playcard=c;
								maxRank=c.getRank().ordinal();
							}
				}
				else if(c.getRank()==Rank.EIGHT)
				{
					Wildcard=c;
				}
			}
			if(playcard==null && Wildcard!=null)
			{
				player2_cards.remove(Wildcard);
				System.out.println("Player 1"+ player2_cards.size());
				return Wildcard;
			}
			else if(Wildcard==null && playcard==null)
			{
				while(true && !Game.cardDeck.isEmpty())
				{
					if(Game.cardDeck.get(0).getRank()==Currentrank || Game.cardDeck.get(0).getSuit()==Currentsuit)
					{
						playcard=Game.cardDeck.get(0);
						Game.cardDeck.remove(0);
						break;
					}
					else {
						player2_cards.add(Game.cardDeck.get(0));
						Game.cardDeck.remove(0);			
					}
				}
			}
			else
			{
				player2_cards.remove(playcard);
			}
			System.out.println("Player 1:"+ player2_cards.size());
			return playcard;
			
		}
	}
	
	//This method used to choose the suit.I use a strategy of selecting suit. Most number of suits present in player hand is choosen.
	@Override
	public Suit declareSuit() {
		//Used Hashmap to store Suits availability.
		HashMap<Suit,Integer> Cardcount=new HashMap<Suit,Integer>();
		Cardcount.put(Suit.DIAMONDS, 0);
		Cardcount.put(Suit.CLUBS, 0);
		Cardcount.put(Suit.SPADES, 0);
		Cardcount.put(Suit.HEARTS, 0);

        for (Card card : player2_cards) {
            switch (card.getSuit()) {
                case DIAMONDS:
                    	Cardcount.replace(Suit.DIAMONDS,(Cardcount.get(Suit.DIAMONDS))+1);
                    break;
                case HEARTS:
                	Cardcount.replace(Suit.HEARTS,(Cardcount.get(Suit.HEARTS))+1);
                    break;
                case SPADES:
                	Cardcount.replace(Suit.SPADES,(Cardcount.get(Suit.SPADES))+1);
                    break;
                case CLUBS:
                	Cardcount.replace(Suit.CLUBS,(Cardcount.get(Suit.CLUBS))+1);
                    break;
                default:
                    break;
            }
        }
        Suit declared=null;
        if(Cardcount.get(Suit.DIAMONDS)>=Cardcount.get(Suit.CLUBS)) 
        	{
        		declared=Suit.DIAMONDS;
        	}
        else
        	{
        	declared=Suit.CLUBS;
        	}
        if(Cardcount.get(Suit.HEARTS)>=Cardcount.get(Suit.SPADES) && Cardcount.get(Suit.HEARTS)>=Cardcount.get(declared))
        	{
        	return Suit.HEARTS;
        	}
        else if(Cardcount.get(Suit.SPADES)>=Cardcount.get(declared))	
        	{
        	return Suit.SPADES;
        	}
        else
        	return declared;
	}

	@Override
	public void processOpponentActions(List<PlayerTurn> opponentActions) {
		// TODO Auto-generated method stub
		
	}
	public int getscore()
	{
		//Used to evalute score of each player.
		for(Card c:player2_cards)
		{
			score+=c.getRank().ordinal()+1;
		}
		return score;
	}
	@Override
	//reset all member values;
	public void reset() {
		this.currentcard=null;
		this.opponentid=0;
		this.player2_cards=null;
		this.playerid=0;
		this.score=0;
	}
}
