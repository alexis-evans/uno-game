import java.util.ArrayList;
public class UnoCard {
    private String color;
    private int number;

    public UnoCard(int n, String c) {
        color = c;
        number = n;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return (color + number);
    }

    public static UnoCard createCard() {
        int c = (int)(Math.random()*4 + 1);
            String colors = "";
            if (c == 1)
                colors = "R";
            else if (c == 2)
                colors = "Y";
            else if (c == 3)
                colors = "G";
            else 
                colors = "B"; 

            UnoCard card = new UnoCard((int)(Math.random()*9 + 1), colors);
        return card;
    }

    public static boolean compare(UnoCard picked, UnoCard current) {
        if (picked.color.equals(current.color)) {
            return true;
        }
        else if (picked.number == current.number) {
            return true;
        }
        else {
            return false;
        }
    }

    









}