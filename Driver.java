import java.util.Scanner;
public class Driver {
    public static void main(String [] args){
        
    Scanner keyboard = new Scanner (System.in);
    String plainText;
    int userKey;
    System.out.print("Enter a word/phrase you want to encrypt(CAPS): ");
    plainText = keyboard.next();
    System.out.print("Enter your secret cipher key (ANY number):");
    userKey = keyboard.nextInt();
    System.out.println("\n*********************ENCRYPTING*********************");

    Char_encryption c = new Char_encryption(userKey);
    System.out.println("Your ciper text is : " + c.encrypt(plainText)+"\n");
    keyboard.close();

    
    }
    
}
