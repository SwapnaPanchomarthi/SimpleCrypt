import javax.print.DocFlavor;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Character.*;

public class ROT13  {

    ROT13(Character cs, Character cf) {

    }

    ROT13() {
    }


    public Character getChar(Character ch)
    {
        Map<Character, Character> map=new HashMap<Character, Character>();
        for(int i=97;i<=122;i++)
        {
            if(i<110) {

                map.put((char)i, (char) (i+13));
            }
            else
            { map.put((char)i, (char)(i-13));  }
        }
        return map.get(ch);
    }


    public String crypt(String text) throws UnsupportedOperationException {



        return encrypt(text);
    }


    public String encrypt(String text) {
        String result="";
        char[] charArr = text.toLowerCase().toCharArray();
        //char[] charArr = text.toCharArray();
        for(char ch: charArr)
        {
            if(ch==' ')

                result+=' ';
            else if(ch=='?')
                result+='?';
            else if(ch=='!')
                result+='!';

            else
                result+=getChar(ch);
        }
        System.out.println(result);
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }

    public String decrypt(String text) {

        String result="";
        char[] charArr = text.toLowerCase().toCharArray();
        //char[] charArr = text.toCharArray();
        for(char ch: charArr)
        {
            if(ch==' ')

                result+=' ';
            else if(ch=='?')
                result+='?';
            else if(ch=='!')
                result+='!';

            else
                result+= getChar(ch).charValue();
        }
        //System.out.println(result);
        return result.substring(0, 1).toUpperCase() + result.substring(1);


    }

    public  String rotate(String s, Character c) {
        if((s.charAt(0)=='A') && (c=='A'))
            return s;
        StringBuilder result = new StringBuilder();
        for (int i = (s.length()/2); i < s.length(); i++) {

            result.append(s.charAt(i));
        }
        for (int j = 0; j<s.length()/2 ;j++) {
            result.append(s.charAt(j));
        }


        //System.out.println(result);
        return result.toString();
    }
    public String FileRead(String filePath) {

        String result="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line="";
            while ((line=br.readLine())!=null)
            {
                result+=line+"\n";

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        // return result.substring(0, result.length()-1);
        return result;
    }



//    public void run() throws IOException {
//       // File file = new File("sonnect18.txt");
//    String file="src/main/resources/sonnet18.txt";
//
//        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/sonnet18.txt"));
//       // Scanner scanner = new Scanner(new File(file));
//        //scanner.useDelimiter("[+*/=-?:';]");
//        encrypt(file);
//    }

    public void writeFile(String filePath, String sonnet) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(sonnet);
        bw.flush();
        bw.close();

    }



    public static void main(String[] args) throws IOException {
        ROT13 rot13=new ROT13();
        String currentProjectDirectory = System.getProperty("user.dir");
        String fileName = currentProjectDirectory+"/src/main/resources/sonnet18.txt";
        System.out.println(fileName);
        String test = rot13.FileRead(fileName);

        String fileNew = currentProjectDirectory+"/src/main/resources/sonnetNew";
        rot13.writeFile(fileNew, fileName);
        System.out.println(test);
    }
}



