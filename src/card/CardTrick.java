/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author srinivsi
 * @modifier Marwah AlAnssari - Student# 991837664
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); //insert call to random number generator here
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); //insert call to random number between 0-3 here
            magicHand[i] = c;
        }
        //Loop throught and show the 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            System.out.println(magicHand[i].getSuit() + " " + magicHand[i].getValue());
        }

        //insert code to ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        //create a card
        Card userCard = new Card();

        System.out.print("Enter a card value (1-13) : ");
        int userValue = scanner.nextInt();
        userCard.setValue(userValue);

        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades) : ");
        int suitIndex = scanner.nextInt();
        userCard.setSuit(Card.SUITS[suitIndex]);

        boolean found = false;

        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue()
                    && c.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        scanner.close();
    }

}
