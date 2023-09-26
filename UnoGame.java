import java.util.ArrayList;
import java.util.Scanner;
public class UnoGame {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
       
        
        

        ArrayList<UnoCard> player = new ArrayList<UnoCard>();
        ArrayList<UnoCard> computer = new ArrayList<UnoCard>();

        for (int i = 0; i < 7; i++) {
            player.add(UnoCard.createCard());
        }

        for (int i = 0; i < 7; i++) {
            computer.add(UnoCard.createCard());
        }
        //System.out.println("My hand: " + player);
        //System.out.println("Computer's hand: " + computer);

        UnoCard current = UnoCard.createCard();
        //player turn
         
        while (player.size() != 0 && computer.size() != 0 ) {
            Scanner a = new Scanner(System.in);
        System.out.println("My hand:");
            for (int i = 0; i < player.size(); i++) {
                System.out.print(" " + (i+1) + "  ");
                
            }
            System.out.println();
            System.out.println(player);
            System.out.println("The top card is " + current);
            System.out.println("Choose a card to play, or press 0 to draw a card.");
            int card = a.nextInt();
            if (card == 0) {
                player.add(UnoCard.createCard());
                
                
            }
            else {
                UnoCard pick = player.get(card-1); 
                boolean cont = UnoCard.compare(pick,current);
                if (!cont)
                    {
                        System.out.println("The card's color or number must match. Pick again.");
                        continue;
                    }
                else {
                    System.out.println("You played a " + pick + ".");
                    current = pick;
                    player.remove(card-1); }
                }
        System.out.println("Computer turn...");
        
        boolean went = false;
        for (int i = 0; i < computer.size(); i++) {
            
                if (((computer.get(i)).getColor()).equals(current.getColor())) {
                    current = computer.get(i);
                    
                    computer.remove(i);
                    went = true;
                    break;

                }
                if (computer.get(i).getNumber() == current.getNumber()) {
                    current = computer.get(i);
                    computer.remove(i);
                    went = true;
                    break;
                }
            }
            if (went == false) {
                computer.add(UnoCard.createCard());
                System.out.println("Computer drew.");
            }
            System.out.println("Computer hand size: " + computer.size());
            
            
        }
        
        if (player.size() == 0) 
            System.out.println("You win!");
        else 
            System.out.println("Computer wins!");
    }

    public static ArrayList computerTurn(ArrayList<UnoCard> computer, UnoCard current) {
        System.out.println("Computer turn...");
        System.out.println(computer);
        boolean went = false;
        for (int i = 0; i < computer.size(); i++) {
            System.out.println(computer.get(i));
                if (((computer.get(i)).getColor()).equals(current.getColor())) {
                    current = computer.get(i);
                    System.out.println(current);
                    computer.remove(i);
                    went = true;
                    break;

                }
                if (computer.get(i).getNumber() == current.getNumber()) {
                    current = computer.get(i);
                    computer.remove(i);
                    went = true;
                    break;
                }
            }
            if (went == false) {
                computer.add(UnoCard.createCard());
                System.out.println("Computer drew.");
            }
            System.out.println("Computer hand size: " + computer.size());
            return computer;
    }

    public static void go(ArrayList<UnoCard> player, UnoCard current) {
        Scanner a = new Scanner(System.in);
        System.out.println("My hand:");
            for (int i = 0; i < player.size(); i++) {
                System.out.print(" " + (i+1) + "  ");
                
            }
            System.out.println();
            System.out.println(player);
            System.out.println("The top card is " + current);
            System.out.println("Choose a card to play, or press 0 to draw a card.");
            int card = a.nextInt();
            if (card == 0) {
                player.add(UnoCard.createCard());
                return;
                
            }
            UnoCard pick = player.get(card-1);
            boolean cont = UnoCard.compare(pick,current);
            if (!cont)
            {
                System.out.println("The card's color or number must match. Pick again.");
                go(player,current);
                
                
            }
            else {
                System.out.println("You played a " + pick + ".");
                current = pick;
                player.remove(card-1);
                
            }
            
    }

}
