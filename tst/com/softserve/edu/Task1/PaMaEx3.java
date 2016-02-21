import java.util.regex.Pattern;
import java.util.Scanner;

public class PaMaEx3 {

    public static void main(String[] args) { 
             System.out.println("Print sequence of nomber");
        Scanner scanIn = new Scanner(System.in);          
             String text = scanIn.nextLine();
             String pat = ".*3.*";

        boolean match = Pattern.matches(pat, text);
        
if (match==true) System.out.println("Realy! Is nomber three " + match);
      else System.out.println("No!Neither nomber three ");
    }
}
