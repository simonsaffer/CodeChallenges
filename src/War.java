/**
 * Created by simonsaffer on 2015-10-08.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class War {

  public static void main(String args[]) {

    LinkedList<Card> player1Cards = new LinkedList<>();
    LinkedList<Card> player2Cards = new LinkedList<>();

    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // the number of cards for player 1
    for (int i = 0; i < n; i++) {
      String cardp1 = in.next(); // the n cards of player 1
      player1Cards.add(Card.from(cardp1));
      System.err.print(cardp1 + " ");
    }
    System.err.println();
    int m = in.nextInt(); // the number of cards for player 2
    for (int i = 0; i < m; i++) {
      String cardp2 = in.next(); // the m cards of player 2
      player2Cards.add(Card.from(cardp2));
      System.err.print(cardp2 + " ");
    }
    System.err.println();

    // Write an action using System.out.println()
    // To debug: System.err.println("Debug messages...");

    int nbrOfRounds = 0;
    while(!player1Cards.isEmpty() && !player2Cards.isEmpty()) {

      ++nbrOfRounds;


      int nbrOfCardsForPlayer1 = play(player1Cards, player2Cards, 0);
      if(0 == nbrOfCardsForPlayer1) {
        System.out.println("PAT");
        return;
      } else if(nbrOfCardsForPlayer1 > 0) {
        for(int i = 0; i < nbrOfCardsForPlayer1; i++) {
          Card c = player1Cards.removeFirst();
          player1Cards.addLast(c);
        }
        for(int i = 0; i < nbrOfCardsForPlayer1; i++) {
          Card c = player2Cards.removeFirst();
          player1Cards.addLast(c);
        }
      } else {
        for(int i = 0; i < Math.abs(nbrOfCardsForPlayer1); i++) {
          Card c = player1Cards.removeFirst();
          player2Cards.addLast(c);
        }
        for(int i = 0; i < Math.abs(nbrOfCardsForPlayer1); i++) {
          Card c = player2Cards.removeFirst();
          player2Cards.addLast(c);
        }
      }


    }

    String player = player1Cards.isEmpty() ? "2 " : "1 ";
    System.out.println(player + nbrOfRounds);
  }

  public static int play(List<Card> q1, List<Card> q2, int index) {

    if(index > q1.size() || index > q2.size()) return 0;

    Card c1 = q1.get(index);
    Card c2 = q2.get(index);

    if(c1.beats(c2)) {
      return 1;
    } else if(c2.beats(c1)) {
      return -1;
    } else {
      int chainOfWar = war(q1, q2, index+1);
      if(chainOfWar == 0) return 0;
      else if(chainOfWar > 0) return (1 + chainOfWar);
      else return (-1 + chainOfWar);
    }
  }

  public static int war(List<Card> q1, List<Card> q2, int index) {

    if(index > q1.size() || index > q2.size()) return 0;

    int nbrOfCardsForPlayer1;

    int chainOfWar = play(q1, q2, index+3);
    if(chainOfWar == 0) nbrOfCardsForPlayer1 = 0;
    else if(chainOfWar > 0) nbrOfCardsForPlayer1 = chainOfWar + 3;
    else nbrOfCardsForPlayer1 = chainOfWar - 3;

    return nbrOfCardsForPlayer1;
  }

}

class Card {

  public int value;
  public char suit;

  private Card(int v, char s) {
    this.value = v;
    this.suit = s;
  }

  public boolean beats(Card c) {
    return this.value > c.value;
  }

  public boolean equalVal(Card c) {
    return this.value == c.value;
  }

  public static Card from(String s) {

    String vs = s.substring(0, s.length()-1);
    int v;
    try {
      v = Integer.parseInt(vs);
    } catch (Exception e) {
      switch(vs) {
        case "J":
          v = 11;
          break;
        case "Q":
          v = 12;
          break;
        case "K":
          v = 13;
          break;
        case "A":
          v = 14;
          break;
        default:
          v = -1;
          break;
      }

    }

    return new Card(v, s.substring(s.length()-1).charAt(0));
  }

  @Override
  public String toString(){
    return String.valueOf(value) + suit;
  }

}
