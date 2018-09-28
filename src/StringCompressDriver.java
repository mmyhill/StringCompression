
import java.util.Scanner;
/*
* StringCompressDriver
* Purpose: The goal of StringCompressDriver is to code!(and understand how to Google)
* Author/s: Morgan Myhill
* 9/25/18
* On My Honor: MM
* Collaborators: Ulysses
*/
public class StringCompressDriver {
    public static void main(String[] args) {
//        System.out.println(Dictionary.disemvowel("PleeaaaaseTakeTheVowelsAEIOUut"));
////        System.out.println((char)((int)'a' - ((int)'a' - (int)'A')));
//
//        System.out.println(Dictionary.simpCompress("aaaabbbbbhhhhhttttttrrrrrr"));//a4b5h5t6r6
//
        Dictionary use = new Dictionary();
//        use.dictCompress("I hope my code works, does my code work, please work code","code");
//        use.dictCompress("I hope my code works, does my code work, please work code","work");
        Scanner s = new Scanner(System.in);
        boolean cont = true;
            System.out.println("What do you want to compress? ");
            String toComp = s.nextLine();
            while (cont) {
                System.out.println("What do you want to replace? ");
                String replace = s.nextLine();
                use.dictCompress(toComp,replace);
                System.out.println("Do you want to add more? (Y/n) ");
                char ifCont = s.nextLine().charAt(0);
                if(ifCont == 'n') cont = false;
            }
    }
}
