import java.io.FileInputStream;
import java.util.Scanner;

public class Char_encryption {
    private char[] plain = new char[26];
    private int key;
    private char[] cipher = new char[26];

    public Char_encryption(){
        initializePlain();
        this.key = 0;
        initializeCipher(this.key);
    }

    public Char_encryption(int cipherKey){
        initializePlain();
        int preferredKey = cipherKey%26;
        int newkey;
        if (preferredKey < 0) {
            newkey = preferredKey+26;
        } else {
            newkey = preferredKey;
        }
        this.key = newkey;
        initializeCipher(this.key);
    }

    public void initializeCipher(int cipherKey) {
        for(int i=0; i < (26-cipherKey); i++){
            this.cipher[i] = this.plain[i+cipherKey];
        }
    
        if(cipherKey != 0){
            for(int i= (26-cipherKey); i< 26; i++){
                this.cipher[i] = this.plain[i+cipherKey-26];
            }
        }
        
    }

    public void initializePlain(){
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream("plainCharacters.txt"));
        } 
        catch (Exception e) {
            System.out.println("Error: The file could not be opened");
            System.exit(0);
        }

        for(int i=0; i<26; i++){
            this.plain[i] = inputStream.next().charAt(0);
        }
    }

    public char encryptHelper(char input){
        char rval;
        int index = 0;

        for(int i=0; i<26; i++){
        if(input==plain[i]){
            index = i;
        }            
        }

        rval = cipher[index];
        
        return rval;
    }

    public boolean convertibleChar(char input){
        for(int i=0; i<26; i++){
            if(input == plain[i])return true;
        }
        return false;
    }

    public String encrypt(String usrInput){
        String rval="";

        for(int i=0; i<usrInput.length();i++){
            char c = usrInput.charAt(i);
            if(convertibleChar(c)){
                rval += encryptHelper(c);
            }
            else{
                rval += c;
            }
        }
        return rval;
    }    

}
