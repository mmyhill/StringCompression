import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* StringCompression
* Purpose: The goal of StringCompression is
* Author/s: Morgan Myhill
* 9/21/18
* On My Honor: MM
* Collaborators: Uly
*/
public class Dictionary {

    private List<String> dict;
   // private int dictSize;

    public static String disemvowel(String in){
        String toReturn = "";
        for(int i = 0; i < in.length(); i++){
            if(toUpper(in.charAt(i)) != 'A' && toUpper(in.charAt(i)) != 'E' && toUpper(in.charAt(i)) != 'I' &&
                    toUpper(in.charAt(i)) != 'O' && toUpper(in.charAt(i)) != 'U') toReturn += in.charAt(i);
        }
        return toReturn;
    }

    private static char toUpper(char in){
        int diff = 'a' - 'A';
        if(in >= 'a' && in <= 'z'){//upper comes before
            return (char)(in - diff);
        }
        else if(in >= 'A' && in <= 'Z') {
            return in;
        }else{
            System.out.println("This char is not a letter");
            return '!';
        }
    }

    public static String simpCompress(String in){
        int row = 1;
        char last = ' ';//cant set to null or empty?
        String toReturn = "";
        int oglength = in.length();
        for(int i = 0; i < oglength; i++){
            if(i == oglength - 1){
                row++;
                toReturn += "" + last + row;
            }
            else if(in.charAt(i) == last)row++;
            else{
                if(i > 0)toReturn += "" + last + row;//wont add "empty" char
                //what should method do if there is for string "stringgg"? s1t1r1i1n1g3
                // or just g3?
                last = in.charAt(i);
                row = 1;
            }
        }
        return toReturn;
    }

    public Dictionary(){
        dict =  new ArrayList();
    }

    public void dictCompress(String in, String toComp){//should this be static???
        dict.add(toComp);
        String toReturn = in;

//        Calculates the compression rate as follows and displays it to the screen: (length of original text - length of
//        compressed text + number of keys in Dict + length of strings Values in Dict) /length of original text

        int dictLength = 0;
        String elemsDict = "{";
        for(int i = 0; i < dict.size(); i++){
            dictLength += dict.get(i).length();
            toReturn = toReturn.replace(dict.get(i), "" + i);
            elemsDict += "" + i + ":" + dict.get(i) + ", ";
        }
        elemsDict = elemsDict.substring(0,elemsDict.length() - 2);
        elemsDict += "}";
        String compressRate = "" + ((in.length() - toReturn.length() + dict.size() + dictLength)/(1.0 * in.length()) * 100);
        System.out.println(toReturn + "\nCompress Rate: " + compressRate.substring(0,compressRate.indexOf(".")+3) + "%");
        System.out.println(elemsDict);

    }

//    public String dictCompress(String in, String toComp){//should this be static???
//        dict.add(toComp);
//        String toReturn = "";
//        //List<String> sepTokens = new ArrayList();
//        String sepTok = "";
//        int lastGoodInd = 0;
//        int numCompress = 0;
//        for(int i = 0; i < in.length(); i++){
//            sepTok += in.charAt(i);
//            if(sepTok.indexOf(toComp) >= 0){//if phrase to compress is found (will be at end!)
//                toReturn += "" + in.substring(lastGoodInd, i - toComp.length()) + (dict.size() - 1);//number replacement will
//                //be ind in dictionary ArrayList
//                lastGoodInd = i - toComp.length();
//                numCompress++;
//            }
//        }
//
//        int count = 1;
//        toReturn += "/n";
//        for(int i = 0; i < dict.size(); i++){
//            toReturn += "" + count + ". " + dict.get(i) + "/n";
//            count++;
//        }
//        dictSize += toReturn.length();
//
////        Calculates the compression rate as follows and displays it to the screen: (length of original text - length of
////        compressed text + number of keys in Dict + length of strings Values in Dict) /length of original text
//
//
//        int compressRate = (in.length() - numCompress * toComp.length() + dict.size() + dictSize)/in.length();
//        toReturn += "Compress Rate = " + compressRate + "/n";
//        return toReturn;
//    }




}
