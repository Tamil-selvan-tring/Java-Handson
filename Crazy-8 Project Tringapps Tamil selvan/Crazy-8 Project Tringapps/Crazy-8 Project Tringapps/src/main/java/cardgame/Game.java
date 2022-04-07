package cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import cardgame.Card.Rank;
import cardgame.Card.Suit;
public class Game{
	//First I have stored the deck;
    public static List<Card> cardDeck = new ArrayList<>();
	public static void main(String[] args) 
	{
		Player1 player1=new Player1();
		Player2 player2=new Player2();
		PlayerTurn playerturn=new PlayerTurn();
		boolean declaredsuit=false;
		//player1 will be first turn
		playerturn.playerId=1;
		//I have initialized with two players. And i have intialized player ids and player opponents;
		//player1 and player2 Instance is created.
		//playerscore have been stored
		int player1score=0,player2score=0;
		while(player1score<200 && player2score<200)
		{
			cardDeck=Card.getDeck();
			Collections.shuffle(cardDeck);
			List<Card>player1_cards=new ArrayList<>();
			List<Card>player2_cards=new ArrayList<>();	
			for(int i=1;i<=14;i++)
			{
				if(i%2==0)
				{
					player2_cards.add(cardDeck.get(0));
					System.out.println("player2:"+cardDeck.get(0).getSuit()+cardDeck.get(0).getRank());
				}
				else
				{
					player1_cards.add(cardDeck.get(0));
					System.out.println("player1:"+cardDeck.get(0).getSuit()+cardDeck.get(0).getRank());
				}
				cardDeck.remove(0);
			}	
			player1.init(1,2);
			player1.receiveInitialCards(player1_cards);
			player2.init(2,1);
			player2.receiveInitialCards(player2_cards);
			playerturn.playedCard=cardDeck.get(0);
			cardDeck.remove(0);	
			//loop will run untill deck or cards in player hands are empty.
			while(!cardDeck.isEmpty() && !player1_cards.isEmpty() && !player2_cards.isEmpty())
			{
				if(playerturn.playerId==1)
				{
					if(player1.shouldDrawCard(playerturn.playedCard,playerturn.declaredSuit))
					{ 
						declaredsuit=true;
						playerturn.declaredSuit=null;
					}
					player1.receiveCard(playerturn.playedCard);
					//For reference Cards are displayed
					System.out.println("Player2"+playerturn.playedCard.getRank());
					System.out.println("Player2"+playerturn.playedCard.getSuit());
					playerturn.playedCard=player1.playCard(declaredsuit);
					System.out.println("Decksize:"+cardDeck.size());
					if(playerturn.playedCard==null) 
						break;
					//Check for wildcard;
					if(playerturn.playedCard.getRank()==Rank.EIGHT)
					{
						playerturn.declaredSuit=player1.declareSuit();
					}
					playerturn.playerId=2;
					declaredsuit=false;
				}
				else
				{
					//Same functionality for player2
					if(player2.shouldDrawCard(playerturn.playedCard,playerturn.declaredSuit))
					{ 
						declaredsuit=true;
						playerturn.declaredSuit=null;
					}
					
					player2.receiveCard(playerturn.playedCard);
					System.out.println("Player1"+playerturn.playedCard.getRank());
					System.out.println("Player1"+playerturn.playedCard.getSuit());
					playerturn.playedCard=player2.playCard(declaredsuit);
					if(playerturn.playedCard==null) 
						break;
					if(playerturn.playedCard.getRank()==Rank.EIGHT)
					{
						playerturn.declaredSuit=player1.declareSuit();
					}
					playerturn.playerId=1;
					declaredsuit=false;
				}
			}
			if(cardDeck.isEmpty())
			{
				player1score+=player2.getscore();
				player2score+=player1.getscore();
			}
			else if(player1_cards.isEmpty())
			{
				player1score+=player2.getscore();
			}
			else
			{
				player2score+=player1.getscore();
			}
			System.out.println("player1score:"+player1score);
			System.out.println("player2score:"+player2score);
			player1.reset();
			player2.reset();
			
		}
		if(player1score>player2score)
		{
			System.out.println("Player 1 Wins");
			System.out.println("player1score:"+player1score);

		}
		else
		{
			System.out.println("Player 2 Wins");
			System.out.println("player2score:"+player2score);

		}
	}
}

